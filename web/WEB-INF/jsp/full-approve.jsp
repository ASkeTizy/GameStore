<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 03.06.2020
  Time: 12:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Approve </title>
</head>
<body>
<p>Название: ${requestScope.game.name}</p>
<p>Жанр: ${requestScope.game.genre}</p>
<p>Имя компании: ${requestScope.game.companyName} </p>
<a href="download-file">Download file</a>
<a href="${pageContext.request.contextPath}/logout">Logout</a>
<p><button type="submit">Approve</button></p>
</body>
</html>
