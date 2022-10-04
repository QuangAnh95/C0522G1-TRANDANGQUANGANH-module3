<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 25/08/2022
  Time: 1:59 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <a href="/newServlet" >Clickme!</a>
  <form>
      <input type="text" name="name" placeholder="Nhập tên">
      <input type="submit" name="action" value="search">
  </form>
  <table border="1">
      <tr>
          <th>Name</th>
      </tr>
      <c:forEach var="per" items="${list}">
          <tr>
              <td><c:out value="${per.name}"/></td>
          </tr>
      </c:forEach>
  </table>
  </body>
</html>
