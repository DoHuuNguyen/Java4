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
    <a class="btn btn-primary" href="../KhachHang/create" >Thêm mới</a>
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
                <td class="col"><a class="btn btn-primary" href="../KhachHang/edit?ma=${kh.ma}">Sửa</a>
                    <a class="btn btn-primary" href="../KhachHang/delete?ma=${kh.ma}">Xóa</a></td>
            </tr>
            </c:forEach>
            </tbody>
        </c:if>

    </table>
</div>

