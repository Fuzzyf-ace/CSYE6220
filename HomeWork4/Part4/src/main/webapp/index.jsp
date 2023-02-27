<%--
  Created by IntelliJ IDEA.
  User: daimingyang
  Date: 2/17/23
  Time: 6:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>Welcome to our Movie Store</h1>
<p>Please make your selection below:</p>
<form action="/movie" method="post">
    <select name="dir">
        <option value="browse">Browse Movies</option>
        <option value="add">Add New Movie to Database</option>
    </select>
    <input type="submit" value="Send"/>
</form>

</body>
</html>
