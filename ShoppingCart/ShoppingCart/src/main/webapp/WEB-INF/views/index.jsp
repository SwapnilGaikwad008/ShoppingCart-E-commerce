<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>shopping Cart</title>
</head>
<style>
body{
 margin-top:-10px;
}

</style>
<body>

<jsp:include page="navbar.jsp"></jsp:include>

 <jsp:include page="mainpage.jsp"></jsp:include> 

${successMsg}
<c:if test="${LoadPage=='login'}">
<jsp:include page="login.jsp"></jsp:include>
</c:if>

<c:if test="${not empty errorMsg}">
  ${errorMsg}
  <jsp:include page="login.jsp"></jsp:include> 
  </c:if>

<c:if test="${LoadPage=='registration' }">
<jsp:include page="registration.jsp"></jsp:include>
</c:if>

<c:if test="${ShowProductsForSubCategory}">
<jsp:include page="productdisplay.jsp" />
</c:if>	
			
<c:if test="${!empty selectedProduct.product.id}">
 <jsp:include page="item.jsp"></jsp:include>
</c:if>
</body>
</html>