<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="${pageContext.request.contextPath}/product/add-product" method="post">
		Product Name: <input type="text" name="productName"><br>
		Product Description: <textarea rows="5" cols="30" name="productDescription"></textarea><br>
		Product Price: <input type="number" name="productPrice"><br>
		
		<input type="submit" value="Add Product">
		
	</form>
	
	<a href="${pageContext.request.contextPath}/home">Back</a>


</body>
</html>