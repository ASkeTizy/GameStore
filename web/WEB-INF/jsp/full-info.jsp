<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 16.05.2020
  Time: 10:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Full Game Info</title>
</head>
<body>
<p>Название: ${requestScope.game.name}</p>
<p>Жанр: ${requestScope.game.genre}</p>
<p>Имя компании: ${requestScope.game.companyName} </p>
<a href="download-file">Download file</a>
<p><a href="${pageContext.request.contextPath}/add?id=${requestScope.game.id}">Add to lib</a></p>

<p><a href="/logout">Logout</a></p>
<p><a href="/game-list">Go Back</a></p>

</body>
</html>
