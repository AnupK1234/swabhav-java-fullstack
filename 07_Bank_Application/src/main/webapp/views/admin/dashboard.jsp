<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Admin Dashboard</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">

</head>
<body>

	<!-- Navbar -->
	<jsp:include page="/views/common/navbar.jsp" />

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
							href="${pageContext.request.contextPath}/admin/addCustomer"
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
							href="${pageContext.request.contextPath}/admin/viewCustomers"
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
							href="${pageContext.request.contextPath}/admin/viewTransactions"
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
