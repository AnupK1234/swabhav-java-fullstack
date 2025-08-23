<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Customer Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <jsp:include page="/views/common/navbar.jsp" />

    <div class="container mt-5 pt-5">
        <h2 class="text-center mb-4">Customer Dashboard</h2>

        <div class="row justify-content-center">
            <!-- View Passbook -->
            <div class="col-md-4 mb-3">
                <div class="card shadow-sm">
                    <div class="card-body text-center">
                        <h5 class="card-title">View Passbook</h5>
                        <p class="card-text">Check your account transactions and balance details.</p>
                        <a href="${pageContext.request.contextPath}/customer/viewPassbook" class="btn btn-primary">View</a>
                    </div>
                </div>
            </div>

            <!-- New Transaction -->
            <div class="col-md-4 mb-3">
                <div class="card shadow-sm">
                    <div class="card-body text-center">
                        <h5 class="card-title">New Transaction</h5>
                        <p class="card-text">Perform a new credit or debit transaction.</p>
                        <a href="${pageContext.request.contextPath}/customer/newTransaction" class="btn btn-success">Transact</a>
                    </div>
                </div>
            </div>

            <!-- Edit Profile -->
            <div class="col-md-4 mb-3">
                <div class="card shadow-sm">
                    <div class="card-body text-center">
                        <h5 class="card-title">Edit Profile</h5>
                        <p class="card-text">Update your personal information and password.</p>
                        <a href="${pageContext.request.contextPath}/customer/editProfile" class="btn btn-warning">Edit</a>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
