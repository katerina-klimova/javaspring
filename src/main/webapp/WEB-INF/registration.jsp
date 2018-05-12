<%--
  Created by IntelliJ IDEA.
  User: Катя
  Date: 07.05.2018
  Time: 9:58
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
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../resources/main.css">
</head>
<body>
<div class="row">
    <div class="col-md-3 col-md-offset-4">
        <div>
            <form:form action="/registration" method="post" modelAttribute="userForm">
                <label for="log">Логин:</label>
                <form:input id="log" class="form-control" type="text" path="login"/>
                <c:if test="${not empty param.get(\"errorLog\")}">
                    <div class="alert alert-danger">
                        ${errorLog}
                    </div>
                </c:if>

                <br/>
                <label for="pas">Пароль:</label><form:input id="pas" class="form-control" type="password" path="password" />
                <c:if test="${not empty param.get(\"errorPass\")}">
                    <div class="alert alert-danger">
                        ${errorPass}
                    </div>
                </c:if>
                <br/>
                <label for="fio">ФИО:</label><form:input id="fio" class="form-control" type="text" path="FIO" />
                <c:if test="${not empty param.get(\"errorName\")}">
                    <div class="alert alert-danger">
                            ${errorName}
                    </div>
                </c:if>
                <br/>
                <form:select path="role">
                    <form:option value="USER_ROLE" />
                    <form:option value="ADMIN_ROLE" />
                </form:select>
                <br/>
                <form:button class="btn btn-success" type="submit" name="reg">Зарегестрироваться</form:button>
            </form:form>
        </div>
    </div>

</div>
</body>
</html>
