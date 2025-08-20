<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<title>Bank Login</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
</head>
<body class="bg-light">
	<div class="container">
		<h2 class="mt-5">Bank Login</h2>
		<form action="${pageContext.request.contextPath}/auth" method="post">
			<input type="hidden" name="action" value="login" />
			<div class="mb-3">
				<label>Username</label> <input name="username" class="form-control" />
			</div>
			<div class="mb-3">
				<label>Password</label> <input name="password" type="password"
					class="form-control" />
			</div>
			<button type="submit" class="btn btn-primary">Login</button>
			<p style="color: red;">${error}</p>
		</form>
	</div>
</body>
</html>
