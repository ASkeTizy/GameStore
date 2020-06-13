<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 03.06.2020
  Time: 12:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Approve List</title>
</head>
<body>
<c:forEach var="game" items="${requestScope.games}">
    <p><<a href="${pageContext.request.contextPath}/full-approve?id=${game.id}">${game.name}</a></p>

</c:forEach>
</body>
</html>
