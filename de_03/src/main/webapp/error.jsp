<%--
  Created by IntelliJ IDEA.
  User: vie
  Date: 23/10/24
  Time: 21:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
<h1>Error</h1>
<p>
    <%= exception.getMessage() %>
</p>
<p>
    <%=exception.getStackTrace()%>
</p>
</body>
</html>
