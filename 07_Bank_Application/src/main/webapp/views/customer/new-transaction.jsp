<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Transaction</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script>
	function toggleFields() {
		const type = document.getElementById("transactionType").value;
		const transferFields = document.getElementById("transferFields");

		if (type === "TRANSFER") {
			transferFields.style.display = "block";
		} else {
			transferFields.style.display = "none";
		}
	}
</script>
</head>
<body>
	<jsp:include page="/views/common/navbar.jsp" />
	<div class="container mt-5">
		<h2 class="mb-4">New Transaction</h2>

		<form
			action="${pageContext.request.contextPath}/transaction?action=create"
			method="post" class="border p-4 rounded shadow-sm bg-light">
			<div class="mb-3">
				<label for="transactionType" class="form-label">Transaction
					Type</label> <select id="transactionType" name="type" class="form-select"
					onchange="toggleFields()" required>
					<option value="">-- Select Type --</option>
					<option value="TRANSFER">TRANSFER</option>
					<option value="CREDIT">CREDIT</option>
				</select>
			</div>

			<div id="transferFields" style="display: none;">
				<div class="mb-3">
					<label for="toAcc" class="form-label">Receiver Account
						Number</label> <input type="number" id="toAcc" name="toAcc"
						class="form-control" placeholder="Enter receiver account number">
				</div>
			</div>

			<div class="mb-3">
				<label for="amount" class="form-label">Amount</label> <input
					type="number" step="0.01" id="amount" name="amount"
					class="form-control" placeholder="Enter amount" required>
			</div>

			<button type="submit" class="btn btn-primary">Submit
				Transaction</button>
		</form>
	</div>
</body>
</html>
