<%--
  Created by IntelliJ IDEA.
  User: quang
  Date: 30/08/2022
  Time: 9:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
  <style>

  </style>

</head>
<body>
<div class="container-fluid bg-gray-500 d-flex myCSS" style="height: 150px">
  <img class="h-100 p-4" src="https://www.furama.com/images/LOGOFurama_4C_Normal.png" alt="">
  <img class="ms-5 ps-5" src="https://furamavietnam.com/wp-content/uploads/2019/02/Ariyana-Tourism-Complex-02-2.png"
       alt="">

  <div class="container-fluid text-end my-4 me-4">
    <span class="badge text-bg-warning mt-3"></span>
  </div>
</div>

<nav class="navbar navbar-expand-lg bg-light" style="height: 100px">
  <div class="container-fluid mx-5">
    <a class="navbar-brand" href="/">Home</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item dropdown ms-3">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
             aria-expanded="false">Employee</a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="/employee">Employee list</a></li>
            <li><a class="dropdown-item" href="/employee?action=create">Add new Employee</a></li>
          </ul>
        </li>

        <li class="nav-item dropdown ms-3">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
             aria-expanded="false">Customer</a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="/customer">Customer list</a></li>
            <li><a class="dropdown-item" href="/customer?action=create">Add new Customer</a></li>
          </ul>
        </li>

        <li class="nav-item dropdown ms-3">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
             aria-expanded="false">Service</a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="#">Facility list</a></li>
            <li><a class="dropdown-item" href="#">Add new Facility</a></li>
          </ul>
        </li>

        <li class="nav-item dropdown ms-3">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
             aria-expanded="false">Contract</a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="#">Contract list</a></li>
            <li><a class="dropdown-item" href="#">Add new Contract</a></li>
          </ul>
        </li>
      </ul>

      <form class="d-flex my-2" role="search">
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success" type="submit" style="width:  150px">
          <i class="fa-solid fa-magnifying-glass">Search</i></button>
      </form>
    </div>
  </div>
</nav>
<br>
<br>
<div class="row" style="display: block; background-color:#3B99B3; text-align: center; height: 50px" >
  <p ><a href="#" style="color: white; font-size: 25px;padding-top: 15px">TRẢI NGHIỆM ẨM THỰC & GIẢI TRÍ ></a></p>
