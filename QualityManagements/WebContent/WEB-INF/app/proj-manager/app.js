/**
 * 	
 */

angular.module("projApp",['ngRoute','ui.bootstrap']);

angular.module("projApp").config(['$routeProvider','$logProvider',function($routeProvider,$logProvider){
	
	$logProvider.debugEnabled(true);
	
	$routeProvider
	.when('/',{
		templateUrl : 'app/proj-manager/partials/index.html',
		controller : 'ProjectCtrl'
	})
	.when('/newproject',{
		templateUrl : 'app/proj-manager/partials/add.html',
		controller : 'ProjectCtrl'
	})
	
	.when('/view',{
		templateUrl : 'app/proj-manager/partials/project.html',
		controller : 'ProjectCtrl'
	})
	
	.when('/addproj',{
		templateUrl : 'app/proj-manager/partials/addToPort.html',
		controller:'PortFolioController'
	})
	.when('/removeproj',{
		templateUrl : 'app/proj-manager/partials/removeFromPort.html',
		controller:'PortFolioController'
	})
	
	.otherwise({
		redirectTo : '/'
	});
	
}]);