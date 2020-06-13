<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 18.05.2020
  Time: 18:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login page</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.0.0.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/senderToServer.js"></script>
</head>
<body>
<form action="${pageContext.request.contextPath}/login" method="post">
    <p>
        <label for="username">Username: </label>
        <input type="text" name="username" id="username" required placeholder="Enter your login">
    </p>
    <p>
        <label for="password">Password: </label>
        <input type="password" name="password" id="password" required placeholder="Enter your password">
    </p>
    <p>
        <button type="button" onclick="sendInputDataToServer()">Login</button>
    </p>
    <p id ="displayed-data"></p>

    <a href="${pageContext.request.contextPath}/registration">Registration</a>

</form>
</body>
</html>
