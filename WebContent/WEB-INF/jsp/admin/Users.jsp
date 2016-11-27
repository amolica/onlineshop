<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: owner
  Date: 11/20/16
  Time: 1:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
</head>
<body>

<h1>Users</h1>

<div id="message">
    ${message}
</div>

<div id = container>
    <form action="/admin/users/delete">
        <table>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td><input name="userSelect" type = "radio" value= ${user.id}></td>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    <td>${user.email}</td>
                </tr>
            </c:forEach>
        </table>
        <button type="submit" value="Submit">Delete User</button>
    </form>
</div>

</body>
</html>
