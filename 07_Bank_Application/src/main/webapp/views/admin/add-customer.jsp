<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Customer</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<style>
body {
	background-color: #f8f9fa;
}

.form-container {
	max-width: 500px;
	margin: 80px auto;
	padding: 25px;
	background: #ffffff;
	border-radius: 10px;
	box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
}

h2 {
	text-align: center;
	margin-bottom: 25px;
}
</style>
</head>
<body>

	<!-- Common Navbar -->
	<jsp:include page="/views/common/navbar.jsp" />

	<!-- Add Customer Form -->
	<div class="container">
		<div class="form-container">
			<h2>Add New Customer</h2>
			<form action="${pageContext.request.contextPath}/create-customer"
				method="post">
				<input type="hidden" name="action" value="addCustomer" />

				<div class="mb-3">
					<label for="username" class="form-label">Username</label> <input
						type="text" class="form-control" id="username" name="username"
						placeholder="Enter username" required>
				</div>

				<div class="mb-3">
					<label for="password" class="form-label">Password</label> <input
						type="password" class="form-control" id="password" name="password"
						placeholder="Enter password" required>
				</div>

				<div class="mb-3">
					<label for="name" class="form-label">Full Name</label> <input
						type="text" class="form-control" id="name" name="name"
						placeholder="Enter full name" required>
				</div>

				<div class="mb-3">
					<label for="email" class="form-label">Email</label> <input
						type="email" class="form-control" id="email" name="email"
						placeholder="Enter email address" required>
				</div>

				<div class="d-grid">
					<button type="submit" class="btn btn-primary">Create
						Account</button>
				</div>
			</form>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
