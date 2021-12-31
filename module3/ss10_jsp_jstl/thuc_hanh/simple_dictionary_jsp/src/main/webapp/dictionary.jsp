<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: Thanh Dong
  Date: 31/12/2021
  Time: 01:11 CH
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Simple Dictionary</title>
</head>
<body>
<%
    Map<String, String> dic = new HashMap<>();

    dic.put("hello", "Xin chào");
    dic.put("how", "Thế nào");
    dic.put("book", "Quyển vở");
    dic.put("computer", "Máy tính");

    String search = request.getParameter("search");
    String result = dic.get(search);
    if (result != null) {
        out.println("<h3> Word: " + search + "</h3>");
        out.println("Result: " + result);
    } else {
        out.println("Not found");
    }
%>
</body>
</html>
