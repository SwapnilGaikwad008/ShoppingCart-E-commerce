<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

</head>
<body>
 <jsp:include page="adminHome.jsp" />



 <c:if test="${UserClickedCATEGORY}">
	<jsp:include page="category.jsp" />
	</c:if>

	
 <c:if test="${UserClickedViewCategoryTable}">
		<jsp:include page="categorytable.jsp" />
	</c:if>
	
	
	 <c:if test="${UserClickedEDIT}">
		 <jsp:include page="editcategory.jsp" />
	</c:if>
	
	<c:if test="${EditCategory }">
	<jsp:include page="editcategory.jsp" />
	</c:if>
	

	
	
	
	
	
	
	
</body>
</html>