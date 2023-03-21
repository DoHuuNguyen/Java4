<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 3/13/2023
  Time: 11:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="/Assignment_war_exploded/css/bootstrap.css">
    <title>Nhân Viên</title>
</head>
<body>
<form method="post" action="/Assignment_war_exploded/NhanVien/store" style="margin: 30px; border: 1px solid white;background-color: #e9ecef;border-radius: 25px">
    <div style="margin: 20px">
        <center><h1>Nhân Viên</h1></center>
        <div class="mb-3 row">
            <label for="staticEmail" class="col-sm-2 col-form-label">Mã</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="ma" value="${nv.ma}" disabled>
            </div>
        </div>
        <%--            --%>
        <div class="mb-3 row">
            <label for="staticEmail" class="col-sm-2 col-form-label">Họ</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="ho" value="${nv.ho}">
            </div>
        </div>
        <%--            --%>
        <div class="mb-3 row">
            <label for="staticEmail" class="col-sm-2 col-form-label">Tên Đệm</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="tenDem" value="${nv.tenDem}">
            </div>
        </div>
        <%--            --%>
        <div class="mb-3 row">
            <label for="staticEmail" class="col-sm-2 col-form-label">Tên</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="ten" value="${nv.ten}">
            </div>
        </div>
        <%--            --%>
        <div class="mb-3 row">
            <label for="staticEmail" class="col-sm-2 col-form-label">Giới Tính</label>
            <div class="col-sm-10">
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="gioiTinh"  value="Nam" ${ nv.gioiTinh == "Nam" ? "checked" : "" }>
                    <label class="form-check-label" for="flexRadioDefault1">
                        Nam
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="gioiTinh"  value="Nữ" ${ nv.gioiTinh == "Nữ" ? "checked" : "" }>
                    <label class="form-check-label" for="flexRadioDefault2">
                        Nữ
                    </label>
                </div>
            </div>
        </div>
        <%--            --%>
        <div class="mb-3 row">
            <label for="staticEmail" class="col-sm-2 col-form-label">Ngày Sinh</label>
            <div class="col-sm-10">
                <input type="date" class="form-control" name="ngaySinh" value="${nv.ngaySinh}">
            </div>
        </div>
        <%--            --%>
        <div class="mb-3 row">
            <label for="staticEmail" class="col-sm-2 col-form-label">Số Điện Thoại</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="sdt" value="${nv.sdt}">
            </div>
        </div>
        <%--            --%>
        <div class="mb-3 row">
            <label for="staticEmail" class="col-sm-2 col-form-label">Đia Chỉ</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="diaChi" value="${nv.diaChi}">
            </div>
        </div>
        <%--            --%>
        <div class="mb-3 row">
            <label for="staticEmail" class="col-sm-2 col-form-label">Mật Khẩu</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" name="matKhau" value="${nv.matKhau}">
            </div>
        </div>
        <%--            --%>
        <%--            --%>
        <div class="mb-3 row">
            <label for="staticEmail" class="col-sm-2 col-form-label">IdCuaHang</label>
            <div class="col-sm-10">
                <select name="idCuaHang" class="form-select">
                    <option value="Hà Nội">Hà Nội</option>
                    <option value="Hồ Chí Minh">Hồ Chí Minh</option>
                    <option value="Hải Phòng">Hải Phòng</option>
                </select>
            </div>
        </div>
        <%--            --%>
        <%--            --%>
        <div class="mb-3 row">
            <label for="staticEmail" class="col-sm-2 col-form-label">IdChucVu</label>
            <div class="col-sm-10">
                <select name="idChucVu" class="form-select">
                    <option value="Hà Nội">Trưởng phòng</option>
                    <option value="Hồ Chí Minh">Nhân viên</option>
                </select>
            </div>
        </div>
        <%--            --%>
        <div class="mb-3 row">
            <label for="staticEmail" class="col-sm-2 col-form-label">Quốc Gia</label>
            <div class="col-sm-10">
                <select name="quocGia" class="form-select">
                    <option value="Việt Nam" selected>Việt Nam</option>
                    <option value="Mỹ">Mỹ</option>
                    <option value="Hàn Quốc">Hàn Quốc</option>
                </select>
            </div>
        </div>
        <%--            --%>
        <div class="mb-3 row">
            <label for="staticEmail" class="col-sm-2 col-form-label">Thành Phố</label>
            <div class="col-sm-10">
                <select name="thanhPho" class="form-select">
                    <option value="Hà Nội">Hà Nội</option>
                    <option value="Hồ Chí Minh">Hồ Chí Minh</option>
                    <option value="Hải Phòng">Hải Phòng</option>
                </select>
            </div>
        </div>
        <%--            --%>
        <button type="submit">Thêm</button>
    </div>
</form>
<script src="/Assignment_war_exploded/js/bootstrap.min.js"></script>
</body>
</html>
