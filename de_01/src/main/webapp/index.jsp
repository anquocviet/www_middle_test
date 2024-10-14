<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
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
<body>
    <h1>21080821 - An Quốc Việt</h1>
    <div class="nav-links">
        <a href="controller?action=get-ds-loai-thuoc">Danh sách các loại thuốc</a>
        |
        <a href="controller?action=get-ds-thuoc">Danh sách thuốc</a>
        |
        <a href="controller?action=them-thuoc">Thêm thuốc mới</a>
    </div>
</body>
</html>