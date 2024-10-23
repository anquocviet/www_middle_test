<%@ page import="fit.se.de_02.models.Candidate" %>
<%@ page import="fit.se.de_02.models.Experience" %>
<%@ page import="java.time.format.DateTimeFormatter" %><%--
  Created by IntelliJ IDEA.
  User: vie
  Date: 14/10/24
  Time: 19:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thông tin chi tiết ứng viên</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
        }

        th {
            background-color: #f2f2f2;
            text-align: left;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        tr:hover {
            background-color: #ddd;
        }
    </style>
</head>
<%
    Candidate candidate = (Candidate) request.getAttribute("candidate");
    DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
%>
<body>
<h1>Thông tin chi tiết ứng viên</h1>
<table>
    <tr>
        <td>Họ và tên</td>
        <td><%= candidate.getFullName() %>
        </td>
    </tr>
    <tr>
        <td>Email</td>
        <td><%= candidate.getEmail() %>
        </td>
    </tr>
    <tr>
        <td>Điện thoại</td>
        <td><%= candidate.getPhone() %>
        </td>
    </tr>
</table>
<h3>Kinh nghiệm</h3>
<table>
    <thead>
    <tr>
        <th>Công ty</th>
        <th>Thời gian</th>
        <th>Vị trí</th>
        <th>Thông tin công việc</th>
    </tr>
    </thead>
    <tbody>
    <% for (Experience experience : candidate.getExperiences()) { %>
    <tr>
        <td><%= experience.getCompanyName() %>
        </td>
        <td>
            <%= experience.getFromDate().format(df) %> - <%= experience.getToDate().format(df) %>
        </td>
        <td><%= experience.getRole() %>
        </td>
        <td><%= experience.getWorkDescription() %>
        </td>
    </tr>
    <% } %>
    </tbody>
</table>
</body>
</html>