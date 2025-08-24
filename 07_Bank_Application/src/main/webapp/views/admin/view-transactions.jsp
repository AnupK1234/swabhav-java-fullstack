<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>USER TRANSACTIONS</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<jsp:include page="/views/common/navbar.jsp" />

	<div class="container mt-5">
		<h2 class="mb-4">TRANSACTIONS</h2>
		<c:choose>
			<c:when test="${not empty allTransaction}">
				<table class="table table-bordered table-striped">
					<thead class="table-dark">
						<tr>
							<th>Transaction Id</th>
							<th>Sender Acc</th>
							<th>Receiver Acc</th>
							<th>Type</th>
							<th>Amount</th>
							<th>Date</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="txn" items="${allTransaction}">
							<tr>
								<td>${txn.getId()}</td>
								<td>${txn.getFrom_account()}</td>
								<td>${txn.getTo_account()}</td>
								<td><c:if test="${txn.getType() == 'TRANSFER'}">
										<span class="text-danger">${txn.getType()}</span>
									</c:if> <c:if test="${txn.getType() == 'CREDIT'}">
										<span class="text-success">${txn.getType()}</span>
									</c:if></td>

								<td>${txn.getAmount()}</td>
								<td>${txn.getDate()}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:when>
			<c:otherwise>
				<div class="alert alert-info">No transactions found!</div>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>
