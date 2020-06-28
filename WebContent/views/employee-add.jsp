<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Employee</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
</head>
<body>
	<div class="float-right">
		<a href="${pageContext.request.contextPath}/logout.jsp">Logout</a>
	</div>
	<div class="container">
		<h1>Employee Directory</h1>
		<hr/>
		<div class="row">
		  <div class="col-md-4">
			<form action="${pageContext.request.contextPath}/EmployeeController" method="POST">
			<div class="form-group">
				<input class="form-control" type="text" name="firstname" value="${employee.getName()}" placeholder="Enter name" /><br/>
			</div>
			<div class="form-group">
				<input class="form-control" type="date" name="dob" value="${employee.getDob()}" placeholder="Enter date of birth" /><br/>
			</div>
			<div class="form-group">
			    <input class="form-control" type="text" name="department" value="${employee.getDepartment()}" placeholder="Enter department" /><br/>
			</div>
        	<input type="hidden" name="id" value="${employee.getId()}"/>
    		<button class="btn btn-primary" type="submit">Save Employee</button>
			</form>  
		  </div>
		</div>
	</div>
</body>
</html>