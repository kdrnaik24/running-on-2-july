angular.module("projApp").controller("ProjectCtrl",["$scope","$uibModal","ProjectService",function($scope,$uibModal,projService){
	$scope.proj = {};
	$scope.projs = [];
	$scope.search = {
			searchFor:"",	
			searchBy:"id"
		};
	//confirmation Modal
	$scope.confirmModal = {};
	
	$scope.openConfirm = function () {
	     $scope.confirmModal = $uibModal.open({
	      animation: true,
	      templateUrl: 'newProjectConfirmationModal.html',
	      scope : $scope
	    });
	};
	
	$scope.dismissConfirm = function(){
		$scope.confirmModal.dismiss();
	}
	
	//alert messages
	 $scope.alerts = [];

	 $scope.addAlert = function(intype,inmsg) {
		 $scope.alerts.push({type:intype,msg: inmsg});
	 };

	 $scope.closeAlert = function(index) {
	     $scope.alerts.splice(index, 1);
	 };
	//http calls
	$scope.refresh = function(){
		projService.list()
		.then(function(response){
			debugger;
			$scope.projs = response.data;
			debugger;
		});
	}
	$scope.add = function(){
		console.log("add called");
		projService.addProject($scope.proj).then(
				function(response){
					var data = response.data;
					var msg = data.name+" added successfully with id as "+data.projectId;
					$scope.addAlert("success",msg);
					$scope.dismissConfirm();
					$scope.proj={};
				},
				function(error){
					$scope.addAlert("danger","Some error occured on server side");
					$scope.dismissConfirm();
				}
		)
	}
	$scope.remove = function(proj){
		proj = JSON.parse(angular.toJson(proj));
		projService.removeProject(proj)
		.then(function(response){
			alert(response.data+" removed successfully");
			$scope.refresh();
		})
	};
	
	$scope.updateTry = function(proj){
		proj = JSON.parse(angular.toJson(proj));
		projService.getProject(proj)
		.then(function(response){
			$scope.project = response.data;
			 $scope.confirmModal = $uibModal.open({
			      animation: true,
			      templateUrl: 'updateProjectConfirmationModal.html',
			      scope : $scope
			    });
		})
	};

	$scope.$watch('search.searchBy',function(){
		console.log("here");
		$scope.search.searchFor="";
		$scope.search.searchFor.id="";
		$scope.search.searchFor.name="";
		$scope.search.searchFor.type="";
		$scope.search.searchFor.startdate="";
		
	});
	//sorting logic
	$scope.sortColumn="projectid";
	$scope.desc = false;
	
	$scope.sort = function(column){
		if($scope.sortColumn == column){
			$scope.desc = !$scope.desc;
		}
		else{
			$scope.sortColumn = column;
			$scope.desc = false;
		}
	};
	$scope.sortClass = function(column){
		if($scope.sortColumn == column){
			return $scope.desc == true ? 'arrow-down' : 'arrow-up'; 
		}
		return 'gap';
	};
	$scope.update = function(project){
		
		console.log($scope.project);
		proj = JSON.parse(angular.toJson(project));
		projService.updateProject($scope.project)
		.then(function(response){
			alert(response.data+" updated successfully");
			$scope.dismissConfirm();
			$scope.refresh();
		});
	};
}]);