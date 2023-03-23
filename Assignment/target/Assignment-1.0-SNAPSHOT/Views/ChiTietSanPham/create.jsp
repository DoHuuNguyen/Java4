<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 3/16/2023
  Time: 10:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="/Assignment_war_exploded/css/bootstrap.css">
    <title>Chi Tiết Sản Phẩm</title>
</head>
<body>
<form method="post" action="/Assignment_war_exploded/ChiTietSanPham/store" style="margin: 30px; border: 1px solid white;background-color: #e9ecef;border-radius: 25px">
    <div style="margin: 20px">
        <center><h1>Chi Tiết Sản Phẩm</h1></center>
        <div class="mb-3 row">
            <label for="staticEmail" class="col-sm-2 col-form-label">id Sản Phẩm</label>
            <div class="col-sm-10">
                <select name="idSP" class="form-select">
                    <option value="SP1">Sản Phẩm 1</option>
                    <option value="SP2">Sản Phẩm 2</option>
                    <option value="SP3">Sản Phẩm 3</option>
                </select>
            </div>
        </div>
        <%--            --%>
        <div class="mb-3 row">
            <label for="staticEmail" class="col-sm-2 col-form-label">Tên Sản Phẩm</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="tenSp">
            </div>
        </div>
        <%--            --%>
        <div class="mb-3 row">
            <label for="staticEmail" class="col-sm-2 col-form-label">id Nhà Sản Xuất</label>
            <div class="col-sm-10">
                <select name="idNSX" class="form-select">
                    <option value="NSX1">Nhà Sản Xuất 1</option>
                    <option value="NSX2">Nhà Sản Xuất 2</option>
                    <option value="NSX3">Nhà Sản Xuất 3</option>
                </select>
            </div>
        </div>
        <%--            --%>
        <div class="mb-3 row">
            <label for="staticEmail" class="col-sm-2 col-form-label">id Màu Sắc</label>
            <div class="col-sm-10">
                <select name="idMauSac" class="form-select">
                    <option value="red">Đỏ</option>
                    <option value="yellow">Vàng</option>
                    <option value="pink">Hồng</option>
                </select>
            </div>
        </div>
        <%--            --%>
        <div class="mb-3 row">
            <label for="staticEmail" class="col-sm-2 col-form-label">id Dong Sản Phẩm</label>
            <div class="col-sm-10">
                <select name="idDongSP" class="form-select">
                    <option value="Hà Nội">Hà Nội</option>
                    <option value="Hồ Chí Minh">Hồ Chí Minh</option>
                    <option value="Hải Phòng">Hải Phòng</option>
                </select>
            </div>
        </div>
        <%--            --%>
        <div class="mb-3 row">
            <label for="staticEmail" class="col-sm-2 col-form-label">Năm Bảo Hành</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="namBh">
            </div>
        </div>
        <%--            --%>
        <div class="mb-3 row">
            <label for="staticEmail" class="col-sm-2 col-form-label">Mô Tả</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="moTa">
            </div>
        </div>
        <%--            --%>
        <div class="mb-3 row">
            <label for="staticEmail" class="col-sm-2 col-form-label">Số Lượng</label>
            <div class="col-sm-10">
                <input type="number" class="form-control" name="soLuong">
            </div>
        </div>
        <%--            --%>
        <div class="mb-3 row">
            <label for="staticEmail" class="col-sm-2 col-form-label">Giá Nhập</label>
            <div class="col-sm-10">
                <input type="number" class="form-control" name="giaNhap">
            </div>
        </div>
        <%--            --%>
        <div class="mb-3 row">
            <label for="staticEmail" class="col-sm-2 col-form-label">Giá Bán</label>
            <div class="col-sm-10">
                <input type="number" class="form-control" name="giaBan">
            </div>
        </div>
        <%--            --%>
        <button type="submit">Thêm</button>
    </div>
</form>
<script src="/Assignment_war_exploded/js/bootstrap.min.js"></script>
</body>
</html>
