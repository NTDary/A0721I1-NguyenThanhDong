<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 2/16/2022
  Time: 5:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>SimpleDictionary</title>
  </head>
  <body>
  <form action="" method="post">
     English: <input type="text" name="eng">
     Vietnam: <input type="text" name="vn" value=${result}>
      <input type="submit" value="Translate">
  </form>
  <h3>${emptyError}</h3>
  <h3>${StringFormat}</h3>
  </body>
</html>
