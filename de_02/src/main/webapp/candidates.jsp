<%@ page import="fit.se.de_02.models.Candidate" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: vie
  Date: 14/10/24
  Time: 19:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách ứng viên</title>
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
        a {
            text-decoration: none;
            color: blue;
        }
    </style>
</head>
<body>
<%
    List<Candidate> candidates = (List<Candidate>) request.getAttribute("candidates");
%>
<table>
    <thead>
        <tr>
            <th>Full name</th>
            <th>Email</th>
            <th>Phone</th>
            <th>More</th>
        </tr>
    </thead>
    <tbody>
        <% for (Candidate candidate : candidates) { %>
            <tr>
                <td><%= candidate.getFullName() %></td>
                <td><%= candidate.getEmail() %></td>
                <td><%= candidate.getPhone() %></td>
                <td><a href="controller?action=candidate_details&id=<%= candidate.getId() %>">More</a></td>
            </tr>
        <% } %>
    </tbody>
</table>
</body>
</html>