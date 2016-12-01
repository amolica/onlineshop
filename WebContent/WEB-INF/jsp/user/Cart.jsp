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

    <title>Cart</title>

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
                <li class="active"><a href="/user/cart">Cart</a></li>
                <li><a href="/user/account">Account</a></li>

            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/user/logout">LogOut</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container">
    <h2>${orderMessage}</h2>

    <div class="row">
        <div class="col-sm-6">
            <div class="page-header">
                <h3>Current Items</h3>
            </div>
            <table class="table table-hover table-condensed table-responsive">
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Price</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <c:set var="count" value="0" scope="page" />
                <c:forEach items="${order.products}" var="product">
                    <form:form action="/user/cart/remove" method="get">
                        <tr>
                            <input type="hidden" name="productIndex" value="${count}">
                            <td>${product.name}</td>
                            <td>${product.price}</td>
                            <td><button type="submit" class="btn btn-danger">Remove From Cart</button></td>
                        </tr>
                    </form:form>
                    <c:set var="count" value="${count + 1}" scope="page"/>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="col-sm-2"></div>
        <div class="col-sm-4">
            <div class="page-header">
                <h3>Purchase Items</h3>
            </div>
            <h4><b>Total</b></h4>
            <h5><b>$ ${order.amount}</b></h5>
            <form:form action="/user/cart/purchase" method="get">
                <div class="form-group">
                    <label><h4><b>Select Delivery Time</b></h4></label>
                    <div class="radio">
                        <label><input type="radio" name="delivery" value="1" required>Morning</label>
                    </div>
                    <div class="radio">
                        <label><input type="radio" name="delivery" value="2" required>Afternoon</label>
                    </div>
                    <div class="radio">
                        <label><input type="radio" name="delivery" value="3" required>Evening</label>
                    </div>
                </div>
                <button type="submit" class="btn btn-warning">Purchase</button>
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
