<%--
  Created by IntelliJ IDEA.
  User: Thanh Dong
  Date: 12/01/2022
  Time: 06:48 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="/users?action=create">Add New User</a>
    </h2>
    <form action="users">
        <label for="site-search">Search the site:</label>
        <input type="search" id="site-search" name="txt"
               aria-label="Search through site content">
        <input hidden type="search" id="site-search" name="action" value="search"
               aria-label="Search through site content">
        <%--    <a href="/products?action=search">Search</a>--%>
        <button type="submit">Search</button>
    </form>
</center>

<div align="center">
    <a href="/users?action=sortASC">Sort A-Z</a>
    <a href="/users?action=sortDESC">Sort Z-A</a>
    <table border="1" cellpadding="5">
        <caption><h2>List of Users</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Country</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="user" items="${listUser}">
            <tr>
                <td><c:out value="${user.id}"/></td>
                <td><c:out value="${user.name}"/></td>
                <td><c:out value="${user.email}"/></td>
                <td><c:out value="${user.country}"/></td>
                <td>
                    <a href="/users?action=edit&id=${user.id}">Edit</a>
                    <a href="/users?action=delete&id=${user.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>