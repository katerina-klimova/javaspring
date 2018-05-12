<%--
  Created by IntelliJ IDEA.
  User: Катя
  Date: 20.04.2018
  Time: 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="wrapper" class="toggled">
    <%@include file="../menu.jsp" %>
    <div id="page-content-wrapper">

<table>
    <c:forEach items="${allitems}" var="item" varStatus="num">
        <tr>
            <td><c:out value=" ${num.index+1}"/></td>
            <td><c:out value=" ${item.getId()}"/></td>
            <td><c:out value=" ${item.getName()}"/></td>
            <td><c:out value=" ${item.getDescription()}"/></td>
            <td><c:out value=" ${item.getCost()}"/></td>
        </tr>
    </c:forEach>
</table>
    </div>
</div>
</body>
</html>
