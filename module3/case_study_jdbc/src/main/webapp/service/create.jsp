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


    <%--    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">--%>
    <%--    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>--%>
    <%--    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>--%>

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
                <a class="nav-link" href="service?action=service">Service</a>
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
                        <th>ID:</th>
                        <td>
                            <input type="text" class="form-control" name="id" required>
                            <%--                            <p>${name}</p>--%>
                        </td>
                    </tr>
                    <tr>
                        <th>Service Name:</th>
                        <td>
                            <input type="text" class="form-control" name="name" required>
                            <p>${name}</p>
                        </td>
                    </tr>
                    <tr>
                        <th>Area:</th>
                        <td>
                            <input type="text" class="form-control" name="area" >
                            <%--                            <p>${name}</p>--%>
                        </td>
                    </tr>
                    <tr>
                        <th>Cost:</th>
                        <td>
                            <input type="number" class="form-control" name="cost" required>
                        </td>
                    </tr>
                    <tr>
                        <th>Max People:</th>
                        <td>
                            <input type="number" class="form-control" name="max_people" >
                        </td>
                    </tr>
                    <tr>
                        <th>Rent Type:</th>
                        <td>
                            <select class="custom-select mr-sm-2" name="rent_type" id="inlineFormCustomSelect">
                                <c:forEach var="rentType" items="${rentTypeList}">

                                    <option value="${rentType.rentTypeId}">${rentType.rentTypeName}</option>

                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th>Service Type:</th>
                        <td>
                            <select class="custom-select mr-sm-2" name="service_type" id="inlineFormCustomSelect1">
                                <option selected value="">Choose</option>
                                <c:forEach var="serviceType" items="${serviceTypeList}">
                                    <option value="${serviceType.serviceTypeId}">${serviceType.serviceTypeName}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th>StandDard Room:</th>
                        <td>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="room" value="normal" required>
                                <label class="form-check-label">Normal</label>
                            </div>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="room" value="vip" required>
                                <label class="form-check-label">Vip</label>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <th>Description:</th>
                        <td>
                            <input type="text" class="form-control" name="description" value="">
                        </td>
                    </tr>
                    <tr>
                        <th>Pool Area:</th>
                        <td>
                            <input type="text" class="form-control" name="pool_area" value="">
                        </td>
                    </tr>
                    <tr>
                        <th>Number Of Floors:</th>
                        <td>
                            <input type="text" class="form-control" name="number_floor" value="">
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <input class="btn btn-primary" type="submit" value="Add Service"/>
                        </td>
                    </tr>
                </table>
                <%--                <button class="btn btn-primary" type="submit">Submit form</button>--%>
            </form>
        </div>
    </div>
</div>
<footer style="position: static" id="sticky-footer" class="flex-shrink-0 py-4 bg-dark text-white-50">
    <div class="container text-center">
        <small>Copyright &copy; Your Website</small>
    </div>
</footer>
</body>
