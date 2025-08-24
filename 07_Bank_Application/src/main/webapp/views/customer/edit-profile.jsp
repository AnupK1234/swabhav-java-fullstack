<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Edit Profile</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<jsp:include page="/views/common/navbar.jsp" />

	<div class="container mt-5">
		<h2>Edit Profile</h2>

		<c:if test="${not empty error}">
			<div class="alert alert-danger">${error}</div>
		</c:if>

		<form action="${pageContext.request.contextPath}/editProfile" method="post" class="mt-3">
			<div class="mb-3">
				<label class="form-label">Name</label> <input type="text"
					name="name" value="${user.name}" class="form-control" required>
			</div>

			<div class="mb-3">
				<label class="form-label">Email</label> <input type="email"
					name="email" value="${user.email}" class="form-control" required>
			</div>

			<div class="mb-3">
				<label class="form-label">Password</label> <input type="password"
					name="password" class="form-control"
					placeholder="Enter new password/Existing password to authenticate">
			</div>

			<button type="submit" class="btn btn-primary">Update Profile</button>
		</form>
	</div>
</body>
</html>
