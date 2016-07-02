<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" 
	        href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css" />
	  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.9/angular.min.js"></script>
	  <script src="/js/login.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body ng-app="myloginApp">
<form ng-submit="login(username, password)">
  <label>User name</label>
  <input type="text" ng-model="username" class="ng-pristine ng-valid">
  <label>Password</label>
  <input type="password" ng-model="password" class="ng-pristine ng-valid">
  <br/>
 <span ng-bind="message"></span>
  <br/><br/>
  <button class="btn btn-success" ng-click="">Submit</button>
  <button class="btn btn-warning" ng-click="cancel()">Cancel</button>
</form>
</body>
</html>