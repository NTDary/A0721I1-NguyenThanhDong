<%--
  Created by IntelliJ IDEA.
  User: Thanh Dong
  Date: 19/02/2022
  Time: 10:23 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/caculator" method="post">
    <input type="text" name="numberA" value="" placeholder="Number 1">
    <input type="text" name="numberB" value="" placeholder="Number 2">
    <br>
    <input type="submit" name="choose" value="Addition(+)">
    <input type="submit" name="choose" value="Subtraction(-)">
    <input type="submit" name="choose" value="Multiplication(X)">
    <input type="submit" name="choose" value="Division(/)">
  </form>
  </body>
</html>
