<%--
  Created by IntelliJ IDEA.
  User: quang
  Date: 27/08/2022
  Time: 2:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>DELETE</h1>


<span>Bạn có thật sự muốn xóa</span>
<form method="post">
<table border="1">
    <tr>
        <th>Name</th>
        <th>Price</th>
        <th>description</th>
        <th>producer</th>
    </tr>

        <tr>
            <td>${pro.getName()}</td>
            <td>${pro.getPrice()}</td>
            <td>${pro.getDescription()}</td>
            <td>${pro.getProducer()}</td>
                <%--        <td><a href="/product?">Edit</a></td>--%>
            <td><input type="submit" value="Delete"></td>
        </tr>
</table>
</form>

</body>
</html>
