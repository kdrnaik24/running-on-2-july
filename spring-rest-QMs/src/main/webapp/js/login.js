var myevents = angular.module('myloginApp', []);

myloginApp.controller('AppCtrl', function($scope, authentication) {
  $scope.templates =
  [
    { url: 'login.html' },
    { url: 'home.html' }
  ];
    $scope.template = $scope.templates[0];
  $scope.login = function (username, password) {
	  
    if ( username === 'admin' && password === '1234') {
        authentication.isAuthenticated = true;
        $scope.template = $scope.templates[1];
        $scope.message = username;
    } else {
        $scope.message = "Invalid username/password combination";
    };
  };

});