<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>E-Learning Platform</title>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<style>
.center {
	margin: 0;
	position: relative;
	left: 45%;
}

.maincontainer {
	margin-top: 50px;
	margin-bottom: 50px;
	margin-left: auto;
	margin-right: auto;
	width: 550px;
	height: 500px;
	background: none;
}

.thecard {
	position: relative;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	border-radius: 10px;
	transform-style: preserve-3d;
	transition: all 0.8s ease;
}

.thecard:hover {
	transform: rotateY(180deg);
}

.thefront {
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	border-radius: 10px;
	backface-visibility: hidden;
	overflow: hidden;
	background: #2885ff;
	color: #000;
}

.theback {
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	border-radius: 10px;
	backface-visibility: hidden;
	overflow: hidden;
	background: #fafafa;
	color: #333;
	text-align: center;
	transform: rotateY(180deg);
}

.thefront h1, .theback h1 {
	font-family: 'zilla slab', sans-serif;
	padding: 30px;
	font-weight: bold;
	font-size: 30px;
	text-align: center;
}

.thefront h2, .theback h2 {
	font-family: 'zilla slab', sans-serif;
	padding: 30px;
	font-weight: bold;
	font-size: 18px;
	text-align: center;
}

.thefront p, .theback p {
	font-family: 'zilla slab', sans-serif;
	padding: 30px;
	font-weight: normal;
	font-size: 18px;
	text-align: center;
}
</style>
</head>

<body>
	<div class="row">
		<div class="maincontainer">
			<h3 class="text-center">List of Materials</h3>
			<hr>
			<div class="container text-center">
				<!-- Add new user button redirects to the register.jsp page -->
				<a href="<%=request.getContextPath()%>/creatematerial.jsp"
					class="btn btn-danger">Add New Material</a>
			</div>
			<br>

			<c:forEach var="material" items="${listMaterials}">
				<div class="thecard">
					<div class="thefront">
						<h1>
							<c:out value="${material.title}" />
						</h1>
						<p>
							<c:out value="${material.description}" />
						</p>
					</div>

					<div class="theback">
						<p>
							<c:out value="${material.text}" />
						</p>
						<p>
							<a href="edit?title=<c:out value='${material.title}' />">Edit</a>
							&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?title=<c:out value='${material.title}' />">Delete</a>
						</p>
					</div>
				</div>
				<p class="text-center">
					<a href="<c:out value="${material.url}" />">Read More</a>
				</p>
				<br>
			</c:forEach>
		</div>
	</div>
</body>
</html>