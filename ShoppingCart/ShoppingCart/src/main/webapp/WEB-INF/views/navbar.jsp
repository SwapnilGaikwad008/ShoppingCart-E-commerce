<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shoes</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script>
    function initializeDropdown() {
    	$('.dropdown-toggle').dropdown();
    }
</script>
</head>
<style>



</style>

<body onload="initializeDropdown();">

<nav class="navbar navbar-default" style="margin-bottom:-15px;">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="mainpage">Paduka</a>
    </div>
    
    
    <ul class="nav navbar-nav">
    <c:forEach items="${categoryList}" var="category">
    
    <li class="dropdown"><a class="dropdown-toggle" id="dLabel-${category.name}" data-toggle="dropdown" href="#">${category.name}<span class="caret"></span></a>
    
    	<ul class="dropdown-menu" aria-labelledby="dLabel-${category.name}">
    	
    		<c:forEach items="${subcategoryList}" var="subcategory">
          		<li><a href="<c:url value='/displayProduct?categoryId=${category.id}&subCategoryId=${subcategory.id}'/>">${subcategory.name}</a></li>
          	</c:forEach>
        </ul>
    
    </li>
    
    </c:forEach>
    </ul>
    

 
 <form class="navbar-form navbar-right" style="margin-left: 0px">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search">
        </div>
         <ul class="nav navbar-nav navbar-right" style="margin-top:0;margin-bottom: -7px";>
         <c:choose>
		    <c:when test="${loggedOut}">
		        <li><a href="registration"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      			<li><a href="login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
		    </c:when>    
		    <c:otherwise>
		        <li><a href="logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
		    </c:otherwise>
		</c:choose>
    </ul>
      </form>
      

 </div>

</nav>
  

</body>
</html>