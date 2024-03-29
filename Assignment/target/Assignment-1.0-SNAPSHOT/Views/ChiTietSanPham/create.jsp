<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 3/16/2023
  Time: 10:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
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
            <label for="staticEmail" class="col-sm-2 col-form-label"> Sản Phẩm</label>
            <div class="col-sm-10">
                <select
                        class="form-select"
                        aria-label="Default select example"
                        name="maSanPham"
                >
                    <c:forEach items="${listSanPham}" var="x">
                        <option value="${x.ma}">${x.ten}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="mb-3 row">
            <label for="staticEmail" class="col-sm-2 col-form-label"> Nhà Sản Xuất</label>
            <div class="col-sm-10">
                <select
                        class="form-select"
                        aria-label="Default select example"
                        name="maNSX"
                >
                    <c:forEach items="${listNSX}" var="x">
                        <option value="${x.ma}">${x.ten}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <%--            --%>
        <div class="mb-3 row">
            <label for="staticEmail" class="col-sm-2 col-form-label">Màu Sắc</label>
            <div class="col-sm-10">
                <select
                        class="form-select"
                        aria-label="Default select example"
                        name="maMauSac"
                >
                    <c:forEach items="${listMauSac}" var="x">
                        <option value="${x.ma}">${x.ten}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <%--            --%>
        <div class="mb-3 row">
            <label for="staticEmail" class="col-sm-2 col-form-label">Dong Sản Phẩm</label>
            <div class="col-sm-10">
                <select
                        class="form-select"
                        aria-label="Default select example"
                        name="maDongSP"
                >
                    <c:forEach items="${listDongSP}" var="x">
                        <option value="${x.ma}">${x.ten}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <%--            --%>
        <div class="mb-3 row">
            <label for="staticEmail" class="col-sm-2 col-form-label">Năm Bảo Hành</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="namBH">
            </div>
        </div>
        <%--            --%>
        <div class="mb-3 row">
            <label for="staticEmail" class="col-sm-2 col-form-label">Mô Tả</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="moTa">
            </div>
        </div>
        <div class="mb-3 row">
            <label for="staticEmail" class="col-sm-2 col-form-label">Số Lượng</label>
            <div class="col-sm-10">
                <input type="number" class="form-control" name="soLuongTon">
            </div>
        </div>
        <div class="mb-3 row">
            <label for="staticEmail" class="col-sm-2 col-form-label">Giá Nhập</label>
            <div class="col-sm-10">
                <input type="number" class="form-control" name="giaNhap">
            </div>
        </div>
        <div class="mb-3 row">
            <label for="staticEmail" class="col-sm-2 col-form-label">Giá Bán</label>
            <div class="col-sm-10">
                <input type="number" class="form-control" name="giaBan">
            </div>
        </div>
        <button type="submit">Thêm</button>
    </div>
</form>
<script src="/Assignment_war_exploded/js/bootstrap.min.js"></script>
</body>
</html>
