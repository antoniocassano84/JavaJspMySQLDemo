<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs4/dt-1.10.21/datatables.min.css"/>
</head>

<body>

	<%
		String email = (String) session.getAttribute("email");
		if(email == null) {
			response.sendRedirect("index.jsp");
		}
	%>
	<button class="btn btn-primary" onclick="window.location.href='views/employee-add.jsp'">
	    Add an employee
	</button>
    <div class="container">
    	<div class="float-right">
		    <a href="${pageContext.request.contextPath}/logout.jsp">Logout</a>
	    </div>
      <p>${message}</p>
      <table border="1" class="table table-striped table-bordered" id="datatable">
      <thead>
      	  <tr class="thead-dark">
          <th>Name</th>
          <th>Department</th>
          <th>DoB</th>
          <th>Actions</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach items="${list}" var="employee">
          <tr>
            <td>${employee.getName()}</td>
            <td>${employee.getDepartment()}</td>
            <td>${employee.getDob()}</td>
            <td>
            	<a href="${pageContext.request.contextPath}/EmployeeController?action=EDIT&id=${employee.getId()}">Edit</a>
            	 | 
                <a href="${pageContext.request.contextPath}/EmployeeController?action=DELETE&id=${employee.getId()}">Delete</a>
            </td>
          </tr>
        </c:forEach>      
      </tbody>

      </table>
    </div>
    <!-- https://unpkg.com/jquery@3.3.1/dist/jquery.min.js -->
    <script src="https://unpkg.com/jquery@3.3.1/dist/jquery.min.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/v/bs4/dt-1.10.21/datatables.min.js"></script>
    <script>
    	$(document).ready(function() {
    		$("#datatable").DataTable();
    	})
    </script>
</body>
</html>