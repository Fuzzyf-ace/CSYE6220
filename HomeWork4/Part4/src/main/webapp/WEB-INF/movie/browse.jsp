<%--
  Created by IntelliJ IDEA.
  User: daimingyang
  Date: 2/17/23
  Time: 6:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>Searching Movies</h1>
<form action="/movie" method="post">
  Keyword: <input type="text" name="keyword">
  <div>
    <label>
      <input type="radio" name="search_by" value="title" checked>Search By Tittle
    </label>
  </div>
  <div>
    <label>
      <input type="radio" name="search_by" value="actor">Search By Actor
    </label>
  </div>
  <div>
    <label>
      <input type="radio" name="search_by" value="actress">Search By actress
    </label>
  </div>
  <div>
    <label>
      <input type="submit" value="Search Movies">
    </label>
  </div>
  <input type="hidden" name="dir" value="searchResult">
</form>
</body>
</html>
