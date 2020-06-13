<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 10.05.2020
  Time: 22:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show user info</title>
</head>
<body>
<p>Пользователь логин: ${requestScope.user.login}</p>
<p>Пользователь пароль: ${requestScope.user.password}</p>
</body>
</html>
