<%--
  Created by IntelliJ IDEA.
  User: Nguyễn Bá Tuấn Anh (anhnbt.it@gmail.com)
  Date: 30/10/2024
  Time: 1:46 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Employees</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
<h1>Employees</h1>
<a href="?jobTitle=VP Sales">VP Sales</a> |
<a href="?jobTitle=President">President</a> |
<a href="?jobTitle=VP Marketing">VP Marketing</a> |
<a href="?jobTitle=Sales Manager (APAC)">Sales Manager (APAC)</a> |
<a href="?jobTitle=Sale Manager (EMEA)">Sale Manager (EMEA)</a> |
<a href="?jobTitle=Sales Manager (NA)">Sales Manager (NA)</a> |
<a href="?jobTitle=Sales Rep">Sales Rep</a>
<table class="table table-bordered">
    <thead>
    <tr>
        <td>Employee Number</td>
        <td>Last Name</td>
        <td>First Name</td>
        <td>Email</td>
        <td>Job Title</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${employees}" var="e">
    <tr>
        <td>${e.employeeNumber}</td>
        <td>${e.lastName}</td>
        <td>${e.firstName}</td>
        <td>${e.email}</td>
        <td>${e.jobTitle}</td>
    </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
