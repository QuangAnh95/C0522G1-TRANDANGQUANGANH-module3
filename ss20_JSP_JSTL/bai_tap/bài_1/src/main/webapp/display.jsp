<%--
  Created by IntelliJ IDEA.
  User: quang
  Date: 24/08/2022
  Time: 3:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
</head>
<body>
<h1>Danh Sách Khách Hàng</h1>
<table  class="table table-striped">
    <tr>
        <th >
            Tên
        </th>
        <th >
            Ngày Sinh
        </th>
        <th >
            Địa Chỉ
        </th>
        <th >
            Ảnh
        </th>
    </tr>

    <c:forEach var="client" items="${clients}">
        <tr class="table-primary">
            <td>
                ${client.getName()}
            </td>

            <td>
                ${client.getBirthday()}
            </td>
            <td>
                ${client.getAddress()}
            </td>
            <td>
                <img style="width:60px; height: 50px" src="${client.getPicture()}">
            </td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
