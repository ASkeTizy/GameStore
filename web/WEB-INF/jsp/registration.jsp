<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 19.05.2020
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration page</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/registration" method="post">
    <p>
        <label for="login">Username: </label>
        <input type="text" name="login" id="login">
    </p>
    <p>
        <label for="password">Password: </label>
        <input type="password" name="password" id="password">
    </p>
    <p>
        <label for="first_name">First Name: </label>
        <input type="text" name="first_name" id="first_name">

    </p>
    <p>
        <label for="last_name">Last Name: </label>
        <input type="text" name="last_name" id="last_name">
    </p>
    <p>
        <label for="age">Age: </label>
        <input type="number" name="age" id="age">
    </p>
    <br>
    <input type="radio" name="gender" value="MALE" checked>MAN
    <input type="radio" name="gender" value="FEMALE">WOMAN

    <p>
        <button type="submit">Login</button>
    </p>
</form>
</body>
</html>
