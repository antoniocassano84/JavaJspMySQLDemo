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

	<div class="container">
		<form action="${pageContext.request.contextPath}/EmployeeController" method="POST">
			Enter name: <input type="text" name="firstname"/><br/>
	    	Enter date of birth: <input type="date" name="dob"/><br/>
        	Enter department: <input type="text" name="department"/><br/>
    		<button class="btn btn-primary" type="submit">Save Employee</button>
		</form>
	</div>
</body>
</html>