</div>
<div class="row">
  <div class="col-6">
    <img width="100%" height="600" id="img" onclick="changeImage()"
         src="https://furamavietnam.com/wp-content/uploads/2018/11/Vietnam_Danang_Furama_Resort_Exterior_Courtyard-Night.jpg"
         alt="">
  </div>
  <script>
    var index = 1;
    changeImage = function () {
      var imgs = ["https://furamavietnam.com/wp-content/uploads/2018/11/Vietnam_Danang_Furama_Resort_Exterior_Courtyard-Night.jpg",
        "https://resortdanang.info/wp-content/uploads/2018/11/furama-da-nang-1.jpg",
        "https://ticotravel.com.vn/wp-content/uploads/2021/07/DA-NANG-FURAMA-9.jpg",
        "https://lalyanasensesworlds.com/wp-content/uploads/2020/03/lalyana-senses-world.jpg",
        "https://batdongsanphuquoc.com/wp-content/uploads/2020/05/thong-tin-tien-do-va-gia-ca-du-an-biet-thu-furama-resort-spa-lalyana-senses-world-phu-quoc-5-1.jpg"];
      document.getElementById('img').src = imgs[index];
      index++;
      if (index == 5) {
        index = 0;
      }
    }
    setInterval(changeImage, 2000);
  </script>

  <div class="col-3">

    <div class="row">
      <div class="card shadow" style="width: 18rem;">

        <img src="https://cdn.vntrip.vn/cam-nang/wp-content/uploads/2020/06/Review-Furama-Resort-Da-Nang-13.jpg" class="card-img-top" alt="https://cdn.vntrip.vn/cam-nang/wp-content/uploads/2020/06/Review-Furama-Resort-Da-Nang-13.jpg">
        <div class="card-body">
          <p style="color: blue;font-size: 20px" class="card-text">Không Gian Thư Giãn</p>
        </div>
      </div>

    </div>

    <div style="margin-top: 50px" class="row">
      <div class="card shadow" style="width: 18rem;">

        <img src="https://baodanang.vn/dataimages/201609/original/images1295098_ABG_5.jpg" class="card-img-top" alt="https://baodanang.vn/dataimages/201609/original/images1295098_ABG_5.jpg">
        <div class="card-body">
          <p style="color: blue;font-size: 20px" class="card-text">Truyền Thống Văn hóa</p>
        </div>
      </div>

    </div>
  </div>
  <div class="col-3">

    <div class="row">
      <div class="card shadow" style="width: 18rem;">

        <img style="height: 160px" src="https://cdn.vntrip.vn/cam-nang/wp-content/uploads/2020/01/mia-boutique.jpg">
        <div class="card-body">
          <p style="color: blue;font-size: 20px" class="card-text">Phòng Hiện Đại</p>
        </div>
      </div>

    </div>

    <div style="margin-top: 50px" class="row">
      <div class="card shadow" style="width: 18rem;">

        <img style="height: 150px" src="https://cdn.dealtoday.vn/img/s630x0/a5f91010ddcd4336af8cef8c1caf043f.jpg?sign=mylnbDv88jl5DiqrmE3x5w" class="card-img-top" alt="https://cdn.dealtoday.vn/img/s630x0/a5f91010ddcd4336af8cef8c1caf043f.jpg?sign=mylnbDv88jl5DiqrmE3x5w">
        <div class="card-body">
          <p style="color: blue;font-size: 20px" class="card-text">Ẩm Thực Đa Dạng</p>
        </div>
      </div>
    </div>
  </div>
</div>
<br>

<div class="row" style="text-align: center; color: slategrey">
  <h1>KHU NGHỈ DƯỠNG ĐẲNG CẤP THẾ GIỚI, FURAMA ĐÀ NẴNG,</h1>
</div>
<br>
<div class="row">

  <div class="col-lg-1 d-flex justify-content-end" style="padding: 0">
    <div><img
            src="https://cdn.tgdd.vn/2020/03/GameApp/Facebook-200x200.jpg" height="50" width="50"/></div>
  </div>
  <div class="col-lg-1 d-flex justify-content-start" style="padding: 0">
    <a href="#"> <b>FaceBook></b></a>
  </div>

  <div class="col-lg-1 d-flex justify-content-end" style="padding: 0">
    <div><img src="https://i2.wp.com/ocd.vn/wp-content/uploads/2020/04/zalo1-ID1338.jpg?fit=512%2C512&ssl=1" height="50" width="50"/></div>
  </div>
  <div class="col-lg-1 d-flex justify-content-start" style="padding: 0">
    <a href="#"> <b> Zalo></b></a>
  </div>


  <div class="col-lg-1 d-flex justify-content-end" style="padding: 0">
    <div><img src="https://image.shutterstock.com/image-vector/phone-icon-vector-illustration-simple-260nw-1445752253.jpg" height="50" width="50"/></div>
  </div>
  <div class="col-lg-1 d-flex justify-content-start" style="padding: 0">
    <a href="#"> <b> Số điện Thoại></b></a>
  </div>
</div>
<br>
<br>
<div class="row" style="text-align: center ;color:slategrey ">
  <h1>Hãy Đến Và Trải Nghiệm</h1><br>
</div>

<div class="container-fluid text-center bg-secondary">
  <p class="text-light p-3">&copy;FURAMA - officially operated in 1997.</p>
  <p class="text-light p-3">
    103 – 105 Đường Võ Nguyên Giáp, Phường Khuê Mỹ, Quận Ngũ hành Sơn, Tp. Đà Nẵng, Việt Nam

    7.0 km từ Sân bay Quốc tế Đà Nẵng</p>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0"
        crossorigin="anonymous"></script>
</body>
</html>
