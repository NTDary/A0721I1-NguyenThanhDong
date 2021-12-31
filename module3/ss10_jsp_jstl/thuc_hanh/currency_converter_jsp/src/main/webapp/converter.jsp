<%--
  Created by IntelliJ IDEA.
  User: Thanh Dong
  Date: 31/12/2021
  Time: 01:06 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Converter</title>
</head>
<body>
<%
    float rate = Float.parseFloat(request.getParameter("rate"));
    float usd = Float.parseFloat(request.getParameter("usd"));

    float vnd = rate * usd;
%>
<h1><%= rate %></h1>
<h1><%= usd %></h1>
<h1><%= vnd %></h1>
</body>
</html>
