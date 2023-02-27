<%--
  Created by IntelliJ IDEA.
  User: daimingyang
  Date: 2/6/23
  Time: 7:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<header>Welcome!</header>
<form action="j_security_check" method="post">
    <label for="usr_name">
        Username: <input type="text" id="usr_name" name="j_username" value="admin">
    </label>
    <label for="pswd">
        Password: <input type="password" id="pswd" name="j_password" value="admin">
    </label>
    <input type="submit" value="Login">
</form>
</body>
</html>
