<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 15.05.2020
  Time: 14:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All games</title>
</head>
<body>
<c:forEach var="game" items="${requestScope.games}">
    <p><<a href="${pageContext.request.contextPath}/full-info?id=${game.id}">${game.name}</a></p>

</c:forEach>
<a href="/saveGame"a>Add new game</a>
</body>
</html>
