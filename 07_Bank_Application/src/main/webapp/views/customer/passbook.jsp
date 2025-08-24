<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Passbook</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<jsp:include page="/views/common/navbar.jsp" />

	<div class="container mt-5">
		<h2 class="mb-4">Passbook</h2>

		<!-- Filter Section -->
		<div class="row mb-3">
			<div class="col-md-3">
				<input type="date" id="startDate" class="form-control"
					placeholder="Start Date">
			</div>
			<div class="col-md-3">
				<input type="date" id="endDate" class="form-control"
					placeholder="End Date">
			</div>
			<div class="col-md-3">
				<select id="txnType" class="form-select">
					<option value="">All Types</option>
					<option value="CREDIT">Credit</option>
					<option value="TRANSFER">Transfer</option>
				</select>
			</div>
			<div class="col-md-3">
				<button class="btn btn-primary" onclick="filterTable()">Filter</button>
				<button class="btn btn-secondary" onclick="resetTable()">Reset</button>
			</div>
		</div>

		<c:choose>
			<c:when test="${not empty userTransactions}">
				<table class="table table-bordered table-striped" id="txnTable">
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
						<c:forEach var="txn" items="${userTransactions}">
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

	<script>
        function filterTable() {
            const startDate = document.getElementById("startDate").value;
            const endDate = document.getElementById("endDate").value;
            const txnType = document.getElementById("txnType").value;
            const table = document.getElementById("txnTable");
            const rows = table.getElementsByTagName("tbody")[0].getElementsByTagName("tr");

            for (let row of rows) {
                const date = row.cells[5].innerText.trim();
                const type = row.cells[3].innerText.trim();

                let show = true;

                // Date filter
                if (startDate && new Date(date) < new Date(startDate)) {
                    show = false;
                }
                if (endDate && new Date(date) > new Date(endDate)) {
                    show = false;
                }

                // Type filter
                if (txnType && type !== txnType) {
                    show = false;
                }

                row.style.display = show ? "" : "none";
            }
        }

        function resetTable() {
            document.getElementById("startDate").value = "";
            document.getElementById("endDate").value = "";
            document.getElementById("txnType").value = "";

            const table = document.getElementById("txnTable");
            const rows = table.getElementsByTagName("tbody")[0].getElementsByTagName("tr");

            for (let row of rows) {
                row.style.display = "";
            }
        }
    </script>
</body>
</html>
