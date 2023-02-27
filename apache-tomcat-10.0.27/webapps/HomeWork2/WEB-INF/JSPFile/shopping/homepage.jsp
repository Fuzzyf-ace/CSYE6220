<%@ page import="java.util.Enumeration" %><%--
  Created by IntelliJ IDEA.
  User: daimingyang
  Date: 2/7/23
  Time: 1:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <a href="/">Back to homework2</a>
    <title>Shopping</title>
</head>
<body>
    <a href="/shopping/cart">view my cart</a>
<main>
    <div>
        <form action="/shopping/cart" method="post">
            Browse computer:
            <label>
                <input type="checkbox" name="item" value="apple" >Apple
            </label>
            <label>
                <input type="checkbox" name="item" value="lenovo">Lenovo
            </label>
            <label>
                <input type="checkbox" name="item" value="microsoft">Microsoft
            </label>
            <label>
                <input type="checkbox" name="item" value="whatever">Whatever
            </label>
            <input type="hidden" name="action" value="doPost">
            <input type="submit" value="Add to cart">

        </form>

    </div>
</main>

</body>
</html>
