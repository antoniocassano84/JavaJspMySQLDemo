<html>
	<head>
		<title>Login</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" />
	</head>
	<body>
	
	<%
		String email = (String) session.getAttribute("email");
		if(email != null) {
			response.sendRedirect("EmployeeController?action=LIST");
		}
		String status = request.getParameter("status");
		if(status != null) {
			if(status.equals("false")) {
				out.print("Invalid email/password");
			} else if(status.equals("error")) {
				out.print("Some error occurred");
			}
		}
	%>
	
		<div class="container">
			<form action="Loginprocess" method="post">
				<div class="card">
					<div class="card-header">Login</div>
					<div class="card-body">
						<div class="form-group">
							<input type="text" name="email" class="form-control" placeholder="Enter email" />
						</div>
						<div class="form-group">
							<input type="password" name="password" class="form-control" placeholder="Enter password" />
						</div>
					</div>
					<div class="card-footer">
						<input type="submit" name="Login" class="btn btn-primary"/> 
					</div>				
				</div>
			</form>
		</div>
	</body>
</html>