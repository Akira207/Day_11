<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Publisher</title>
</head>
<body>
<jsp:include page="Menu.jsp"></jsp:include>
<h1>Edit Publisher</h1>
<form action="${pageContext.request.contextPath}/EditPublisher" method="post">
    <input type="hidden" name="publisherId" value="${publisher.publisherId}">
    Publisher Name: <input type="text" name="publisherName" value="${publisher.publisherName}"><br>
    Phone: <input type="text" name="phone" value="${publisher.phone}"><br>
    Address: <input type="text" name="address" value="${publisher.address}"><br>
    <input type="submit" value="Save Changes">
</form>
<a href="PublisherList">Back to Publisher List</a>
</body>
</html>