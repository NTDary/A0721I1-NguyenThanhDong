<%--
  Created by IntelliJ IDEA.
  User: Thanh Dong
  Date: 19/01/2022
  Time: 10:58 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">
<head>
    <title>Furama DashBoard</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">


    <script src="../bootstrap-4.6.0/js/bootstrap.js"></script>
    <link rel="stylesheet" href="../bootstrap-4.6.0/css/bootstrap.css">

    <link rel="stylesheet" href="../bootstrap-4.6.0/css/myStyle.css">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo03"
            aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <a class="navbar-brand" href="/">Logo</a>

    <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
        <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
            <li class="nav-item active">
                <a class="nav-link" href="/">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Employee</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="customer?action=customer">Customer</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Service</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Contract</a>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>
<div class="container-fluid text-center" style="margin-top: 20px">
    <div class="row content">
        <div class="col-sm-2 sidenav">
            <p><a href="#">Item One</a></p>
            <p><a href="">Item Two</a></p>
            <p><a href="#">Item Three</a></p>
        </div>
        <div class="col-sm-10 text-center">
            <form method="post">
                <table border="1" cellpadding="5">
                    <tr>
                        <th>Type:</th>
                        <c:if test="${customer != null}">
                            <input type="hidden" name="id" value="<c:out value='${customer.customer_id}' />"/>
                        </c:if>
                        <td>
                            <select class="custom-select mr-sm-2" name="id_type" id="inlineFormCustomSelect">
                                <c:forEach var="rentType" items="${customerTypes}">
                                    <c:if test="${customer.customer_type_id == rentType.customer_type_id}">
                                        <option selected value="${rentType.customer_type_id}">${rentType.customer_type_name}</option>
                                    </c:if>
                                    <c:if test="${customer.customer_type_id != rentType.customer_type_id}">
                                        <option value="${rentType.customer_type_id}">${rentType.customer_type_name}</option>
                                    </c:if>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th>Name:</th>
                        <td>
                            <input type="text" class="form-control" name="name" value="<c:out value="${customer.customer_name}"/>">
                        </td>
                    </tr>
                    <tr>
                        <th>Birthday:</th>
                        <td>
                            <input type="date" class="form-control" name="birthday" value="<c:out value="${customer.customer_birthday}"/>">
                        </td>
                    </tr>
                    <tr>
                        <th>Gender:</th>
                        <td>
                            <c:if test="${customer.customer_gender == 0}">
                                <div class="form-check form-check-inline">
                                    <input checked class="form-check-input" type="radio" name="gender" value=0>
                                    <label class="form-check-label">Male</label>
                                </div>
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="gender" value=1>
                                    <label class="form-check-label">Famale</label>
                                </div>
                            </c:if>
                            <c:if test="${customer.customer_gender == 1}">
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="gender" value=0>
                                    <label class="form-check-label">Male</label>
                                </div>
                                <div class="form-check form-check-inline">
                                    <input checked class="form-check-input" type="radio" name="gender" value=1>
                                    <label class="form-check-label">Famale</label>
                                </div>
                            </c:if>

                        </td>
                    </tr>
                    <tr>
                        <th>ID Card:</th>
                        <td>
                            <input type="text" class="form-control" name="id_card" value="<c:out value="${customer.customer_id_card}"/>">
                        </td>
                    </tr>
                    <tr>
                        <th>Phone:</th>
                        <td>
                            <input type="text" class="form-control" name="phone" value="<c:out value="${customer.customer_phone}"/>">
                        </td>
                    </tr>
                    <tr>
                        <th>Email:</th>
                        <td>
                            <input type="text" class="form-control" name="email" value="<c:out value="${customer.customer_email}"/>">
                        </td>
                    </tr>
                    <tr>
                        <th>Address:</th>
                        <td>
                            <input type="text" class="form-control" name="address" value="<c:out value="${customer.customer_address}"/>">
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <input class="btn btn-primary" type="submit" value="Save Customer"/>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>
<footer id="sticky-footer" class="flex-shrink-0 py-4 bg-dark text-white-50">
    <div class="container text-center">
        <small>Copyright &copy; Your Website</small>
    </div>
</footer>
</body>
