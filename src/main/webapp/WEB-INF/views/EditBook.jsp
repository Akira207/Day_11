<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Book</title>
</head>
<body>
<jsp:include page="Menu.jsp"></jsp:include>
<h1>Edit Book</h1>
<form action="${pageContext.request.contextPath}/EditBookServlet" method="post">
    Book ID: <input type="text" name="bookId" value="${book.bookId}" readonly><br>
    Title: <input type="text" name="title" value="${book.title}"><br>
    Author: <input type="text" name="author" value="${book.author}"><br>
    Release Year: <input type="text" name="releaseYear" value="${book.release}"><br>
    Price: <input type="text" name="price" value="${book.price}"><br>
    Picture: <input type="text" name="picture" value="${book.picture}"><br>
    Publisher ID: <input type="text" name="publisherId" value="${book.publisherId}"><br>
    Category ID: <input type="text" name="categoryId" value="${book.categoryId}"><br>

    <input type="submit" value="Save Changes">
</form>
<a href="BookList">Back to Book List</a>
</body>
</html>