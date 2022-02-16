<%--
  Created by IntelliJ IDEA.
  User: Thanh Dong
  Date: 18/01/2022
  Time: 09:38 CH
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
<div class="container-fluid text-center">
    <div class="row content">
        <div class="col-sm-2 sidenav">
            <p><a href="#">Item One</a></p>
            <p><a href="#">Item Two</a></p>
            <p><a href="#">Item Three</a></p>
        </div>
        <div class="col-sm-10">
            <h3 class="text-left">Service</h3>
            <div class="d-flex">
                <div class="p-2">
                    <a href="/service?action=create">
                        <button type="button" class="float-left btn btn-primary btn-sm">
                            + Add Service
                        </button>
                    </a>

                </div>
               
                <div class="ml-auto p-2">
                    <form action="service" class="form-inline my-2 my-lg-0">
                        <input style="width: 120px; margin: 0 5px" class="form-control" type="search" placeholder="Id" aria-label="Search" name="id">
                        <input style="width: 120px; margin: 0 5px"class="form-control" type="search" placeholder="Name" aria-label="Search" name="name">
                        <select class="custom-select mr-sm-2" name="rent_type" id="inlineFormCustomSelect">
                            <option value="">Choose</option>
                            <c:forEach var="rentType" items="${rentTypeList}">
                                <option value="${rentType.rentTypeId}">${rentType.rentTypeName}</option>
                            </c:forEach>
                        </select>
                        <input hidden class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="action" value="search">
                        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                    </form>
                </div>
            </div>
            <div class="table-responsive">
                <table class="table table-hover">
                    <thead class="thead-dark">
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Name</th>
                        <th scope="col">Area</th>
                        <th scope="col">Cost</th>
                        <th scope="col">Max People</th>
                        <th scope="col">Id RentType</th>
                        <th scope="col">Id ServiceType</th>
                        <th scope="col">StanDardRoom</th>
                        <th scope="col">Description</th>
                        <th scope="col">Pool Areo</th>
                        <th scope="col">NumberOfFloors</th>
                        <th scope="col">Actions</th>
                    </tr>
                    </thead>
                    <tbody style="font-size: 12px">
                    <c:forEach var="service" items="${serviceList}">
                        <tr>
                            <th scope="row"><c:out value="${service.serviceId}"/></th>
                            <td><c:out value="${service.serviceName}"/></td>
                            <td><c:out value="${service.serviceArea}"/></td>
                            <td><c:out value="${service.serviceCost}"/></td>
                            <td><c:out value="${service.serviceMaxPeople}"/></td>
                            <td><c:out value="${service.rentTypeId}"/></td>
                            <td><c:out value="${service.serviceTypeId}"/></td>
                            <td><c:out value="${service.standardRoom}"/></td>
                            <td><c:out value="${service.descriptionOtherConvenience}"/></td>
                            <td><c:out value="${service.poolArea}"/></td>
                            <td><c:out value="${service.numberOfFloors}"/></td>
                            <td class="action-icon">
                                    <%--                                <a href="/cutomer?action=edit&id=${customer.customer_id}">Edit</a>--%>
                                    <%--                                <a href="/customer?action=delete&id=${customer.customer_id}">Delete</a>--%>
                                <a href="/service?action=view&id=${service.serviceId}">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                         class="bi bi-eye-fill" viewBox="0 0 16 16">
                                        <path d="M10.5 8a2.5 2.5 0 1 1-5 0 2.5 2.5 0 0 1 5 0z"/>
                                        <path d="M0 8s3-5.5 8-5.5S16 8 16 8s-3 5.5-8 5.5S0 8 0 8zm8 3.5a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7z"/>
                                    </svg>
                                </a>
                                <a href="/service?action=edit&id=${service.serviceId}">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                         class="bi bi-pencil-fill" viewBox="0 0 16 16">
                                        <path d="M12.854.146a.5.5 0 0 0-.707 0L10.5 1.793 14.207 5.5l1.647-1.646a.5.5 0 0 0 0-.708l-3-3zm.646 6.061L9.793 2.5 3.293 9H3.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.207l6.5-6.5zm-7.468 7.468A.5.5 0 0 1 6 13.5V13h-.5a.5.5 0 0 1-.5-.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.5-.5V10h-.5a.499.499 0 0 1-.175-.032l-.179.178a.5.5 0 0 0-.11.168l-2 5a.5.5 0 0 0 .65.65l5-2a.5.5 0 0 0 .168-.11l.178-.178z"/>
                                    </svg>
                                </a>
                                <a onClick="if (confirm('Are you sure you want to delete?')); else return false;" href="/service?action=delete&id=${service.serviceId}">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                         class="bi bi-trash-fill" viewBox="0 0 16 16">
                                        <path d="M2.5 1a1 1 0 0 0-1 1v1a1 1 0 0 0 1 1H3v9a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V4h.5a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H10a1 1 0 0 0-1-1H7a1 1 0 0 0-1 1H2.5zm3 4a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 .5-.5zM8 5a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7A.5.5 0 0 1 8 5zm3 .5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 1 0z"/>
                                    </svg>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <nav aria-label="Page navigation example">
                <ul class="pagination justify-content-center">
                    <c:forEach begin="1" end="${endP}" var="i">
                        <li class="page-item"><a class="page-link" href="service?action=service&index=${i}">${i}</a>
                        </li>
                    </c:forEach>
                </ul>
            </nav>
        </div>
    </div>
</div>
<footer id="sticky-footer" class="flex-shrink-0 py-4 bg-dark text-white-50">
    <div class="container text-center">
        <small>Copyright &copy; Your Website</small>
    </div>
</footer>
</body>
