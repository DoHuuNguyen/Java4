<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 3/11/2023
  Time: 8:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="/Assignment_war_exploded/css/bootstrap.css">
    <title>Khách Hàng</title>
</head>
<body>
    <form method="post" action="/Assignment_war_exploded/KhachHang/update?ma=${kh.ma}" style="margin: 30px; border: 1px solid white;background-color: #e9ecef;border-radius: 25px">
        <div style="margin: 20px">
            <center><h1>Khách Hàng</h1></center>
        <div class="mb-3 row">
            <label for="staticEmail" class="col-sm-2 col-form-label">Mã</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="ma" value="${kh.ma}"disabled>
            </div>
        </div>
<%--            --%>
            <div class="mb-3 row">
                <label for="staticEmail" class="col-sm-2 col-form-label">Họ</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="ho" value="${kh.ho}">
                    <div class="col error mt-2" style="color: #ff0000"><p>${checkHo}</p></div>
                </div>
            </div>
<%--            --%>
            <div class="mb-3 row">
                <label for="staticEmail" class="col-sm-2 col-form-label">Tên Đệm</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="tenDem" value="${kh.tenDem}">
                    <div class="col error mt-2" style="color: #ff0000"><p>${checkTenDem}</p></div>
                </div>
            </div>
<%--            --%>
            <div class="mb-3 row">
                <label for="staticEmail" class="col-sm-2 col-form-label">Tên</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="ten" value="${kh.ten}">
                    <div class="col error mt-2" style="color: #ff0000"><p>${checkten}</p></div>
                </div>
            </div>
<%--            --%>
            <div class="mb-3 row">
                <label for="staticEmail" class="col-sm-2 col-form-label">Ngày Sinh</label>
                <div class="col-sm-10">
                    <input type="date" class="form-control" name="ngaySinh" value="${kh.ngaySinh}">
                </div>
            </div>
<%--            --%>
            <div class="mb-3 row">
                <label for="staticEmail" class="col-sm-2 col-form-label">Số Điện Thoại</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="sdt"value="${kh.sdt}">
                    <div class="col error mt-2" style="color: #ff0000"><p>${checkSdt}</p></div>
                </div>
            </div>
<%--            --%>
            <div class="mb-3 row">
                <label for="staticEmail" class="col-sm-2 col-form-label">Đia Chỉ</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="diaChi"value="${kh.diaChi}">
                    <div class="col error mt-2" style="color: #ff0000"><p>${checkDiaChi}</p></div>
                </div>
            </div>
            <%--            --%>
            <div class="mb-3 row">
                <label for="staticEmail" class="col-sm-2 col-form-label">Mật Khẩu</label>
                <div class="col-sm-10">
                    <input type="password" class="form-control" name="matKhau" value="${kh.matKhau}">
                    <div class="col error mt-2" style="color: #ff0000"><p>${checkMatKhau}</p></div>
                </div>
            </div>
            <%--            --%>
            <div class="mb-3 row">
                <label for="staticEmail" class="col-sm-2 col-form-label">Quốc Gia</label>
                <div class="col-sm-10">
                    <select name="quocGia" class="form-select">
                        <option value="Việt Nam" ${ kh.quocGia == "Việt Nam" ? "selected" : "" }>Việt Nam</option>
                        <option value="Mỹ" ${ kh.quocGia == "Mỹ" ? "selected" : "" }>Mỹ</option>
                        <option value="Hàn Quốc" ${ kh.quocGia == "Hàn Quốc" ? "selected" : "" }>Hàn Quốc</option>
                    </select>
                </div>
            </div>
            <%--            --%>
            <div class="mb-3 row">
                <label for="staticEmail" class="col-sm-2 col-form-label">Thành Phố</label>
                <div class="col-sm-10">
                    <select name="thanhPho" class="form-select">
                        <option value="Hà Nội" ${ kh.thanhPho == "Hà Nội" ? "selected" : "" }>Hà Nội</option>
                        <option value="Hồ Chí Minh" ${ kh.thanhPho == "Hồ Chí Minh" ? "selected" : "" }>Hồ Chí Minh</option>
                        <option value="Hải Phòng" ${ kh.thanhPho == "Hải Phòng" ? "selected" : "" }>Hải Phòng</option>
                    </select>
                </div>
            </div>
            <%--            --%>
            <button type="submit">Sửa</button>
        </div>
    </form>
<script src="/Assignment_war_exploded/js/bootstrap.min.js"></script>
</body>
</html>
