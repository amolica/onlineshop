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
            <a class="navbar-brand" href="/admin/home">Online Shop</a>
        </div>

        <div class="collapse navbar-collapse" id="navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="/admin/home">Home</a></li>
                <li class="active"><a href="/admin/products">Products</a></li>
                <li><a href="/admin/users">Users</a></li>
                <li><a href="/admin/orders">Orders</a></li>

            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/admin">LogOut</a></li>
            </ul>
        </div>
    </div>
</nav>


<div class="container">
    <div class="row">
        <div class="col-sm-8 ">
            <div class="page-header">
                <h3>Current Products</h3>
            </div>
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
                    <form:form action="/admin/products/delete" method="get">
                        <input type="hidden" name="prodId" value=${product.id}>
                        <tr>
                            <td>${product.name}</td>
                            <td>${product.price}</td>
                            <td>${product.quantity}</td>
                            <td><button class="btn btn-danger" type="submit">Delete Product</button></td>
                        </tr>
                    </form:form>
                </c:forEach>
                </tbody>
            </table>
        </div>

        <div class="col-sm-4">
            <div class="page-header">
                <h3>Add New Product</h3>
            </div>
            <form:form action="/admin/products/add" method="get">
                <div class="form-group">
                    <label for="formName"><b>Name</b></label>
                    <input type="text" id="formName" class="form-control" placeholder="Enter Name" name="name" required>

                    <label for="formPrice"><b>Price</b></label>
                    <input type="text" id="formPrice" class="form-control" placeholder="Enter Price" name="price" required>

                    <label for="formQuant"><b>Quantity</b></label>
                    <input type="text" id="formQuant" class="form-control" placeholder="Enter Quantity" name="quantity" required>
                </div>

                <button type="submit" class="btn btn-default">Add Product</button>

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

