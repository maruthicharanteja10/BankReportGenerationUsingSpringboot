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
	<div class="container">
		<h2 class=" pt-3 pb-3">Bank Report Generator</h2>

		<form:form action="searchData" modelAttribute="search" method="POST">
			<table>
				<tr>
					<td>PlanName :</td>
					<td><form:select path="planName">
							<form:option value="">-select-</form:option>
							<form:options items="${names}" />
						</form:select></td>
					<td>PlanStatus :</td>
					<td><form:select path="planStatus">
							<form:option value="">-select-</form:option>
							<form:options items="${status}" />
						</form:select></td>
					<td>Gender :</td>
					<td><form:select path="gender">
							<form:option value="">-select-</form:option>
							<form:options items="${gender}" />
						</form:select></td>
				</tr>
				<tr>
					<td>StartDate:</td>
					<td><form:input type="Date" path="startDate" /></td>
					<td>EndDate:</td>
					<td><form:input type="Date" path="endDate" /></td>
				</tr>
				<tr>
					<td><a href="/" class="btn btn-secondary">Reset</a></td>
					<td><input type="submit" value="Search"
						class="btn btn-primary " /></td>
				</tr>
			</table>
		</form:form>
		<hr />
		<table class="table table-striped table-hover">
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
		Export : <a href="" class="btn btn-secondary pb-1 pt-1">Excel</a> <a
			href="" class="btn btn-secondary pb-1 pt-1 ">Pdf</a>
	</div>

</body>
</html>