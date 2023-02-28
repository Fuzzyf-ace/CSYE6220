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
    <h1>Shop for Laptops</h1>
    <form method="post" action="/cart">
        <div>
            <label>
                <input type="checkbox" name="items" value="secret">不能说的秘密
            </label>
        </div>
        <div>
            <label>
                <input type="checkbox" name="items" value="California Hotel">California Hotel
            </label>
        </div>
        <div>
            <label>
                <input type="checkbox" name="items" value="I'm Going to Tell You a Secret">I'm Going to Tell You a Secret
            </label>
        </div>
        <input type="hidden" name="action" value="add">
        <input type="submit" value="Add to Cart">
    </form>
    <a href="/shop">View Cart</a>
    <a href="/shop/books">Go to Books Page</a>
    <a href="/shop/music">Go to Music Page</a>
    <a href="/shop/computer">Go to Computer Page</a>
</main>
</body>
</html>
