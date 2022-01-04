<%--
  Created by IntelliJ IDEA.
  User: Thanh Dong
  Date: 04/01/2022
  Time: 10:31 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customer</title>
    <style>
        table,th,td {
            margin: auto;
            border:1px solid black;
        }
        caption {
            font-weight: bold;
        }
    </style>
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
    <c:forEach items="${customerList}" var="customer" >
        <tr>
            <td><c:out value="${customer.customerName}"></c:out></td>
            <td><c:out value="${customer.customerBirthDay}"></c:out></td>
            <td><c:out value="${customer.customerAddress}"></c:out></td>
            <td><img width="150" height="150" src="<c:out value="${customer.customerImg}"></c:out>" ></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>