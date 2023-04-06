<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 3/13/2023
  Time: 1:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="/Assignment_war_exploded/css/bootstrap.css">
    <title>Cửa Hàng</title>
</head>
<body>
<form method="post" action="/Assignment_war_exploded/CuaHang/update?ma=${ch.ma}" style="margin: 30px; border: 1px solid white;background-color: #e9ecef;border-radius: 25px">
    <div style="margin: 20px">
        <center><h1>Cửa Hàng</h1></center><br>
        <div class="mb-3 row">
            <label for="staticEmail" class="col-sm-2 col-form-label">Mã</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="ma" value="${ch.ma}" disabled>
            </div>
        </div>
        <%--            --%>
        <div class="mb-3 row">
            <label for="staticEmail" class="col-sm-2 col-form-label">Tên</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="ten" value="${ch.ten}">
                <div class="col error mt-2" style="color: #ff0000"><p>${checkten}</p></div>
            </div>
        </div>
        <%--            --%>
        <div class="mb-3 row">
            <label for="staticEmail" class="col-sm-2 col-form-label">Đia Chỉ</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="diaChi" value="${ch.diaChi}">
            </div>
        </div>
        <%--            --%>
        <div class="mb-3 row">
            <label for="staticEmail" class="col-sm-2 col-form-label">Quốc Gia</label>
            <div class="col-sm-10">
                <select name="quocGia" class="form-select">
                    <option value="Việt Nam" ${ ch.quocGia == "Việt Nam" ? "selected" : "" }>Việt Nam</option>
                    <option value="Mỹ" ${ kh.quocGia == "Mỹ" ? "selected" : "" }>Mỹ</option>
                    <option value="Hàn Quốc" ${ ch.quocGia == "Hàn Quốc" ? "selected" : "" }>Hàn Quốc</option>
                </select>
            </div>
        </div>
        <%--            --%>
        <div class="mb-3 row">
            <label for="staticEmail" class="col-sm-2 col-form-label">Thành Phố</label>
            <div class="col-sm-10">
                <select name="thanhPho" class="form-select">
                    <option value="Hà Nội" ${ ch.thanhPho == "Việt Nam" ? "selected" : "" }>Hà Nội</option>
                    <option value="Hồ Chí Minh" ${ ch.thanhPho == "Hồ Chí Minh" ? "selected" : "" }>Hồ Chí Minh</option>
                    <option value="Hải Phòng" ${ ch.thanhPho == "Hải Phòng" ? "selected" : ""}>Hải Phòng</option>
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
