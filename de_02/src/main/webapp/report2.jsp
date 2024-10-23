<%@ page import="fit.se.de_02.models.Candidate" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: vie
  Date: 14/10/24
  Time: 19:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ứng viên sử dụng Gmail</title>
</head>
<%
    List<Candidate> candidates = (List<Candidate>) request.getAttribute("candidates");
%>
<body>
<h1>21080821 - An Quốc Việt</h1>
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
        <td><%= candidate.getFullName() %>
        </td>
        <td><%= candidate.getEmail() %>
        </td>
        <td><%= candidate.getPhone() %>
        </td>
        <td><a href="controller?action=candidate_details&id=<%= candidate.getId() %>">More</a></td>
    </tr>
    <% } %>
    </tbody>
</table>
</body>
</html>
