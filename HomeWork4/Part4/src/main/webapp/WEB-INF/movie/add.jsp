<%--
  Created by IntelliJ IDEA.
  User: daimingyang
  Date: 2/17/23
  Time: 7:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Please enter the details below:</h1>
<form action="/movie" method="post">
    <div>
        <label>
            Movie Title: <input type="text" name="movie_title">
        </label>
    </div>
    <div>
        <label>
            Lead Actor: <input type="text" name="lead_actor">
        </label>
    </div>
    <div>
        <label>
            Lead Actress: <input type="text" name="lead_actress">
        </label>
    </div>
    <div>
        <label>
            Genre: <input type="text" name="genre">
        </label>
    </div>
    <div>
        <label>
            Year: <input type="number" name="year">
        </label>
    </div>
    <div>
        <label>
            <input type="submit" value="Add Movie">
        </label>
    </div>
    <input type="hidden" name="dir" value="added">
</form>
</body>
</html>
