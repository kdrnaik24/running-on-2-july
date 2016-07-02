var myevents = angular.module('getAllProjectApp', []);

myevents.controller("EventsController", function ($scope, $http) {
    $http.get('http://localhost:8080/spring-rest-QM/rest/projectServ/get/1')
        .success(function (data) {
            $scope.events = data;
            console.log("in contoller method");
        });
});

