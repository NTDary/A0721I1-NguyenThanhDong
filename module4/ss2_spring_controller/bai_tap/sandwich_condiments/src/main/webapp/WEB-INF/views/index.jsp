<%--
  Created by IntelliJ IDEA.
  User: Thanh Dong
  Date: 19/02/2022
  Time: 09:17 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Sandwich Condiments</title>
  </head>
  <body>
  <h1>Sandwich Condiments</h1>

  <form action="/save" method="post">
    <input type="checkbox" id="condiment1" name="condiment" value="lettuce">
    <label> Lettuce </label><br>
    <input type="checkbox" id="condiment2" name="condiment" value="tomato">
    <label> Tomato </label><br>
    <input type="checkbox" id="condiment3" name="condiment" value="mustard">
    <label> Mustard</label><br>
    <input type="checkbox" id="condiment4" name="condiment" value="sprouts">
    <label> Sprouts</label><br><br>
    <input type="submit" value="Submit">
  </form>
  </body>
</html>
