<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: daimingyang
  Date: 2/19/23
  Time: 2:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<header>
    <a href="/shop/books">Books</a>
    <a href="/shop/music">Music</a>
    <a href="/shop/computer">Computers</a>
</header>
<main>
    <h1>The Following item has been added to your shopping cart successfully:</h1>
    <c:choose>
        <c:when test="${cart.size() == 0}">
            Welcome to your shop cart, seems nothing added.
        </c:when>
        <c:when test="${cart.size() != 0}">
            <form method="post" action="/cart">
                <ul>
                    <c:forEach var="item" items="${cart}">
                        <li>
                            <input type="checkbox" name="items" value="${item}"/><c:out value="${item}"/>
                        </li>
                    </c:forEach>
                </ul>
                <input type="hidden" name="action" value="delete">
                <input type="submit" value="Delete">
            </form>
        </c:when>
    </c:choose>

    <div>
        <a href="/shop">View Cart</a>
        <a href="/shop/books">Go to Books Page</a>
        <a href="/shop/music">Go to Music Page</a>
        <a href="/shop/computer">Go to Computer Page</a>
    </div>
</main>

</body>
</html>
