<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create New Book</title>
</head>
<body>
<jsp:include page="Menu.jsp"></jsp:include>
<h1>Create New Book</h1>
<form action="${pageContext.request.contextPath}/AddBookServlet" method="post">
    Book ID: <input type="text" name="bookId"><br>
    Title: <input type="text" name="title"><br>
    Author: <input type="text" name="author"><br>
    Release Year: <input type="text" name="releaseYear"><br>
    Price: <input type="text" name="price"><br>
    Picture: <input type="text" name="picture"><br>
    Publisher ID: <input type="text" name="publisherId"><br>
    Category ID: <input type="text" name="categoryId"><br>
    <input type="submit" value="Create">
</form>
<a href="BookList">Back to Book List</a>
</body>
</html>