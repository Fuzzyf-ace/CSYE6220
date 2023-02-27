<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>HomeWork2-CSYE6220</title>
</head>
<body>
<a href="http://localhost:8080/logout">Logout</a>
<h1><%= "CSYE 6220 HomeWork2" %>
</h1>
<h2>Daiming Yang</h2>
<br/>
<form method="post" action="/getCsv.csv">
    <label for="csv_file_name">
        CSV File Name: <input type="text" id="csv_file_name" name="file_name" value="parking_facilities">
    </label>
    <input type="submit" value="Retrieve file">
</form>
<form method="post" action="/getXls.xls">
    <label for="xls_file_name">
        XLS File Name: <input type="text" id="xls_file_name" name="file_name" value="store">
    </label>
    <input type="submit" value="Retrieve file">
</form>
<a href="/shopping">Go Shopping</a>
</body>
</html>