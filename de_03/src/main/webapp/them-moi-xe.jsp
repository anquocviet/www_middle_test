<%--
  Created by IntelliJ IDEA.
  User: vie
  Date: 23/10/24
  Time: 21:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm mới xe</title>
</head>
<body>
<h1>
    Thêm mới xe
</h1>
<form action="quanly-xe" method="post">
    <input type="hidden" name="action" value="them-xe">
    <br>
    <label for="ten-xe">Tên xe</label>
    <br>
    <input type="text" name="ten-xe" id="ten-xe" placeholder="Tên xe">
    <br>
    <label for="gia">Giá</label>
    <br>
    <input type="number" name="gia" id="gia" placeholder="Giá">
    <br>
    <label for="nam-sx">Năm sản xuất</label>
    <br>
    <input type="number" name="nam-sx" id="nam-sx" placeholder="Năm sản xuất">
    <br>
    <label for="loai-xe">Loại xe</label>
    <br>
    <select name="loai-xe" id="loai-xe"></select>
    <br>
    <br>
    <button type="submit">Thêm xe</button>
</form>
<script>
    const select = document.querySelector("select");
    fetch("api/loai-xe")
        .then(response => response.json())
        .then(data => {
            select.innerHTML = data.map((loaiXe, index) => `
                    <option value="\${loaiXe.maLoai}">\${loaiXe.tenLoai}</option>
                `).join("");
        })
</script>
</body>
</html>
