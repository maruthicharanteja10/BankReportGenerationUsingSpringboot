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
</head>

<body>
	<div>

		<h2 class=" pt-3 pb-3 bg-dark text-white text-center">Bank Report
			Generator</h2>

		<form:form action="searchData" modelAttribute="search" method="POST">
			<table class="container mb-5 mt-4">
				<tr>
					<td>PlanName :</td>
					<td><form:select path="planName" class="form-control">
							<form:option value="">-select-</form:option>
							<form:options items="${names}" />
						</form:select></td>
				</tr>
				<tr>
					<td>PlanStatus :</td>
					<td><form:select path="planStatus" class="form-control">
							<form:option value="">-select-</form:option>
							<form:options items="${status}" />
						</form:select></td>
				</tr>
				<tr>
					<td>Gender :</td>
					<td><form:select path="gender" class="form-control">
							<form:option value="">-select-</form:option>
							<form:option value="Male" />
							<form:option value="FeMale" />
						</form:select></td>
				</tr>
				<tr>
					<td>StartDate:</td>
					<td><form:input type="Date" path="startDate"
							class="form-control" /></td>
					<td>EndDate:</td>
					<td><form:input type="Date" path="endDate"
							class="form-control" /></td>
				</tr>

				<tr>
					<td><a href="/" class="btn btn-secondary">Reset</a></td>
					<td><input type="submit" value="Search"
						class="btn btn-primary " /></td>
				</tr>

			</table>
		</form:form>
		<hr />
		<table class="table table-striped table-hover container">
			<thead class="table-dark">
				<tr>
					<td>ID</td>
					<td>Holder Name</td>
					<td>Gender</td>
					<td>Plan Name</td>
					<td>Plan Status</td>
					<td>Start Date</td>
					<td>End Date</td>
					<td>BenifitAmt</td>
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
				<c:if test="${empty plans }">
					<td colspan="8" style="text-align: center">No records Found</td>
				</c:if>
			</tbody>
		</table>

		<hr />

		<div class="container">
			Export : <a href="/excel" class="btn btn-secondary pb-1 pt-1">Excel</a>
			<a href="/pdf" class="btn btn-secondary pb-1 pt-1 ">Pdf</a>
		</div>

	</div>

</body>
</html>