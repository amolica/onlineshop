<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: owner
  Date: 11/27/16
  Time: 12:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Account</title>

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
                <li><a href="/user/products">Products</a></li>
                <li><a href="/user/cart">Cart</a></li>
                <li class="active"><a href="/user/account">Account</a></li>

            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/user/logout">LogOut</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container">

    ${orderMessage}

        <table class="table table-hover table-condensed table-responsive">
            <thead>
            <tr>
                <th>Order Date</th>
                <th>Price</th>
                <th>Status</th>
            </tr>
            </thead>
            <tbody>
                <c:forEach items="${orders}" var="order">
                    <tr>
                        <td>${order.purchaseDate}</td>
                        <td>${order.amount}</td>
                        <td>${order.orderStatus}</td>
                        <td><button type="submit" class="btn btn-default">Order Details</button></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>


    <h4>$ ${balance}</h4>

    <form:form action="/user/account/pay" method="post">
        <button type="submit">Pay Balance</button>
    </form:form>
</div>



<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="/css/bootstrap/js/bootstrap.min.js"></script>

</body>
</html>
