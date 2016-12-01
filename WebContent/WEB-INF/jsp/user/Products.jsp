<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: owner
  Date: 11/20/16
  Time: 1:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Products</title>

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
            <a class="navbar-brand" href="/user/home">Online Shop</a>
        </div>

        <div class="collapse navbar-collapse" id="navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="/user/home">Home</a></li>
                <li class="active"><a href="/user/products">Products</a></li>
                <li><a href="/user/cart">Cart</a></li>
                <li><a href="/user/account">Account</a></li>

            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/user/logout">LogOut</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container">
    <h4><b>${productMessage}</b></h4>
    <table class="table table-hover table-condensed table-responsive">
        <thead>
            <tr>
                <th>Name</th>
                <th>Price</th>
                <th>Quantity</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${products}" var="product">
                <form:form action="/user/products/add" method="get">
                    <tr>
                        <input type="hidden" name="prodId" value="${product.id}">
                        <td>${product.name}</td>
                        <td>${product.price}</td>
                        <td>${product.quantity}</td>
                        <td><button type="submit" class="btn btn-success">Add To Cart</button></td>
                    </tr>
                </form:form>
            </c:forEach>
        </tbody>
    </table>
</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="/css/bootstrap/js/bootstrap.min.js"></script>

</body>
</html>
