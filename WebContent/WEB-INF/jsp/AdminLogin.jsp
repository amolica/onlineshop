<%--
  Created by IntelliJ IDEA.
  User: owner
  Date: 11/5/16
  Time: 11:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <title>AdminLogin</title>
</head>
<body>
<h1>Admin Login</h1>

<div class="container">

    <form:form action="/admin/home" method="post">
        <label><b>Username</b></label>
        <input type="text" placeholder="Enter Username" name="uname" required>

        <br/>

        <label><b>Password</b></label>
        <input type="password" placeholder="Enter Password" name="psw" required>

        <br/>

        <button type="submit">Login</button>
    </form:form>

</div>


</body>
</html>
