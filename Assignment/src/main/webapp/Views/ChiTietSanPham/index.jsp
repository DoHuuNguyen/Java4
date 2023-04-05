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
<div style="margin: 30px">
    <a class="btn btn-primary" href="../ChiTietSanPham/create" >Thêm mới</a>
    <table class="table table-striped-columns">

        <c:if test="${f:length(dsctsp)==0}">
            <center><h3>Không có dữ liệu</h3></center>
        </c:if>
        <c:if test="${f:length(dsctsp)!=0}">
            <thead>
            <tr>
                <th class="col">Sản Phẩm</th>
                <th class="col">Nhà Sản Xuất</th>
                <th class="col">Màu Sắc</th>
                <th class="col">Dòng Sản Phẩm</th>
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
                    <td class="col">${kh.sanPham.ten}</td>
                    <td class="col">${kh.nsx.ten}</td>
                    <td class="col">${kh.mauSac.ten}</td>
                    <td class="col">${kh.dongSP.ten}</td>
                    <td class="col">${kh.namBH}</td>
                    <td class="col">${kh.moTa}</td>
                    <td class="col">${kh.soLuongTon}</td>
                    <td class="col">${kh.giaNhap}</td>
                    <td class="col">${kh.giaBan}</td>
                    <td class="col"><a class="btn btn-primary" href="../ChiTietSanPham/edit?idSP=${kh.id}">Sửa</a>
                        <a class="btn btn-primary" href="../ChiTietSanPham/delete?idSP=${kh.id}">Xóa</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </c:if>

    </table>
</div>
