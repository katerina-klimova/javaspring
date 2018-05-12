<%--
  Created by IntelliJ IDEA.
  User: Катя
  Date: 22.04.2018
  Time: 12:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="//netdna.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../resources/main.css">
</head>
<body>

<div class="row">
    <div class="col-md-3 col-md-offset-4">
        <form action="/login" method="post">
            <label for="log">Login:</label><input id="log" class="form-control" type="text" name="username"><br/>
            <label for="pas">Password:</label><input id="pas" class="form-control" type="password" name="password"><br/>
            <button class="btn btn-success" type="submit" name="login">Log In</button>
        </form>
        <c:if test="${not empty param.get(\"error\")}">
            <div id="message-div" class="alert alert-danger">
                Check email and password!
            </div>
        </c:if>
    </div>
    <c:if test="${not empty param.get(\"successAdd\")}">
        <div id="message-div" class="alert alert-danger">
            ${successAdd}
        </div>
    </c:if>
    <div class="col-md-2 col-md-offset-5">
        <form:form action="/registration" method="get">
            <button type="submit">Registration</button>
        </form:form>
    </div>
</div>



</body>
</html>
