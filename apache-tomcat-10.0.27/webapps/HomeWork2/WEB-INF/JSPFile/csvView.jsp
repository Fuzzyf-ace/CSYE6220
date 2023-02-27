<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: daimingyang
  Date: 2/6/23
  Time: 12:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    HttpSession httpSession = request.getSession();
    ResultSet resultSet = (ResultSet) httpSession.getAttribute("resultSet");
    String fileName = (String) httpSession.getAttribute("file_name");
%>

<head>
    <a href="/">Back to homework2</a>
    <a href="/logout" position="absolute" right="0">Logout</a>
    <title><%=fileName%></title>
</head>
<body>
<% if (resultSet == null) {%>
    File Not Found. Please check the file name!
<%}%>

<% if (resultSet != null) {%>
<table border="1">
    <tr>
    <%
        int columnCount;
        try {
            columnCount = resultSet.getMetaData().getColumnCount();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        for (int i = 1; i <= columnCount; i++) {
            String columnName;
            try {
                columnName = resultSet.getMetaData().getColumnName(i);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }%>
            <th><%=columnName%></th>
        <%}%>
    </tr>


    <% columnCount = resultSet.getMetaData().getColumnCount();
            while (resultSet.next()) {%>
            <tr>
                <%for (int i = 1; i <= columnCount; i++) {%>
                <td align="center"><%=resultSet.getString(i)%></td>
            <%}%>
            </tr>
        <%}%>
</table>
<%}%>
</body>
</html>
