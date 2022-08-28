<%--
  Created by IntelliJ IDEA.
  User: quang
  Date: 28/08/2022
  Time: 9:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/product?action=edit&id=${pro.id}" method="post">
    <input type="text" value="${pro.name}" name="name">
    <input type="submit" value="Submit">
</form>
</body>
</html>
