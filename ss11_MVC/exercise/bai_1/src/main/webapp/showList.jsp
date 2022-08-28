<%--
  Created by IntelliJ IDEA.
  User: quang
  Date: 27/08/2022
  Time: 12:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>PRODUCT</h1>
<table border="1">
    <tr>
        <th>Name</th>
        <th>Price</th>
        <th>description</th>
        <th>producer</th>
    </tr>
    <c:forEach items="${list}" var="pro">
    <tr>
        <td>${pro.getName()}</td>
        <td>${pro.getPrice()}</td>
        <td>${pro.getDescription()}</td>
        <td>${pro.getProducer()}</td>
        <td><a href="/product?action=showedit&id=${pro.id}">Edit</a></td>
        <td><a href="/product?action=delete&id=${pro.id}">Dellete</a></td>
    </tr>
    </c:forEach>
</table>


</body>
</html>
