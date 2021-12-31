<%@ page import="java.util.List" %>
<%@ page import="model.Customer" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="service.ICustomerService" %><%--
  Created by IntelliJ IDEA.
  User: Thanh Dong
  Date: 31/12/2021
  Time: 03:07 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    table,th,td {
        border:1px solid black;
    }
    caption {
        font-weight: bold;
    }
</style>
<head>
    <title>$Title$</title>
</head>
<body>
<table>
    <caption>Danh sách khách hàng</caption>
    <tr>
        <th>Tên</th>
        <th>Ngày sinh</th>
        <th>Địa chỉ</th>
        <th>Ảnh</th>
    </tr>
    <c:forEach var="customer" items="${customerList}">
        <tr>
            <td><c:out value="${customer.ten}"> </c:out></td>
            <td><c:out value="${customer.ngaysinh}"></c:out></td>
            <td><c:out value="${customer.diachi}"></c:out></td>
            <td><img src="<c:out value="${customer.anh}"></c:out>"></td>
        </tr>
    </c:forEach>
  </table>
</body>
</html>
