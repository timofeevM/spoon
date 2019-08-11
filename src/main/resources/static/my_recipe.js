var app = angular.module("spoonApp",[]);
app.controller("spoonController",function ($scope, $http) {


    $scope.user=[];
    $scope.recipes=[];


    $http.get('http://localhost:8080/my_recipes').then(function (recipes) {
        $scope.recipes=recipes.data;
    });

    angular.element(document).ready(function () {
        $http.get('http://localhost:8080/user').then(function (user) {
                $scope.user=user.data.username;
        });

    });


    $scope.clicking_on_like=function (recipe) {
        $http({
            method: 'POST',
            url: 'http://localhost:8080/likes',
            headers: {'Content-Type': 'application/json'},
            data: recipe

        }).then(function(likes){
            if (recipe.like_icon=="like.png"){
                recipe.like_icon="dislike.png";
            } else {
                recipe.like_icon="like.png";
            }
            recipe.likes=likes.data;
        });
    };


    $scope.clicking_on_save=function (recipe) {
        $http({
            method: 'POST',
            url: 'http://localhost:8080/saves_recipe',
            headers: {'Content-Type': 'application/json'},
            data: angular.toJson(recipe)

        }).then(function(){
            if (recipe.save_icon=="save-icon.png"){
                recipe.save_icon="save-icon-no.png";
            } else {
                recipe.save_icon="save-icon.png";
            }
        });
    };


    $scope.checked_like=function (recipe){
        $http({
            method: 'POST',
            url: 'http://localhost:8080/checked_like',
            headers: {'Content-Type': 'application/json'},
            data: angular.toJson(recipe)

        }).then(function(result){
            if (result.data==true){
                recipe.like_icon="like.png";
            }else {
                recipe.like_icon="dislike.png";
            }

        });
    };


    $scope.checked_save=function (recipe){
        $http({
            method: 'POST',
            url: 'http://localhost:8080/checked_save',
            headers: {'Content-Type': 'application/json'},
            data: angular.toJson(recipe)

        }).then(function(result){
            if (result.data==true){
                recipe.save_icon="save-icon.png";
            }else {
                recipe.save_icon="save-icon-no.png";
            }
        });
    };

    $scope.delete=function (recipe) {
        if (confirm("Вы действительно хотите удалить рецепт "+ recipe.name + "?")) {
            $http({
                method: 'POST',
                url: 'http://localhost:8080/delete',
                headers: {'Content-Type': 'application/json'},
                data: recipe

            }).then(function () {
                $http.get('http://localhost:8080/my_recipes').then(function (recipes) {
                    $scope.recipes = recipes.data;
                });
            });
        }
    };
});