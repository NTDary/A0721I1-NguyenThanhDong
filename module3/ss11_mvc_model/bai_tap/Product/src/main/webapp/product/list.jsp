<%--
  Created by IntelliJ IDEA.
  User: Thanh Dong
  Date: 09/01/2022
  Time: 11:48 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Product List</title>
</head>
<body>
<h1>Products</h1>
<p>
    <a href="/products?action=create">Create new products</a>
</p>
<form action="products">
    <label for="site-search">Search the site:</label>
    <input type="search" id="site-search" name="txt"
           aria-label="Search through site content">
    <input hidden type="search" id="site-search" name="action" value="search"
           aria-label="Search through site content">
<%--    <a href="/products?action=search">Search</a>--%>
    <button type="submit">Search</button>
</form>


<table border="1">
    <tr>
        <td>Id</td>
        <td>Name</td>
        <td>Detail</td>
        <td>Produce</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:forEach items='${requestScope["products"]}' var="product">
        <tr>
            <td>${product.getId()}</td>
            <td><a href="/products?action=view&id=${product.getId()}">${product.getName()}</a></td>
            <td>${product.getDetail()}</td>
            <td>${product.getProducer()}</td>
            <td><a href="/products?action=edit&id=${product.getId()}">edit</a></td>
            <td><a href="/products?action=delete&id=${product.getId()}">delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
