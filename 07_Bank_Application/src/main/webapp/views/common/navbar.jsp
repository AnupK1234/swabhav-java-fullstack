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
<nav class="navbar navbar-expand-lg fixed-top">
	<div class="container">
		<a class="navbar-brand" href="#">Admin Dashboard</a>
		<div class="ms-auto">
			<form action="${pageContext.request.contextPath}/auth" method="post"
				class="d-inline">
				<input type="hidden" name="action" value="logout" />
				<button type="submit" class="btn btn-light">Logout</button>
			</form>
		</div>
	</div>
</nav>