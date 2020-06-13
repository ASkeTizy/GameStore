<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 24.05.2020
  Time: 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajax demo</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.0.0.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/demo.js"></script>
</head>
<body>
 Some text: <input  id="data-input" type="text" >
<button type="button" onclick="printInputValueToConsole()">Print to Console</button>
<button type="button" onclick="replaceWithInputData()">Replace</button>
<%--<button type="button" onclick="sendInputDataToServer()">Send To Server</button>--%>
<p id ="displayed-data">Original data</p>
</body>
</html>
