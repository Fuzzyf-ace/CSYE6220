<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>How many books do you want to add?</h1>
<form action="/book" method="post">
    <div>
        <input type="number" name="num_books" >
        <input type="submit" value="Sumbit">
    </div>
    <input type="hidden" name="dir" value="addBook">

</form>

</body>
</html>