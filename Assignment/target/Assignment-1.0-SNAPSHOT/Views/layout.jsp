<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 3/21/2023
  Time: 2:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <link rel="stylesheet" href="/Assignment_war_exploded/css/bootstrap.css">
    <title>KhachHang</title>
  </head>
  <body>
  <nav class="navbar navbar-expand-lg bg-light">
    <div class="container-fluid">
      <a class="navbar-brand" href="#">IT17311</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
              data-bs-target="#navbarNav" aria-controls="navbarNav"
              aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="#">Trang chủ</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="../KhachHang/index">Khách hàng</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="../ChiTietSanPham/index">Sản phẩm</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="../CuaHang/index">Cửa Hàng</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="../DongSP/index">Dòng Sản Phẩm</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="../ChucVu/index">Chức Vụ</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="../MauSac/index">Màu Sắc</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="../SanPham/index">Sản Phẩm</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="../NhaSanXuat/index">Nhà Sản Xuất</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>

  <div class="row mt-10" style="min-height: 500px;">
    <div class="col-3 bg-warning">Side bar</div>
    <div class="col-9">
      <jsp:include page="${ view }" />
    </div>
  </div>

  <div class="row m-0 mt-10 bg-dark text-white">Footer</div>
  <script src="/SP23B2_SOF3011_IT17311_war_exploded/js/bootstrap.min.js"></script>
  </body>
</html>
