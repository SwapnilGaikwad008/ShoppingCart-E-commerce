<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>product menu</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>



<div class="container">
<ul class=" nav nav-pills" role="tablist">
   <c:forEach items="${categoryList}" var="category">
       <li class="dropdown" ><a href="#" class ="dropdown-toggle"
            data-toggle="dropdown"  role="menu" >${category.name}<span
                 class="caret"></span></a>
           <ul class= "dropdown menu" >
    
      <li><a href="manage_product/get/${product.id}">${product.name}</a></li> 
   
   </ul>

 
  
    </li>
</c:forEach>
</ul> 
</div>
<hr color="red" font="italic">
</body>

</html>