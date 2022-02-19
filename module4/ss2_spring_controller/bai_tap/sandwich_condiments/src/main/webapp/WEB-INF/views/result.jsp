<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Thanh Dong
  Date: 19/02/2022
  Time: 09:55 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Result</h3>
<c:forEach var="condiment" items="${condiment}">
    <p>${condiment}</p>
</c:forEach>

</body>
</html>
