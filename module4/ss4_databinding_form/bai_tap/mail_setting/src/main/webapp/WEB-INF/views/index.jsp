<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 2/21/2022
  Time: 6:50 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>$Title$</title>
</head>
<body>
<form:form action="mail" method="post" modelAttribute="mailSetting">
  <fieldset>
    <legend>Login</legend>
    <table>
      <tr>
        <td><form:label path="account">Account:</form:label></td>
        <td><form:input path="account"  /></td>
      </tr>
      <tr>
        <td><form:label path="password">Password:</form:label></td>
        <td><form:input path="password"/></td>
      </tr>
      <tr>
        <td></td>
        <td><form:button>Login</form:button></td>
      </tr>
    </table>
  </fieldset>
</form:form>
</body>
</html>
