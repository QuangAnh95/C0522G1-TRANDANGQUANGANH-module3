<%--
  Created by IntelliJ IDEA.
  User: quang
  Date: 01/10/2022
  Time: 8:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>ListProduct</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
</head>
<body>
<h1 style="text-align: center ;color: lightskyblue">DANH SÁCH SẢN PHẨM</h1>
<table class="table table-striped">
    <tr>
        <th>Tên sản phẩm</th>
        <th>Giá</th>
        <th>Mô tả chi tiết</th>
        <th>Nhà sản xuất</th>
        <th>Update</th>
        <th>Delete</th>
        <th>View</th>
    </tr>
    <c:forEach var="product" items="${product}">
        <tr>
            <td>${product.getName()}</td>
            <td>${product.getPrice()}</td>
            <td>${product.getDescribe()}</td>
            <td>${product. getProducer()}</td>
            <td><a href="#" class="btn btn-primary" role="button">Update</a></td>
            <td><a href="#" class="btn btn-primary" role="button">Delete</a></td>
            <td><a href="#" class="btn btn-primary" role="button">View</a></td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
