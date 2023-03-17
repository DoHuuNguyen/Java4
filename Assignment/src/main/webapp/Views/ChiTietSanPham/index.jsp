<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 3/16/2023
  Time: 11:05 AM
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
<div style="margin: 30px">
    <a class="btn btn-primary" href="../ChiTietSanPham/create" >Thêm mới</a>
    <table class="table table-striped-columns">

        <c:if test="${f:length(dsctsp)==0}">
            <center><h3>Không có dữ liệu</h3></center>
        </c:if>
        <c:if test="${f:length(dsctsp)!=0}">
            <thead>
            <tr>
                <th class="col">Id Sản Phẩm</th>
                <th class="col">Tên Sản Phẩm </th>
                <th class="col">Id Nhà Sản Xuất</th>
                <th class="col">Id Màu Sắc</th>
                <th class="col">Id Dòng Sản Phẩm</th>
                <th class="col">Năm Bảo Hành</th>
                <th class="col">Mô Tả</th>

                <th class="col">Số Lượng </th>
                <th class="col">Giá Nhập</th>
                <th class="col">Giá Bán</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${dsctsp}" var="kh">
                <tr>
                    <td class="col">${kh.idSP}</td>
                    <td class="col">${kh.tenSp}</td>
                    <td class="col">${kh.idNSX}</td>
                    <td class="col">${kh.idMauSac}</td>
                    <td class="col">${kh.idDongSP}</td>
                    <td class="col">${kh.namBh}</td>
                    <td class="col">${kh.moTa}</td>
                    <td class="col">${kh.soLuong}</td>
                    <td class="col">${kh.giaNhap}</td>
                    <td class="col">${kh.giaBan}</td>
                    <td class="col"><a class="btn btn-primary" href="../ChiTietSanPham/edit?idSP=${kh.idSP}">Sửa</a>
                        <a class="btn btn-primary" href="../ChiTietSanPham/delete?idSP=${kh.idSP}">Xóa</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </c:if>

    </table>
</div>
</body>
</html>
