<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Admin Dashboard</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<style>
body {
	background: #f8f9fa;
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
}

.navbar {
	background: linear-gradient(90deg, #0d6efd, #0a58ca);
}

.navbar-brand {
	color: #fff !important;
	font-weight: 600;
	font-size: 1.3rem;
}

.dashboard {
	margin-top: 80px;
}

.card {
	border-radius: 15px;
	transition: 0.3s;
}

.card:hover {
	transform: translateY(-5px);
	box-shadow: 0px 5px 15px rgba(0, 0, 0, 0.1);
}

footer {
	margin-top: 50px;
	background: #0d6efd;
	color: #fff;
	padding: 15px;
	text-align: center;
}
</style>
</head>
<body>

	<!-- Navbar -->
	<nav class="navbar navbar-expand-lg fixed-top">
		<div class="container">
			<a class="navbar-brand" href="#">🏦 Admin Dashboard</a>
			<div class="ms-auto">
				<form action="${pageContext.request.contextPath}/auth" method="post"
					class="d-inline">
					<input type="hidden" name="action" value="logout" />
					<button type="submit" class="btn btn-light">Logout</button>
				</form>
			</div>
		</div>
	</nav>

	<!-- Dashboard Content -->
	<div class="container dashboard">
		<h2 class="text-center mb-5">Welcome, Admin</h2>
		<div class="row g-4">

			<!-- Add New Customer -->
			<div class="col-md-4">
				<div class="card text-center p-4">
					<div class="card-body">
						<h5 class="card-title">👤 Add New Customer</h5>
						<p class="card-text">Register a new customer into the system.</p>
						<a
							href="${pageContext.request.contextPath}/admin?action=addCustomer"
							class="btn btn-primary">Add Customer</a>
					</div>
				</div>
			</div>

			<!-- View Customers -->
			<div class="col-md-4">
				<div class="card text-center p-4">
					<div class="card-body">
						<h5 class="card-title">📋 View Customers</h5>
						<p class="card-text">See all registered customers and manage
							details.</p>
						<a
							href="${pageContext.request.contextPath}/admin?action=viewCustomers"
							class="btn btn-success">View Customers</a>
					</div>
				</div>
			</div>

			<!-- View Transactions -->
			<div class="col-md-4">
				<div class="card text-center p-4">
					<div class="card-body">
						<h5 class="card-title">💳 View Transactions</h5>
						<p class="card-text">Monitor all transactions happening in the
							system.</p>
						<a
							href="${pageContext.request.contextPath}/admin?action=viewTransactions"
							class="btn btn-warning">View Transactions</a>
					</div>
				</div>
			</div>

		</div>
	</div>

	<!-- Footer -->
	<footer>
		<p class="mb-0">© 2025 MyBank Admin Panel. All rights reserved.</p>
	</footer>

</body>
</html>
