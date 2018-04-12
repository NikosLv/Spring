<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> ${ pageTitle } </title>
</head>
<body>

	<table border="1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Price</th>
			<th></th>
			<th></th>
			<th></th>
		</tr>
		
		<c:forEach items="${productsList}" var="p">
			<tr>
				<td>${p.id}</td>
				<td>${p.name}</td>
				<td>${p.price}</td>
				<td>
				<a href="${pageContext.request.contextPath}/product/${p.id}">Show</a>
				</td>
				<td>
				<a href="${pageContext.request.contextPath}/product/del/${p.id}">Delete</a>
				</td>
				<td>
				<a href="${pageContext.request.contextPath}/product/edit/${p.id}">Edit</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	
	<a href="${pageContext.request.contextPath}/home">Back</a>

</body>
</html>