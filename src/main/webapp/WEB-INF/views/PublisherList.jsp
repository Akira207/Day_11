<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Publisher List</title>
</head>
<body>
<jsp:include page="Menu.jsp"></jsp:include>
<h1>Publisher List</h1>
<table border="1">
    <tr>
        <th>Publisher ID</th>
        <th>Publisher Name</th>
        <th>Phone</th>
        <th>Address</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <%-- Loop through the list of publishers and display each publisher --%>
    <c:forEach var="publisher" items="${publisherList}">
        <tr>
            <td>${publisher.publisherId}</td>
            <td>${publisher.publisherName}</td>
            <td>${publisher.phone}</td>
            <td>${publisher.address}</td>
            <td><a href="EditPublisher?id=${publisher.publisherId}">Edit</a></td>
            <td><a href="DeletePublisher?id=${publisher.publisherId}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<br>
<a href="AddPublisherServlet">Create New Publisher</a>
</body>
</html>