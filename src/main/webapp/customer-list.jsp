<%--
  Created by IntelliJ IDEA.
  User: Nguyễn Bá Tuấn Anh (anhnbt.it@gmail.com)
  Date: 29/10/2024
  Time: 1:52 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Customers</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
<h1>Customers</h1>
<div class="alert">${message}</div>
<table class="table table-bordered">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Phone</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${customers}" var="c">
    <tr>
        <td>${c.customerNumber}</td>
        <td>${c.customerName}</td>
        <td>${c.phone}</td>
        <td>
            <a class="btn btn-sm btn-info" href="/customers?action=view&customerNumber=${c.customerNumber}">View</a> |
            <a class="btn btn-sm btn-danger" href="/customers?action=delete&customerNumber=${c.customerNumber}" onclick="return confirm('Are you sure?');">Delete</a>
        </td>
    </tr>
    </c:forEach>
    </thead>
</table>
</body>
</html>
