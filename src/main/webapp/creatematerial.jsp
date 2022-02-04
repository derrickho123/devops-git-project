<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Create Platform Material</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<nav class="navbar navbar-expand-md navbar-light">
		<div>
			<a class="navbar-brand"> Create Platform Material</a>
		</div>
		<ul class="navbar-nav">
			<li><a
				href="<%=request.getContextPath()%>/MaterialServlet/dashboard"
				class="nav-link">Back to Dashboard</a></li>
		</ul>
	</nav>

	<div class="container col-md-6">
		<div class="card">
			<div class="card-body">

				<form action="CreateServlet" method="post">
					<fieldset class="form-group">
						<label>Title</label> 
						<input type="text" class="form-control" name="title" required="required">
					</fieldset>
					<fieldset class="form-group">
						<label>Description</label> 
						<input type="text" class="form-control" name="description" required="required">
					</fieldset>
					<fieldset class="form-group">
						<label>Text</label> 
						<input type="text" class="form-control" name="text" required="required">
					</fieldset>
					<fieldset class="form-group">
						<label>Url</label> 
						<input type="text" class="form-control" name="url" required="required">
					</fieldset>
					<button type="submit" value="Create Material "class="btn btn-success">Create</button>
				</form>

			</div>
		</div>
	</div>
</body>
</html>