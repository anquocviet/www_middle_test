<%@ page import="java.util.Set" %>
<%@ page import="fit.se.de_01.models.LoaiThuoc" %><%--
  Created by IntelliJ IDEA.
  User: vie
  Date: 14/10/24
  Time: 13:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách các loại thuốc</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        h1 {
            text-align: center;
            color: #333;
        }

        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
            background-color: #fff;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        th, td {
            padding: 12px;
            border: 1px solid #ddd;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }

        a {
            color: #007bff;
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }

        .nav-links {
            text-align: center;
            margin: 20px 0;
        }
    </style>
</head>
<%
    Set<LoaiThuoc> loaiThuocSet = (Set<LoaiThuoc>) request.getAttribute("ds-loai-thuoc");
%>
<body>
<h1>21080821 - An Quốc Việt</h1>
<div class="nav-links">
    <a href="index.jsp">Trang chủ</a>
    |
    <a href="controller?action=get-ds-thuoc">Danh sách thuốc</a>
    |
    <a href="controller?action=them-thuoc">Thêm thuốc mới</a>
</div>
<table>
    <thead>
    <tr>
        <th>Mã loại thuốc</th>
        <th>Tên loại thuốc</th>
        <th>Danh sách thuốc</th>
    </tr>
    </thead>
    <tbody>
    <%
        for (LoaiThuoc loaiThuoc : loaiThuocSet) {
    %>
    <tr>
        <td><%= loaiThuoc.getMaLoai() %>
        </td>
        <td><%= loaiThuoc.getTenLoai() %>
        </td>
        <td>
            <a href="controller?action=get-ds-thuoc-by-loai&ma-loai=<%= loaiThuoc.getMaLoai() %>">Xem danh sách</a>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
</body>
</html>