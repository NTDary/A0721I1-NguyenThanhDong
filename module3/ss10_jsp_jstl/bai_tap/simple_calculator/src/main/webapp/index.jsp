<%--
  Created by IntelliJ IDEA.
  User: Thanh Dong
  Date: 04/01/2022
  Time: 10:48 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h2>Simple Calculator</h2>
<form method="post" action="calculate">
    First operand: <input type="text" value="" name="firstNumber">
    <label for="operator">Choose operate:</label>
    <select id="operator" name="operator">
        <option value="addition">Addition</option>
        <option value="subtraction">Subtraction</option>
        <option value="multiplication">Multiplication</option>
        <option value="division">Division</option>
    </select>
    Second operand: <input type="text" value="" name="secondNumber">
    <input type="submit">
</form>
<h3>${err}</h3>
</body>
</html>
