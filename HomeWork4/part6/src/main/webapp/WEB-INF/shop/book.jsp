<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: daimingyang
  Date: 2/19/23
  Time: 2:47 PM
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
        <h1>Shop for Books</h1>
        <form method="post" action="/cart">
            <div>
                <label>
                    <input type="checkbox" name="items" value="Java Servlet Programming">Java Servlet Programming
                </label>
            </div>
            <div>
                <label>
                    <input type="checkbox" name="items" value="Oracle Database Programming">Oracle Database Programming
                </label>
            </div>
            <div>
                <label>
                    <input type="checkbox" name="items" value="Java Web Services">Java Web Services
                </label>
            </div>
            <input type="submit" value="Add to Cart">
            <input type="hidden" name="action" value="add">
        </form>
        <a href="/shop">View Cart</a>
        <a href="/shop/books">Go to Books Page</a>
        <a href="/shop/music">Go to Music Page</a>
        <a href="/shop/computer">Go to Computer Page</a>
    </main>
</body>
</html>
