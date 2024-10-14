<%@ page import="java.util.Arrays" %><%--
  Created by IntelliJ IDEA.
  User: vie
  Date: 14/10/24
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         isErrorPage="true"
%>
<html>
<head>
    <title>Error</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        h1 {
            text-align: center;
            color: #d9534f;
        }

        .error-container {
            width: 80%;
            margin: 20px auto;
            background-color: #fff;
            padding: 20px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        p {
            color: #333;
        }

        .stacktrace {
            background-color: #f9f9f9;
            padding: 10px;
            border: 1px solid #ddd;
            overflow-x: auto;
        }
    </style>
</head>
<body>
<div class="error-container">
    <h1>Error</h1>
    <p><%= exception.getMessage() %>
    </p>
    <div class="stacktrace">
        <pre><%= Arrays.toString(exception.getStackTrace()) %></pre>
    </div>
</div>
</body>
</html>