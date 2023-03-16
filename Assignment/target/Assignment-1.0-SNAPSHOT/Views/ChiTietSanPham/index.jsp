<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 3/16/2023
  Time: 11:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="/Assignment_war_exploded/css/bootstrap.css">
    <title>Chi Tiết Sản Phẩm</title>
</head>
<body>
<div style="margin: 30px">
    <table class="table table-striped-columns">

        <c:if test="${f:length(dsKhachHang)==0}">
            <center><h3>Không có dữ liệu</h3></center>
        </c:if>
        <c:if test="${f:length(dsKhachHang)!=0}">
            <thead>
            <tr>
                <th class="col">Mã</th>
                <th class="col">Họ</th>
                <th class="col">Tên Đệm</th>
                <th class="col">Tên</th>
                <th class="col">Ngày Sinh</th>
                <th class="col">Địa Chỉ</th>
                <th class="col">Số Điện Thoại</th>

                <th class="col">Thành Phố</th>
                <th class="col">Quốc Gia</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${dsKhachHang}" var="kh">
                <tr>
                    <td class="col">${kh.ma}</td>
                    <td class="col">${kh.ho}</td>
                    <td class="col">${kh.tenDem}</td>
                    <td class="col">${kh.ten}</td>
                    <td class="col">${kh.ngaySinh}</td>
                    <td class="col">${kh.diaChi}</td>
                    <td class="col">${kh.sdt}</td>
                    <td class="col">${kh.thanhPho}</td>
                    <td class="col">${kh.quocGia}</td>
                </tr>
            </c:forEach>
            </tbody>
        </c:if>

    </table>
</div>
</body>
</html>
