<%--
  Created by IntelliJ IDEA.
  User: quang
  Date: 29/09/2022
  Time: 1:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>ClientList</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
  </head>
  <body>
  <h1 style="text-align: center">Danh Sách Khách Hàng</h1>
  <table  class="table table-striped">
    <tr>
      <th style="font-size:30px;text-align: center">
        Tên
      </th >
      <th style="font-size:30px;text-align: center">
        Ngày Sinh
      </th>
      <th style="font-size:30px;text-align: center">
        Địa Chỉ
      </th>
      <th style="font-size:30px;text-align: center">
        Ảnh
      </th>
    </tr>

    <c:forEach var="client" items="${clients}">
      <tr class="table-primary">
        <td>
           <b style="text-align: center">
               ${client.getName()}
           </b>
        </td>

        <td>
          <b style="text-align: center">
              ${client.getBirthday()}
          </b>

        </td>
        <td>
            <b style="text-align: center">
                ${client.getAddress()}
            </b>
        </td>
        <td>
          <img style="width:70px; height: 100px" src="${client.getPicture()}">
        </td>
      </tr>
    </c:forEach>


  </table>
  </body>
</html>
