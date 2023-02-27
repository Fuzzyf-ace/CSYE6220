<%--
  Created by IntelliJ IDEA.
  User: daimingyang
  Date: 2/17/23
  Time: 6:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title></title>
</head>
<body>
<h1>You Searched for <c:out value="${keyword}" /></h1>
<h2>Here are the search results:</h2>
<c:forEach var="movie" items="${searchResult}">
    <table align="center" border="1">
        <tr>
            <th>Movie Title: </th>
            <td><c:out value="${movie.getTitle()}"/></td>
        </tr>
        <tr>
            <th>Lead Actor: </th>
            <td><c:out value="${movie.getActor()}"/></td>
        </tr>
        <tr>
            <th>Lead Actress: </th>
            <td><c:out value="${movie.getActress()}"/></td>
        </tr>
        <tr>
            <th>Genre: </th>
            <td><c:out value="${movie.getActress()}"/></td>
        </tr>
        <tr>
            <th>Year: </th>
            <td><c:out value="${movie.getYear()}"/></td>
        </tr>
        <tr></tr>
    </table>
</c:forEach>
<a href="/movie">Click here to go back to the main page</a>
</body>
</html>
