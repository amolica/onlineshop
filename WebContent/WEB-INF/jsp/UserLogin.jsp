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
    <title>UserLogin</title>
</head>
<body>
<h1>User Login</h1>

<h1>Admin Home</h1>

<div class="container">

    <form:form action="" method="post">
        <label><b>Username</b></label>
        <input type="text" placeholder="Enter Username" name="username" required>

        <br/>

        <label><b>Password</b></label>
        <input type="password" placeholder="Enter Password" name="password" required>

        <br/>

        <button type="submit">Login</button>
    </form:form>

    <br/>

    <a href="/user/signup">Not a member? Sign up here!</a>

</div>

</body>
</html>
