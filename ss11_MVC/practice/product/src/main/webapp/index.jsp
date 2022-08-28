<%--
  Created by IntelliJ IDEA.
  User: quang
  Date: 25/08/2022
  Time: 11:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>PRODUCT</h1>
  <p>
    <a href="/product?action=create"></a>
  </p>
  <table border="1">
    <tr>
      <td>name</td>
      <td>price</td>
      <td>describe</td>
      <td>producer</td>
    </tr>

    <c:forEach items='${requestScope["product"]}' var="product">
      <tr>
        <td><a href="/product?action=view&id=${product.getId()}">${product.getName}</a></td>
        <td>${product.getPrice()}</td>
        <td>${product.getDescribe()}</td>
        <td>${product.getProducer()}</td>
        <td><a href="/product?action=edit&id=${product.getId()}">edit</a></td>
        <td><a href="/product?action=delete&id=${product.getId()}">delete</a></td>
      </tr>
    </c:forEach>

  </table>
  </body>
</html>
