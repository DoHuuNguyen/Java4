<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 4/5/2023
  Time: 3:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  session="true" %>
<html>
<head>
    <link rel="stylesheet" href="/Assignment_war_exploded/css/bootstrap.css">
    <title>Login</title>
</head>
<body>

<form method="post" action="/Assignment_war_exploded/login">
    <div class="alert alert-danger"><center>${ errorMessage }</center></div>
    <div style="margin: auto;margin-top: 50px ;border-radius: 10px; background-color: #c5e8ef;width: 700px">
        <div style="margin: 10px">
            <center><h3 style="color: #0a58ca ;margin: auto">Đăng Nhập</h3></center>
            <div class="mb-3 row">
                <label for="staticEmail" class="col-sm-2 col-form-label">Mã</label>
                <div class="col-sm-10">
                    <input type="text"  class="form-control" id="staticEmail" name="ma">
                </div>
            </div>
            <div class="mb-3 row">
                <label for="inputPassword" class="col-sm-2 col-form-label">Password</label>
                <div class="col-sm-10">
                    <input type="password" class="form-control" id="inputPassword" name="matKhau">
                </div>
            </div>
            <center><button type="submit" class="btn btn-outline-success">Đăng nhập</button></center>
        </div>
    </div>
</form>
<script src="/Assignment_war_exploded/js/bootstrap.min.js"></script>
</body>
</html>
