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
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>AdminLogin</title>

    <link href="<c:url value="/css/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/css/bootstrap/css/bootstrap-theme.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/css/style.css"/>" rel="stylesheet">
</head>
<body>

<nav class="navbar navbar-default navbar-fixed-top navbar-inverse">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="/admin">ACA Online Shop - Admin Portal</a>
        </div>
    </div>
</nav>

<div class="container">

    <div class="row">
        <div class="col-sm-4">
        </div>
        <div class="col-sm-4">
            <div class="page-header">
                <h3>Log In</h3>
            </div>

            <form:form action="/admin/home" method="post">
                <div class="form-group">
                    <label for="forUser"><b>Username</b></label>
                    <input type="text" id="forUser" class="form-control" placeholder="Enter Username" name="username" required>

                    <label for="forPass"><b>Password</b></label>
                    <input type="password" id="forPass" class="form-control" placeholder="Enter Password" name="password" required>
                </div>


                <button type="submit" class="btn btn-primary">Log In</button>
            </form:form>
        </div>
    </div>
</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="/css/bootstrap/js/bootstrap.min.js"></script>

</body>
</html>
