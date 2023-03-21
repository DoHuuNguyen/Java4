<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 3/14/2023
  Time: 2:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<html>
<head>
    <link rel="stylesheet" href="/Assignment_war_exploded/css/bootstrap.css">
    <title>Nhân Viên</title>
</head>
<body>

<div style="margin: 30px">
    <a class="btn btn-primary" href="../NhanVien/create" >Thêm mới</a>
    <table class="table table-striped-columns">

        <c:if test="${f:length(dsnv)==0}">
            <center><h3>Không có dữ liệu</h3></center>
        </c:if>
        <c:if test="${f:length(dsnv)!=0}">
            <thead>
            <tr>
                <th class="col">Mã</th>
                <th class="col">Họ</th>
                <th class="col">Tên Đệm</th>
                <th class="col">Tên</th>
                <th class="col">Giới Tính</th>
                <th class="col">Ngày Sinh</th>
                <th class="col">Địa Chỉ</th>
                <th class="col">Số Điện Thoại</th>
                <th class="col">Mật Khẩu</th>
                <th class="col">ID Cửa Hàng</th>
                <th class="col">ID Chức Vụ</th>
                <th class="col">Thành Phố</th>
                <th class="col">Quốc Gia</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${dsnv}" var="nv">
                <tr>
                    <td class="col">${nv.ma}</td>
                    <td class="col">${nv.ho}</td>
                    <td class="col">${nv.tenDem}</td>
                    <td class="col">${nv.ten}</td>
                    <td class="col">${nv.gioiTinh}</td>
                    <td class="col">${nv.ngaySinh}</td>
                    <td class="col">${nv.diaChi}</td>
                    <td class="col">${nv.sdt}</td>
                    <td class="col">${nv.idCuaHang}</td>
                    <td class="col">${nv.idChucVu}</td>
                    <td class="col">${nv.thanhPho}</td>
                    <td class="col">${nv.quocGia}</td>
                    <td class="col"><a class="btn btn-primary" href="../NhanVien/edit?ma=${nv.ma}">Sửa</a>
                        <a class="btn btn-primary" href="../NhanVien/delete?ma=${nv.ma}">Xóa</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </c:if>

    </table>
</div>
</body>
</html>
