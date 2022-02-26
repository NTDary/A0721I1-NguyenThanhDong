<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Thanh Dong
  Date: 23/02/2022
  Time: 06:17 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Send</title>
</head>
<body>
<p>${inforToKhaiYTe.name}</p>
<p>${inforToKhaiYTe.year}</p>
<p>${inforToKhaiYTe.gender}</p>
<p>${inforToKhaiYTe.country}</p>
<p>${inforToKhaiYTe.idCard}</p>
<p>${inforToKhaiYTe.nameVehicle}</p>
<p>${inforToKhaiYTe.idVehicle}</p>
<p>${inforToKhaiYTe.numberSeats}</p>
<p>${inforToKhaiYTe.startDay}</p>
<p>${inforToKhaiYTe.endDay}</p>
<p>${inforToKhaiYTe.description}</p>
<p>${inforToKhaiYTe.city}</p>
<p>${inforToKhaiYTe.district}</p>
<p>${inforToKhaiYTe.ward}</p>
<p>${inforToKhaiYTe.currentAddress}</p>
<p>${inforToKhaiYTe.phone}</p>
<p>${inforToKhaiYTe.email}</p>
<p
<c:forEach items="${inforToKhaiYTe.symptoms}" var="item">
    ${item}<br>
</c:forEach>
</p>
<p
<c:forEach items="${inforToKhaiYTe.exposureHistory}" var="item">
    ${item}<br>
</c:forEach>
</p>

</body>
</html>
