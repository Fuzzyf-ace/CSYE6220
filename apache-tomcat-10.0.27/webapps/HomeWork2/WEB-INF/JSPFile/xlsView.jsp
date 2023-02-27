<%@ page import="org.apache.poi.ss.usermodel.Sheet" %>
<%@ page import="org.apache.poi.ss.usermodel.Row" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="org.apache.poi.ss.usermodel.Cell" %>
<%@ page import="org.apache.poi.hssf.usermodel.HSSFWorkbook" %>
<%--
  Created by IntelliJ IDEA.
  User: daimingyang
  Date: 2/6/23
  Time: 4:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    HttpSession httpSession = request.getSession();
    String fileName = (String) httpSession.getAttribute("file_name");
    HSSFWorkbook xlsFile = (HSSFWorkbook) httpSession.getAttribute(fileName);
%>

<html>
<head>
    <a href="/">Back to homework2</a>
    <a href="/logout">Logout</a>
    <title><%=fileName%></title>
</head>
<body>
<%
    if (xlsFile == null) {
%>
    File Not Found. Please check the file name!
<%
    }
%>
<%
    if (xlsFile != null) {
%>
<%
    int sheetCount = xlsFile.getNumberOfSheets();
    for (int i = 0; i < sheetCount; i++) {
        Sheet sheet = xlsFile.getSheetAt(i);
        String sheetName = sheet.getSheetName();
%>
<h2>Sheet: <%=sheetName%></h2>
<table border="1">
    <%
        Iterator<Row> rows = sheet.iterator();
        Row headers = rows.next();
    %>
    <tr>
        <%
            for (Cell header : headers) {
        %>
        <th><%=header.toString()%></th>
        <%
            }
        %>
    </tr>
    <%
        while (rows.hasNext()) {
            Row row = rows.next();
    %>
    <tr>
        <%
            for (Cell cell : row) {
        %>
        <td><%=cell.toString()%></td>
        <%
            }
        %>
    </tr>
    <%
        }
    %>
</table>
<%
    }
%>
<%
    }
%>
</body>
</html>
