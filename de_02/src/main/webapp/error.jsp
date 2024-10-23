<%--
  Created by IntelliJ IDEA.
  User: vie
  Date: 15/10/24
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
<h1>Error</h1>
<p><%= request.getAttribute("error") %>
</p>
<a href="index.jsp">Back to home</a>
</body>
</html>
