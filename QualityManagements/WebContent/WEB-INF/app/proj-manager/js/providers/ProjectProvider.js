angular.module('projApp').provider('ProjectService',function(){
	var baseUrl = "http://localhost:8080/spring-rest-QM/";
	var relativeUrl = "rest/projectServ/"
	return {
		setBaseUrl:function(value){
			baseUrl = value;
		},
		setRelativeUrl:function(value){
			relativeUrl = value;
		},
		$get:function($http,$q,$log){
			return{
				list : function(){
					var url="getAllProject";
					var deferred = $q.defer();
					$log.debug("sending [get] at "+baseUrl+relativeUrl+url);
					debugger;
					$http.get(baseUrl+relativeUrl+url)
				
					.then(function(data){
						debugger;
						deferred.resolve(data);
					},function(error){
						alert(error);
					});
					return deferred.promise;
					
				},
				addProject : function(proj){
					var url="addProject";
					var deferred = $q.defer();
					$log.debug("sending [post] at "+baseUrl+relativeUrl+url);
					$http.post(baseUrl+relativeUrl+url,proj)
					.then(function(data){
						deferred.resolve(data);
					},function(error){
						alert(error);
					});l
					return deferred.promise;
					
				},
				removeProject : function(proj){
					var url="deleteproject";
					var deferred = $q.defer();
					$log.debug("sending [delete] at "+baseUrl+relativeUrl+url+"/"+proj.projectId+" with data :"+proj);
					$http({
						url:baseUrl+relativeUrl+url+"/"+proj.projectId,
						method:'DELETE',
					})
					.then(function(data){
						deferred.resolve(data);
					},function(error){
						alert(error);
					});
					return deferred.promise;
				},
				getProject : function(proj){
					var url="get";
					var deferred = $q.defer();
					$log.debug("sending [get] at "+baseUrl+relativeUrl+url+"/"+proj.projectId+" with data :"+proj);
					$http({
						url:baseUrl+relativeUrl+url+"/"+proj.projectId,
						method:'GET',
					})
					.then(function(data){
						deferred.resolve(data);
					},function(error){
						alert(error);
					});
					return deferred.promise;
				},
				updateProject : function(proj){
					var url="updateProject";
					console.log(proj);
					var deferred = $q.defer();
					$log.debug("sending [put] at "+baseUrl+relativeUrl+url+"/"+proj.projectId+" with data :"+proj);
					$http.put(baseUrl+relativeUrl+url+"/"+proj.projectId,proj.projectId,proj)
					.then(function(data){
						deferred.resolve(data);
					},function(error){
						alert(error);
					});
					return deferred.promise;
				}
			}
		}
	};
});
