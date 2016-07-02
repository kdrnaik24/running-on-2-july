<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" 
	        href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css" />
	  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.9/angular.min.js"></script>
	  <script src="js/app.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body ng-app="getAllProjectApp">
	  <div ng-controller="EventsController" class="container">
	
		  <pre>Project Id = <span ng-bind="events.projectId"></span></pre>
	      <pre>Project Name = <span ng-bind="events.projectName"></span></pre>
	   	   <pre>Project Desc = <span ng-bind="events.description"></span></pre>	
	  </div>
	</body>
</html>