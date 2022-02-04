<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Material</title>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<nav class="navbar navbar-expand-md navbar-light">
		<div>
			<a class="navbar-brand"> Material Management Application </a>
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
				<c:if test="${material != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${material == null}">
					<form action="insert" method="post">
				</c:if>
				<caption>
					<h2>
						<c:if test="${material != null}">
Edit Material
</c:if>
						<c:if test="${material == null}">
Add New Material
</c:if>
					</h2>
				</caption>
				<c:if test="${material != null}">
					<input type="hidden" name="oriTitle"
						value="<c:out
value='${material.title}' />" />
				</c:if>
				<fieldset class="form-group">
					<label>Title</label> <input type="text"
						value="<c:out
value='${material.title}' />" class="form-control"
						name="title" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>Description</label> <input type="text"
						value="<c:out
value='${material.description}' />" class="form-control"
						name="description">
				</fieldset>
				<fieldset class="form-group">
					<label>Text</label> <input type="text"
						value="<c:out
value='${material.text}' />" class="form-control"
						name="text">
				</fieldset>
				<fieldset class="form-group">
					<label> Language</label> <input type="text"
						value="<c:out
value='${material.url}' />" class="form-control"
						name="url">
				</fieldset>
				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>