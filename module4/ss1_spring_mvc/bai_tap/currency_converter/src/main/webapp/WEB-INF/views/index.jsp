<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Thanh Dong
  Date: 16/02/2022
  Time: 01:57 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Currency Converter</title>
  </head>
  <body>
  <h1>Test</h1>
  <form action="/converter" method="post">
      <tr>
         <td>Số lượng: <input type="text" name="number"></td>
      </tr>
      <tr>
         <td>From:
             <select name="curencyFrom" id="curency-from">
             <option value="usd">USD</option>
             <option value="vnd">VND</option>
            </select>
         </td>
      </tr>
      <tr>
          <td>To:
              <select name="curencyTo" id="curency-to">
                  <option value="usd">USD</option>
                  <option value="vnd">VND</option>
              </select>
          </td>
      </tr>
      <tr>
          <td><input type="submit" value="Convert"></td>
      </tr>

  </form>
  </body>
</html>
