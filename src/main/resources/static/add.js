var app = angular.module("spoonApp",[]);
app.controller("spoonController",function ($scope, $http) {

    $scope.hidden_img=false;

    $scope.user=[];

    $scope.uploadFile = function(files) {
        var fd = new FormData();
        fd.append("img", files[0]);
        $http({
            url: 'http://localhost:8080/img',
            method: 'POST',
            data: fd,
            headers: { 'Content-Type': undefined },
            transformRequest: angular.identity,
            transformResponse: String

        }).then(function(file_name){
            $scope.img_model=file_name.data;
            $scope.hidden_img=true;
        });

    };
    angular.element(document).ready(function () {
        $http.get('http://localhost:8080/user').then(function (user) {
            $scope.user=user.data.username;
        });

    });
});
