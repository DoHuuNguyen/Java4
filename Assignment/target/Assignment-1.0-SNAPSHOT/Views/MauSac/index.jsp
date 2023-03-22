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
    <title>Chức Vụ</title>
</head>
<body>
<div style="margin: 30px">
    <a class="btn btn-primary" href="../MauSac/create" >Thêm mới</a>
    <table class="table table-striped-columns">
        <c:if test="${f:length(dsMauSac)==0}">
            <center><h3>Không có dữ liệu</h3></center>
        </c:if>
        <c:if test="${f:length(dsMauSac)!=0}">
            <thead>
            <tr>
                <th class="col">Mã</th>
                <th class="col">Tên</th>
                <th class="col"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${dsMauSac}" var="ms">
                <tr>
                    <td class="col">${ms.ma}</td>
                    <td class="col">${ms.ten}</td>
                    <td class="col"><a class="btn btn-primary" href="../MauSac/edit?ma=${ms.ma}">Sửa</a>
                        <a class="btn btn-primary" href="../MauSac/delete?ma=${ms.ma}">Xóa</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </c:if>
    </table>
</div>
</body>
</html>
