<%--
  Created by IntelliJ IDEA.
  User: Thanh Dong
  Date: 30/12/2021
  Time: 05:07 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
   <form action="/display-discount" method="post">
     <input type="text" name="description" placeholder="Product Description">
     <input type="text" name="price" placeholder="Price" value="">
     <input type="text" name="discount" value="0">
     <button type="submit">Submit</button>
   </form>
  </body>
</html>
