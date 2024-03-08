<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Book List</title>
</head>
<body>
<jsp:include page="Menu.jsp"></jsp:include>
<h1>Book List</h1>
<p>${errorString}</p>
<table border="1">
    <tr>
        <th>Book ID</th>
        <th>Title</th>
        <th>Author</th>
        <th>Release Year</th>
        <th>Price</th>
        <th>Picture</th>
        <th>Publisher ID</th>
        <th>Category ID</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <%-- Loop through the list of books and display each book --%>
    <c:forEach var="book" items="${bookList}">
        <tr>
            <td>${book.bookId}</td>
            <td>${book.title}</td>
            <td>${book.author}</td>
            <td>${book.release}</td>
            <td>${book.price}</td>
            <td>${book.picture}</td>
            <td>${book.publisherId}</td>
            <td>${book.categoryId}</td>
            <td><a href="EditBookServlet?id=${book.bookId}">Edit</a></td>
            <td><a href="DeleteBookServlet?id=${book.bookId}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<br>
<a href="AddBookServlet">Create New Book</a>
</body>
</html>