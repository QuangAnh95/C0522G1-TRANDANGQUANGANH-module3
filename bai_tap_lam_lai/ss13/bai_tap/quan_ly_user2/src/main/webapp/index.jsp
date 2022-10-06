<%--
  Created by IntelliJ IDEA.
  User: quang
  Date: 03/10/2022
  Time: 4:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>ShowList</title>
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap4.min.css"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css">
    <style>
      table {
        border: solid 3px;
      }

      a {
        text-decoration: none;
      }

      a:hover {
        text-decoration: underline;
      }
    </style>
  </head>
  <body>
  <p>${show}</p>
  <a href="/user?action=showformcreate">Create new User</a>
  <h1>List User</h1>
  <table border="1" width="100%";>
    <tr>
      <th>Name</th>
      <th>Email</th>
      <th>Country</th>
      <th colspan="2">Action</th>
    </tr>
    <c:forEach var="us" items="${list}">
      <tr>
        <td>
          <c:out value="${us.name}"/>
        </td>
        <td>
          <c:out value="${us.email}"/>
        </td>
        <td>
          <c:out value="${us.country}"/>
        </td>
        <td><button><a href="/user?action=showEdit&id=${us.id}">Edit</a></button></td>
        <td>
          <button onclick="submitDelete('${us.id}','${us.name}')"
                  type="button"
                  class="btn btn-primary" data-bs-toggle="modal"
                  data-bs-target="#exampleModal">
            <i class="fa-solid fa-trash-can" ></i>
          </button>
        </td>
      </tr>

    </c:forEach>
  </table>

  <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <form action="/user">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body">
            <input hidden name="customerId" id="idDelete">
            <input hidden name="action" value="delete">
            <span>Ban co muon xoa : </span>
            <span style="color:red" id="nameDelete"></span>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
            <button type="submit" class="btn btn-primary">delete</button>
          </div>
        </div>
      </form>
    </div>
  </div>

  <script>
    function submitDelete(id, name) {
      document.getElementById("idDelete").value = id;
      document.getElementById("nameDelete").innerHTML = name;
    }
  </script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
          integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
          crossorigin="anonymous"></script>
  </body>
</html>
