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
      <a class="navbar-brand" href="/Assignment_war_exploded/">IT17311</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
              data-bs-target="#navbarNav" aria-controls="navbarNav"
              aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="/Assignment_war_exploded/Views/layout.jsp">Trang chủ</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="../KhachHang/index">Khách hàng</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="../ChiTietSanPham/index">Chi Tiết Sản phẩm</a>
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
          <li class="nav-item">
            <a class="nav-link" href="../NhanVien/index">Nhân Viên</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>

  <div class="row mt-10" style="min-height: 500px;">
    <div class="col-2 bg-warning"></div>
    <div class="col-10">
      <jsp:include page="${ view }" />
    </div>
  </div>

  <footer class="text-center text-lg-start py-3 fp" style="background-color: #192041;color: white">
    <section class="">
      <div class="container text-center text-md-start mt-5">
        <div class="row mt-3">
          <div class="col-md-4 col-lg-4 col-xl-4 mx-auto mb-4">
            <h6 class="text-uppercase fw-bold mb-4">
              <img src="https://fpl.edu.vn/data/sites/6203837e4108d3030b8b4574/logos/org_photo_6203837e4108d3030b8b4574_1658284782.jpg" height="80px"/>
            </h6>
          </div>

          <div class="col-md-8 col-lg-8 col-xl-8 mx-auto mb-8">
            <h6>THÔNG TIN LIÊN HỆ</h6>
            <p>Đỗ Hữu Nguyện</p>
            <p>Điện thoại: +84395046998</p>
            <p>Email: nguyendhph23086@fpt.edu.vn</p>
          </div>

        </div>
      </div>
    </section>

    <div
            class="text-center py-4"
            style="background-color: rgba(0, 0, 0, 0.05)"
    >
      © 2023 Copyright:
      <a class="text-reset fw-bold" href="https://mdbootstrap.com/"
      >nguyendhph23086@fpt.edu.vn</a
      >
    </div>
  </footer>
  <script src="/SP23B2_SOF3011_IT17311_war_exploded/js/bootstrap.min.js"></script>
  </body>
</html>
