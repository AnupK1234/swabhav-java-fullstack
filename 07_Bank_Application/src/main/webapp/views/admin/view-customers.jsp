<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Customers</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<jsp:include page="/views/common/navbar.jsp" />
	<div class="container mt-5">
		<h2 class="mb-4">Customer List</h2>
		<table class="table table-bordered table-striped">
			<thead class="table-dark">
				<tr>
					<th>ID</th>
					<th>Username</th>
					<th>Name</th>
					<th>Email</th>
					<th>Account Number</th>
					<th>Balance</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="customer" items="${customers}">
					<tr>
						<td>${customer.id}</td>
						<td>${customer.username}</td>
						<td>${customer.name}</td>
						<td>${customer.email}</td>
						<td>${customer.accountNumber}</td>		
						<td>${customer.balance}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
