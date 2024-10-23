<%@ page import="java.util.List" %>
<%@ page import="fit.se.de_03.entities.LoaiXe" %><%--
  Created by IntelliJ IDEA.
  User: vie
  Date: 23/10/24
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách loại xe</title>
</head>
<body>
<h1>
    Danh sách loại xe
</h1>
<%
    List<LoaiXe> listLoaiXe = (List<LoaiXe>) request.getAttribute("listLoaiXe");
%>
<table border="1">
    <thead>
    <td>Mã loại xe</td>
    <td>Tên loại xe</td>
    <td>Chức năng</td>
    </thead>
    <tbody>
    <%
        for (LoaiXe loaiXe : listLoaiXe) {
    %>
    <tr>
        <td><%= loaiXe.getMaLoai() %>
        </td>
        <td><%= loaiXe.getTenLoai() %>
        </td>
        <td>
            <button>
                <a href="quanly-xe?action=danh-sach-xe-theo-loai-xe&loai-xe=<%=loaiXe.getMaLoai()%>">
                    Xem danh sách xe
                </a>
            </button>
        </td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
</body>
</html>
