<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
</head>

<body>
	<button class="btn btn-primary" onclick="window.location.href='views/employee-add.jsp'">
	    Add an employee
	</button>
    <div class="container">
      <p>${message}</p>
        <table border="1" class="table table-striped table-bordered">
      <tr class="thead-dark">
        <th>Name</th>
        <th>Department</th>
        <th>DoB</th>
      </tr>
      <c:forEach items="${list}" var="employee">
        <tr>
          <td>${employee.getName()}</td>
          <td>${employee.getDepartment()}</td>
          <td>${employee.getDob()}</td>
        </tr>
      </c:forEach>
      </table>
    </div>
</body>
</html>