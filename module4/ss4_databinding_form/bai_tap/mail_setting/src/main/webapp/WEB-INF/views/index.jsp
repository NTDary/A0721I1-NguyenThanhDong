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
    <table>
        <tr>
           <th>Languages:</th>
            <td>
                <form:select path="language" >
                <form:option value="English" label="English"/>
                <form:option value="Vietnamese" label="Vietnamese"/>
                <form:option value="Japanese" label="Japanese"/>
                <form:option value="Chinese" label="Chinese"/>
            </form:select>
            </td>
        </tr>
        <tr>
            <th>Page size:</th>
            <td>
                Show
                <form:select path="pageSize" cssStyle="width: 50px">
                    <form:option value="5" label="5"/>
                    <form:option value="10" label="10"/>
                    <form:option value="15" label="15"/>
                    <form:option value="25" label="20"/>
                    <form:option value="50" label="50"/>
                    <form:option value="100" label="100"/>
                </form:select>
                email per page
            </td>
        </tr>
        <tr>
            <th>Spams filler:</th>
            <td>
                <form:checkbox path="filler" label="Enable spams filler"></form:checkbox>
            </td>
        </tr>
        <tr>
            <th>Signature:</th>
            <td>
                <form:textarea path="signature" value=""></form:textarea>
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>

    </table>

</form:form>



</body>

</html>
