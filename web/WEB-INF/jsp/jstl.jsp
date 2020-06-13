<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 11.05.2020
  Time: 19:46
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/functions' prefix='fn' %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Jstl</title>
</head>
<body>
<%--<c:if test="${not empty requestScope.firstUser.password}">--%>
<%--<p>${requestScope.firstUser.password}</p>--%>
<%--</c:if>--%>
<%--<c:if test="${not empty requestScope.secondUser.password}">--%>
<%--<p>${requestScope.secondUser.password}</p>--%>
<%--</c:if>--%>
<%--<c:forEach items="${requestScope.users}" var="user">--%>
<%--<c:if test="${fn:length(user.login) > 1}">--%>
<%--<li>${user.login} :  </li>--%>

<%--</c:if>--%>
<%--</c:forEach>--%>
<form action="${pageContext.request.contextPath}/jstl" method="post">
    <select name="dropdownChoice">
        <option value="J">Java</option>
        <option value="C">C#</option>
        <option value="R">Ruby</option>
    </select><br>
    <br>
    Java: <input type="checkbox" name="language" value="Java"><br>
    C#: <input type="checkbox" name="language" value="C#"><br>
    Ruby: <input type="checkbox" name="language" value="Ruby"><br>
    <br>
    <input type="radio" value="Java" name="RadioChoice">Java<br>
    <input type="radio" value="C#" name="RadioChoice">C#<br>
    <input type="radio" value="Ruby" name="RadioChoice">Ruby<br>
    <button type="submit">Save</button>
</form>
</body>
</html>
