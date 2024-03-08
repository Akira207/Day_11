<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create New Publisher</title>
</head>
<body>
<jsp:include page="Menu.jsp"></jsp:include>
<h1>Create New Publisher</h1>
<form action="${pageContext.request.contextPath}/AddPublisherServlet" method="post">
    Publisher Name: <input type="text" name="publisherName"><br>
    Phone: <input type="text" name="phone"><br>
    Address: <input type="text" name="address"><br>
    <input type="submit" value="Create">
</form>
<a href="PublisherList">Back to Publisher List</a>
</body>
</html>