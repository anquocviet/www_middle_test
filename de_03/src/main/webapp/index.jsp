<%--
  Created by IntelliJ IDEA.
  User: vie
  Date: 23/10/24
  Time: 18:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>An Quoc Viet</title>
</head>
<body>
<button>
    <a href="quanly-xe?action=danh-sach-loai-xe">Xem danh sách loại xe</a>
</button>
<br>
<button>
    <a href="them-moi-xe.jsp">Thêm mới xe</a>
</button>
<br>
<table border="1">
    <thead>
    <td>Mã xe</td>
    <td>Tên xe</td>
    <td>Giá</td>
    <td>Năm sản xuất</td>
    </thead>
    <tbody>

    </tbody>
</table>
<script>
    fetch("api/xe")
        .then(response => response.json())
        .then(data => {
            const tbody = document.querySelector("tbody");
            tbody.innerHTML = data.map((xe, index) => `
        <tr>
        <td>\${xe.maXe}</td>
        <td>\${xe.tenXe}</td>
        <td>\${xe.gia}</td>
        <td>\${xe.namSX}</td>
        </tr>
        `).join("");
        })
</script>
</body>
</html>
