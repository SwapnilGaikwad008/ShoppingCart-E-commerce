<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>shopping Cart</title>
</head>
<body>

<a href="login">Login </a>
<br>
<a href="register">Register</a>

<hr>
${successMsg}


<c:if test="${LoadPage=='login'}">
<jsp:include page="login.jsp"></jsp:include>
</c:if>

<c:if test="${not empty Msg}">
  ${errorMsg}
  <jsp:include page="login.jsp"></jsp:include> 
  </c:if>

<c:if test="${LoadPage=='registration' }">
<jsp:include page="registration.jsp"></jsp:include>
</c:if>
</body>
</html>