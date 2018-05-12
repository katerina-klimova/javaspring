<%--
  Created by IntelliJ IDEA.
  User: Катя
  Date: 18.04.2018
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>users</title>




</head>
<body>
<div id="wrapper" class="toggled">
    <%@include file="../menu.jsp" %>
    <div id="page-content-wrapper">
        <table>
            <c:forEach items="${allusers}" var="user" varStatus="num">
                <tr>
                    <td><c:out value=" ${num.index+1}"/></td>
                    <td><c:out value=" ${user.getId()}"/></td>
                    <td><c:out value=" ${user.getLogin()}"/></td>
                    <td><c:out value=" ${user.getPassword()}"/></td>
                    <td><c:out value=" ${user.getRole()}"/></td>
                    <td><c:out value=" ${user.getFIO()}"/></td>
                    <td><c:out value=" ${user.getEmail()}"/></td>
                    <td><c:out value=" ${user.isActivity()}"/></td>
                </tr>
            </c:forEach>
        </table>
    </div>


</div>

</body>
</html>
