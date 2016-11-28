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
    <title>Sign Up</title>

    <link href="<c:url value="/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/bootstrap/css/bootstrap-theme.min.css"/>" rel="stylesheet">
</head>
<body>
<h1>Sign Up</h1>

<div class="container">

    <form:form action="/user/login" method="post">
        <label><b>First Name</b></label>
        <input type="text" placeholder="Enter First Name" name="firstname" required>
        <br>

        <label><b>Last Name</b></label>
        <input type="text" placeholder="Enter Last Name" name="lastname" required>
        <br>

        <label><b>Email</b></label>
        <input type="text" placeholder="Enter Email" name="email" required>
        <br>

        <label><b>Password</b></label>
        <input type="password" placeholder="Enter Password" name="password" required>
        <br>

        <label><b>Confirm Password</b></label>
        <input type="password" placeholder="Enter Password" name="confirm_password" id="confirm_password" required>
        <br>

        <label><b>Building Number</b></label>
        <input type="text" placeholder="Enter Building Number" name="number" required>
        <br>

        <label><b>Street</b></label>
        <input type="text" placeholder="Enter Street" name="street" required>
        <br>

        <label><b>City</b></label>
        <input type="text" placeholder="Enter City" name="city" required>
        <br>

        <label><b>Country</b></label>
        <input type="text" placeholder="Enter Country" name="country" required>

        <button type="submit">Sign Up</button>

    </form:form>

    <a href="/user/login">Already a member?</a>

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
<script src="/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
