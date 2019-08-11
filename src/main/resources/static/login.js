var app = angular.module("spoonApp",[]);
app.controller("spoonController",function ($scope, $http) {
    $scope.visible_error=false;
    $scope.visible_exit=false;

    if(window.location.search.indexOf('?error') != -1){
        $scope.visible_error=true;
    }else {
        $scope.visible_error=false;
    }

    if(window.location.search.indexOf('?logout') != -1){
        $scope.visible_exit=true;
    }else {
        $scope.visible_exit=false;
    }
});