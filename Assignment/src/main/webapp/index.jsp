<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="/Assignment_war_exploded/css/bootstrap.css">
    <title>Trang ChỦ</title>
</head>
<body>
<form>
<div style="margin: auto;margin-top: 50px ;border-radius: 10px; background-color: #c5e8ef;width: 700px">
    <div style="margin: 10px">
        <center><h3 style="color: #0a58ca ;margin: auto">Đăng Nhập</h3></center>
        <div class="mb-3 row">
            <label for="staticEmail" class="col-sm-2 col-form-label">Số Điện thoại</label>
            <div class="col-sm-10">
                <input type="text"  class="form-control" id="staticEmail" name="sdt">
            </div>
        </div>
        <div class="mb-3 row">
            <label for="inputPassword" class="col-sm-2 col-form-label">Password</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" id="inputPassword" name="matKhau">
            </div>
        </div>
        <center><button type="submit">Đăng nhập</button></center>
    </div>
</div>
</form>
</body>
</html>