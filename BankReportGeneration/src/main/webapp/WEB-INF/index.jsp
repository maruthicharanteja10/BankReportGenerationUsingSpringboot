<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<style>
.container {
	color: #ffffff;
}
</style>
</head>

<body class="img-responsive"
	style="background-image:url(<c:url value='/img/img-1.png' />);  background-size: cover;">
	<h2 class="text-center pb-3 pt-3 text-white sticky-top img-responsive"
		style="background-image:url(<c:url value='/img/bg.jpg' />);">Bank
		Report Generator</h2>
	<br>
	<div class="container">
		<form:form action="searchData" modelAttribute="search" method="POST">
			<div class="row mb-4">
				<div class="col-md-6">
					<label for="planName" class="form-label">Plan Name:</label>
					<form:select path="planName" class="form-control" id="planName">
						<form:option value="">-select-</form:option>
						<form:options items="${names}" />
					</form:select>
				</div>
				<div class="col-md-6">
					<label for="planStatus" class="form-label">Plan Status:</label>
					<form:select path="planStatus" class="form-control" id="planStatus">
						<form:option value="">-select-</form:option>
						<form:options items="${status}" />
					</form:select>
				</div>
			</div>

			<div class="row mb-4">
				<div class="col-md-6">
					<label for="gender" class="form-label">Gender:</label>
					<form:select path="gender" class="form-control" id="gender">
						<form:option value="">-select-</form:option>
						<form:option value="Male">Male</form:option>
						<form:option value="Female">Female</form:option>
					</form:select>
				</div>
				<div class="col-md-3">
					<label class="form-label">Start Date:</label>
					<form:input type="date" path="startDate" class="form-control"
						id="startDate" />
				</div>
				<div class="col-md-3">
					<label class="form-label">End Date:</label>
					<form:input type="date" path="endDate" class="form-control"
						id="endDate" />
				</div>
			</div>

			<div class="text-center">
				<a href="/" class="btn btn-secondary btn-custom">Reset</a> <input
					type="submit" value="Search" class="btn btn-primary btn-custom" />
			</div>
		</form:form>


	</div>
</body>
</html>
