<%--
  Created by IntelliJ IDEA.
  User: owner
  Date: 11/24/16
  Time: 12:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %><html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Sign Up</title>

    <link href="<c:url value="/css/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/css/bootstrap/css/bootstrap-theme.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/css/style.css"/>" rel="stylesheet">


</head>
<body>
<nav class="navbar navbar-default navbar-fixed-top navbar-inverse">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="/">ACA Online Shop</a>
        </div>
    </div>
</nav>

<div class="container">
    <div class="row">
        <div class="col-sm-6">
            <div class="page-header">
                <h3>Sign Up</h3>
            </div>

            <form:form action="/user/login" method="post">
                <div class="form-group">
                    <label for="formFName"><b>First Name</b></label>
                    <input type="text" id="formFName" class="form-control" placeholder="Enter First Name" name="firstname" required>

                    <label for="formLName"><b>Last Name</b></label>
                    <input type="text" id="formLName" class="form-control" placeholder="Enter Last Name" name="lastname" required>

                    <label for="formEmail"><b>Email</b></label>
                    <input type="text" id="formEmail" class="form-control" placeholder="Enter Email" name="email" required>

                    <label for="formPass"><b>Password</b></label>
                    <input type="password" id="formPass" class="form-control" placeholder="Enter Password" name="password" required>

                    <label for="formConf"><b>Confirm Password</b></label>
                    <input type="password" id="formConf" class="form-control" placeholder="Enter Password" name="confirm_password" id="confirm_password" required>

                    <label for="formNum"><b>Building Number</b></label>
                    <input type="text" id="formNum" class="form-control" placeholder="Enter Building Number" name="number" required>

                    <label for="formStreet"><b>Street</b></label>
                    <input type="text" id="formStreet" class="form-control" placeholder="Enter Street" name="street" required>

                    <label for="formCity"><b>City</b></label>
                    <input type="text" id="formCity" class="form-control" placeholder="Enter City" name="city" required>

                    <label for="formCountry"><b>Country</b></label>
                    <input type="text" id="formCountry" class="form-control" placeholder="Enter Country" name="country" required>

                </div>

                <button type="submit" class="btn btn-primary">Sign Up</button>

            </form:form>
        </div>
        <div class="col-sm-6">
            <div class="page-header">
                <h3>Log In</h3>
            </div>

            <form:form action="/user/home" method="post">
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

<script>
    function check_pass(){
        if (document.getElementById('password').value==document.getElementById('confirm_password').value){
            document.getElementById('submit').disabled = false;
        }
        else {
            document.getElementById('submit').disabled = true;
        }
    }
</script>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="/css/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
