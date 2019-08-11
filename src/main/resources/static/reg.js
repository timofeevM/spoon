var app = angular.module("spoonApp",[]);
app.controller("spoonController",function ($scope, $http) {
    $scope.visible_pass=false;
    $scope.visible_ok=false;
    $scope.visible_name=false;

    $scope.registration=function (username,password,re_password) {
        if (re_password==password){
            $http({
                method: 'POST',
                url: 'http://localhost:8080/registration',
                headers: {'Content-Type': 'application/json'},
                data: ({'username':username,'password': password})

            }).then(function(value){
                if (value.data==true){
                    $scope.visible_name=false;
                    $scope.visible_pass=false;
                    $scope.visible_ok=true;
                } else {
                    $scope.visible_pass=false;
                    $scope.visible_name=true;
                    $scope.visible_ok=false;
                }
            });
        }else {
            $scope.visible_pass=true;
            $scope.visible_ok=false;
            $scope.visible_name=false;
        }
    };
});