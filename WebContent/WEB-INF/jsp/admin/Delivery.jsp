<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: owner
  Date: 11/26/16
  Time: 6:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Orders</title>

    <link href="<c:url value="/css/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/css/bootstrap/css/bootstrap-theme.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/css/style.css"/>" rel="stylesheet">
</head>
<body>

<nav class="navbar navbar-default navbar-fixed-top navbar-inverse">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/admin/home">Online Shop</a>
        </div>

        <div class="collapse navbar-collapse" id="navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="/admin/home">Home</a></li>
                <li><a href="/admin/products">Products</a></li>
                <li><a href="/admin/users">Users</a></li>
                <li class="active"><a href="/admin/orders">Orders</a></li>

            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/admin">LogOut</a></li>
            </ul>
        </div>
    </div>
</nav>


<div class="container">
            <h4>${message}</h4>

            <table class="table table-hover table-condensed table-responsive">
                <thead>
                <tr>
                    <th>Latitude</th>
                    <th>Longitude</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${addresses}" var="address">
                    <tr>
                        <td>${address.latitude}</td>
                        <td>${address.longitude}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="/css/bootstrap/js/bootstrap.min.js"></script>

</body>
</html>

