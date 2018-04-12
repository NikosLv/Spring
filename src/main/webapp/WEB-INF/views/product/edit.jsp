<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="${pageContext.request.contextPath}/product/edit-product" method="post">
		<input type="hidden" name="productId" value="${productModel.id}">
		Product Name: <input type="text" name="productName" value="${productModel.name}"> <br>
		Product Description: 
		<textarea rows="5" cols="30" name="productDescription">	${productModel.description}	</textarea> <br>
		Product Price: <input type="number" name="productPrice" value="${productModel.price }"> <br>
		
		<input type="submit" value="Edit Product">
	</form>

</body>
</html>