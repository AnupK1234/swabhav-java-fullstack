<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Bank Home</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<style>
body {
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

.btn-login {
	border: 2px solid #fff;
	color: #fff;
	font-weight: 500;
	border-radius: 30px;
	padding: 6px 18px;
	transition: 0.3s;
}

.btn-login:hover {
	background: #fff;
	color: #0d6efd;
}

.hero {
	min-height: 90vh;
	display: flex;
	align-items: center;
	justify-content: center;
	text-align: center;
	background: linear-gradient(to right, #f8f9fa, #e9ecef);
}

.hero h1 {
	font-size: 3rem;
	font-weight: bold;
	color: #212529;
}

.hero p {
	font-size: 1.2rem;
	color: #495057;
	margin-bottom: 25px;
}

.btn-cta {
	padding: 12px 28px;
	font-size: 1.1rem;
	border-radius: 30px;
}

footer {
	background: #0d6efd;
	color: #fff;
	padding: 15px 0;
	text-align: center;
	margin-top: 40px;
}
</style>
</head>
<body>

	<!-- Navbar -->
	<nav class="navbar navbar-expand-lg fixed-top">
		<div class="container">
			<a class="navbar-brand" href="#">🏦 MyBank</a>
			<div class="ms-auto">
				<a href="${pageContext.request.contextPath}/login"
					class="btn btn-login">Login</a>
			</div>
		</div>
	</nav>

	<!-- Hero Section -->
	<section class="hero">
		<div class="container">
			<h1>Welcome to MyBank</h1>
			<p>Simple, secure, and modern banking at your fingertips.</p>
			<a href="${pageContext.request.contextPath}/login"
				class="btn btn-primary btn-cta me-2">Login</a> <a href="#"
				class="btn btn-outline-dark btn-cta">Learn More</a>
		</div>
	</section>

	<!-- Footer -->
	<footer>
		<div class="container">
			<p class="mb-0">© 2025 MyBank. All rights reserved.</p>
		</div>
	</footer>

</body>
</html>
