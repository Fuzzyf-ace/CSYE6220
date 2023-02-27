<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: daimingyang
  Date: 2/7/23
  Time: 2:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/shopping">Continue shopping</a>
<header>cart</header>
<% HttpSession httpSession = request.getSession(false);
    List<String> cart = (List<String>) httpSession.getAttribute("cart");
%>
<% if (cart != null) {
    Iterator<String> cartIterator = cart.iterator();
    %>
    <form action="/shopping/cart" method="post">
    <%
        while (cartIterator.hasNext()) {
            String item = cartIterator.next();
    %>
    <label>
        <input type="checkbox" name="item" value="<%=item%>"><%=item.substring(0,1).toUpperCase() + item.substring(1)%>
    </label>
    <input type="hidden" name="action" value="doDelete">
    <%}%>
    <input type="submit" value="deleteItem">
</form>
    <%}%>
<%if (cart == null) {%>
    Nothing in your cart.
<%}%>

</body>
</html>
