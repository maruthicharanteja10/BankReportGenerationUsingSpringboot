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
	background-color: #B3C8CF;
	background-size: cover;
	padding: 20px;
	border-radius: 15px;
}
</style>
</head>

<body>
	<h2 class="text-center bg-dark  pb-3 pt-3 text-white sticky-top">Bank
		Report Generator</h2>
	<br>
	<div class="container">

		<br>
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


		<hr />

		<div class="table-responsive">
			<table class="table table-striped table-hover">
				<thead class="table-dark">
					<tr>
						<th>ID</th>
						<th>Holder Name</th>
						<th>Gender</th>
						<th>Plan Name</th>
						<th>Plan Status</th>
						<th>Start Date</th>
						<th>End Date</th>
						<th>Benefit Amount</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${plans}" var="plan" varStatus="index">
						<tr>
							<td>${index.count}</td>
							<td>${plan.citizenName}</td>
							<td>${plan.gender}</td>
							<td>${plan.planName}</td>
							<td>${plan.planStatus}</td>
							<td>${plan.planStartDate}</td>
							<td>${plan.planEndDate}</td>
							<td>${plan.benfitAmt}</td>
						</tr>
					</c:forEach>
					<c:if test="${empty plans}">
						<tr>
							<td colspan="8" class="text-center">No records found</td>
						</tr>
					</c:if>
				</tbody>
			</table>
		</div>

		<div class="text-center">
			<a href="/excel" class="btn btn-success ">Export to Excel</a> <a
				href="/pdf" class="btn btn-danger">Export to PDF</a>
		</div>
	</div>
</body>
</html>
