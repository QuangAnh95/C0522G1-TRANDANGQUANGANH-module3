<%--
  Created by IntelliJ IDEA.
  User: quang
  Date: 23/08/2022
  Time: 2:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <div style="text-align: center"> <img src="https://cdn.vietnambiz.vn/2019/10/6/product-15703674776561199022358.jpg" ></div><br>
  <h1 style="text-align: center">Product Discount Calculator</h1><br>

  <form action="/check" method="post" style="text-align: center"><br>
    <label>Product Description:</label><br><br>
    <select><br><br>
      <option>nước giải khát</option>
      <option>bánh </option>
      <option>kẹo</option>
      <option>gia vị</option>
      <option>đồ gia dụng</option>
    </select><br><br>
    <label>List Price</label><br><br>
    <input type="number" name="List Price" placeholder="giá niêm yết"><br><br>
    <label>Discount Percent</label><br><br>
    <input type="number" name="Discount Percent" placeholder="tỉ lệ chiết khấu" ><br><br>
    <button type="submit">kiểm tra</button>
  </form>
  </body>
</html>
