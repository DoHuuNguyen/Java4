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
<div style="margin: 30px">
    <a class="btn btn-primary" href="../CuaHang/create" >Thêm mới</a>
    <table class="table table-striped-columns">
        <c:if test="${f:length(dsCuaHang)==0}">
            <center><h3>Không có dữ liệu</h3></center>
        </c:if>
        <c:if test="${f:length(dsCuaHang)!=0}">
            <thead>
            <tr>
                <th class="col">Mã</th>
                <th class="col">Tên</th>
                <th class="col">Địa Chỉ</th>
                <th class="col">Thành Phố</th>
                <th class="col">Quốc Gia</th>
                <th class="col"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${dsCuaHang}" var="ch">
                <tr>
                    <td class="col">${ch.ma}</td>
                    <td class="col">${ch.ten}</td>
                    <td class="col">${ch.diaChi}</td>
                    <td class="col">${ch.thanhPho}</td>
                    <td class="col">${ch.quocGia}</td>
                    <td class="col"><a class="btn btn-primary" href="../CuaHang/edit?ma=${ch.ma}">Sửa</a>
                        <a class="btn btn-primary" href="../CuaHang/delete?ma=${ch.ma}">Xóa</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </c:if>
    </table>
</div>

