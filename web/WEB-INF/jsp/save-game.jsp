<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 15.05.2020
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new game</title>
</head>
<body>
<form action="saveGame" method="post">
    <p>
        <label for="name">Game name: </label>
        <input type="text" name="name" id="name">
    </p>
    <p>
        <label for="genre">Genre: </label>
        <input type="text" name="genre" id="genre">
    </p>
    <p>
        <label for="companyName">Company Name: </label>
        <input type="text" name="companyName" id="companyName">

    </p>
    <p>Название игры: </p>
    <%--<input type="text" name="name"><br>--%>
    <%--<p>Жанр игры:</p>--%>
    <%--<input type="text" name="genre"><br>--%>
    <%--<select name="genreId" >--%>
    <%--<c:forEach var="genre" items="${requestScope.genres}">--%>
    <%--<option value="${genre.name}">${genre.name}</option>--%>
    <%--</c:forEach>--%>
    <%--</select>--%>
    <%--<p>Имя компании:</p>--%>
    <%--<input type="text" name="companyName"><br>--%>
    <%--<br>--%>

    <a href="uploadFile">Add files</a>

    <button type="submit">Create game</button>
</form>
</body>
</html>
