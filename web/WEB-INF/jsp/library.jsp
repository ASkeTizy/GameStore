<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 23.05.2020
  Time: 21:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Library</title>
</head>
<body>
<c:forEach var="game" items="${requestScope.games}">
    <p><<a href="${pageContext.request.contextPath}/full-info?id=${game.id}">${game.name}</a></p>

</c:forEach>
<p><a href="${pageContext.request.contextPath}/saveGame">Create new GamE</a></p>
</body>
</html>
