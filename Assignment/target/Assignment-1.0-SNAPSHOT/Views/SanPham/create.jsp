<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 3/13/2023
  Time: 10:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="/Assignment_war_exploded/css/bootstrap.css">
    <title>Sản Phẩm</title>
</head>
<body>
<form method="post" action="/Assignment_war_exploded/SanPham/store" style="margin: 30px; border: 1px solid white;background-color: #e9ecef;border-radius: 25px">
    <div style="margin: 20px">
        <center><h1>Sản Phẩm</h1></center><br>
        <div class="mb-3 row">
            <label for="staticEmail" class="col-sm-2 col-form-label">Mã</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="ma">
                <div class="error mt-2" style="color: red"><p>${checkma}</p></div>
                <div class="error mt-2" style="color: red"><p>${trungMa}</p></div>
            </div>
        </div>
        <%--            --%>
        <div class="mb-3 row">
            <label for="staticEmail" class="col-sm-2 col-form-label">Tên</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="ten">
                <div class="col error mt-2" style="color: #ff0000"><p>${checkten}</p></div>
            </div>
        </div>
        <button type="submit">Thêm</button>
    </div>
</form>
<script src="/Assignment_war_exploded/js/bootstrap.min.js"></script>
</body>
</html>
