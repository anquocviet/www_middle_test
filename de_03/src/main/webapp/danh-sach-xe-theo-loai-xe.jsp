<%@ page import="fit.se.de_03.entities.Xe" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.DecimalFormat" %><%--
  Created by IntelliJ IDEA.
  User: vie
  Date: 23/10/24
  Time: 21:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách xe theo loại</title>
</head>
<body>
<h1>
    Danh sách xe theo loại xe
</h1>
<%
    List<Xe> listXe = (List<Xe>) request.getAttribute("listXe");
    DecimalFormat decimalFormat = new DecimalFormat("# ###");
%>
<table border="1">
    <thead>
    <td>Mã xe</td>
    <td>Tên xe</td>
    <td>Giá</td>
    <td>Năm sản xuất</td>
    </thead>
    <tbody>
    <%
        for (Xe xe : listXe) {
    %>
    <tr>
        <td><%= xe.getMaXe() %>
        </td>
        <td><%= xe.getTenXe() %>
        </td>
        <td><%= decimalFormat.format(xe.getGia()) %>
        </td>
        <td><%= xe.getNamSX() %>
        </td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
</body>
</html>
