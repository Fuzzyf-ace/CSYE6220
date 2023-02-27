<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: daimingyang
  Date: 2/19/23
  Time: 12:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/book" method="post">
    <table>
        <tr>
            <th>ISBN</th>
            <th>Book Title</th>
            <th>Authors</th>
            <th>Price</th>
        </tr>
        <c:forEach var="i" begin="1" end="${num}">
            <tr>
                <td><input type="text" name="isbn"></td>
                <td><input type="text" name="bookTitle"></td>
                <td><input type="text" name="authors"></td>
                <td><input type="text" name="price"></td>
            </tr>
        </c:forEach>
    </table>
    <input type="submit" value="Add Books">
    <input type="hidden" name="dir" value="addedBook">
</form>

</body>
</html>
