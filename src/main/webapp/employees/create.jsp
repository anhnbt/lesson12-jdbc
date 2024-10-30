<%--
  Created by IntelliJ IDEA.
  User: Nguyễn Bá Tuấn Anh (anhnbt.it@gmail.com)
  Date: 30/10/2024
  Time: 2:18 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Employee</title>
</head>
<body>
<h1>Create Employee</h1>
<form action="/employees?action=create" method="post">
    <div class="mb-3">
        <label for="employeeNumber" class="form-label">Employee Number</label>
        <input type="text" class="form-control" name="employeeNumber" id="employeeNumber" required>
    </div>
    <div class="mb-3">
        <label for="lastName" class="form-label">Last Name</label>
        <input type="text" class="form-control" name="lastName" id="lastName" required>
    </div>
    <div class="mb-3">
        <label for="firstName" class="form-label">First Name</label>
        <input type="text" class="form-control" name="firstName" id="firstName" required>
    </div>
    <div class="mb-3">
        <label for="extension" class="form-label">Extension</label>
        <input type="text" class="form-control" name="extension" id="extension" required>
    </div>
    <div class="mb-3">
        <label for="email" class="form-label">Email</label>
        <input type="email" class="form-control" name="email" id="email" required>
    </div>
    <div class="mb-3">
        <label for="officeCode" class="form-label">Office Code</label>
        <input type="text" class="form-control" name="officeCode" id="officeCode" required>
    </div>
    <div class="mb-3">
        <label for="reportsTo" class="form-label">Reports To</label>
        <input type="text" class="form-control" name="reportsTo" id="reportsTo">
    </div>
    <div class="mb-3">
        <label for="jobTitle" class="form-label">Job Title</label>
        <input type="text" class="form-control" name="jobTitle" id="jobTitle" required>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>
