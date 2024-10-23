<%@ page import="fit.se.de_02.enums.Roles" %>
<%@ page import="java.util.List" %>
<%@ page import="fit.se.de_02.models.Candidate" %>
<%@ page import="fit.se.de_02.models.Experience" %><%--
  Created by IntelliJ IDEA.
  User: vie
  Date: 14/10/24
  Time: 19:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách ứng viên theo role</title>
</head>
<%
    List<Candidate> candidates = null;
    Object obj = request.getAttribute("candidates");
    if (obj != null) {
        candidates = (List<Candidate>) obj;
    }
%>

<body>
<h1>21080821 - An Quốc Việt</h1>
<form action="controller?action=report1" method="get">
    <input type="hidden" name="action" value="report1">
    <label for="role">Role:</label>
    <select id="role" name="role">
        <%
            for (Roles role : Roles.values()) {
        %>
        <option value="<%= role.name() %>"><%= role.name() %>
        </option>
        <%
            }
        %>
    </select>
    <button type="submit">
        View
    </button>
</form>
<%
    if (candidates != null) {
%>
<table>
    <thead>
    <tr>
        <th>Full name</th>
        <th>Email</th>
        <th>Phone</th>
    </tr>
    </thead>
    <tbody>
        <%
        for (Candidate candidate : candidates) {
    %>
    <tr>
        <td><%= candidate.getFullName() %>
        </td>
        <td><%= candidate.getEmail() %>
        </td>
        <td><%= candidate.getPhone() %>
        </td>
    </tr>
        <%

        }
    }
%>
</body>
</html>
