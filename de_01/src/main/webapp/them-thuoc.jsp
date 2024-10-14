<%@ page import="fit.se.de_01.models.LoaiThuoc" %>
<%@ page import="java.util.Set" %><%--
  Created by IntelliJ IDEA.
  User: vie
  Date: 14/10/24
  Time: 13:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm thuốc mới</title>
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

        .nav-links {
            text-align: center;
            margin: 20px 0;
        }

        .nav-links a {
            color: #007bff;
            text-decoration: none;
            margin: 0 10px;
        }

        .nav-links a:hover {
            text-decoration: underline;
        }

        form {
            width: 50%;
            margin: 20px auto;
            background-color: #fff;
            padding: 20px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        td {
            padding: 10px;
            border: 1px solid #ddd;
        }

        input[type="text"], select {
            width: 100%;
            padding: 8px;
            margin: 5px 0;
            box-sizing: border-box;
        }

        input[type="submit"] {
            background-color: #007bff;
            color: white;
            padding: 10px 20px;
            border: none;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<%
    Set<LoaiThuoc> dsLoaiThuoc = (Set<LoaiThuoc>) request.getAttribute("ds-loai-thuoc");
%>
<body>
<h1>21080821 - An Quốc Việt</h1>
<div class="nav-links">
    <a href="index.jsp">Trang chủ</a>
    |
    <a href="controller?action=get-ds-loai-thuoc">Danh sách loại thuốc</a>
    |
    <a href="controller?action=get-ds-thuoc">Danh sách thuốc</a>
</div>
<form action="controller" method="post">
    <input type="hidden" name="action" value="them-thuoc">
    <table>
        <tr>
            <td>Tên thuốc</td>
            <td><input type="text" name="ten-thuoc"></td>
        </tr>
        <tr>
            <td>Loại thuốc</td>
            <td>
                <select name="loai-thuoc">
                    <%
                        for (LoaiThuoc loaiThuoc : dsLoaiThuoc) {
                    %>
                    <option value="<%= loaiThuoc.getMaLoai() %>"><%= loaiThuoc.getTenLoai() %>
                    </option>
                    <%
                        }
                    %>
                </select>
            </td>
        </tr>
        <tr>
            <td>Giá bán</td>
            <td><input type="text" name="gia-ban"></td>
        </tr>
        <tr>
            <td>Năm sản xuất</td>
            <td><input type="number" name="nam-sx"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Thêm"></td>
        </tr>
    </table>
</form>
</body>
</html>