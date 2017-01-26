<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 <style>
.row{
  min-height: 220px;
}

.product-title{
  margin-bottom: 20px;
    transition: width .5s ease;
    transition-property: width;
    transition-duration: 0.5s;
    transition-timing-function: ease;
    transition-delay: initial;
 }

 .product-title a{
 margin-left:10px;
  display: block;
  color: #303030;
 }

 .product-title a img{
    min-height: 177px;
  }
.product-tile .product-info {
    color: #303030;
    font-size: 12px;
    padding: 10px 0 2px;
    text-transform: uppercase;
}
.h4 {
    margin-top: 10px;
    border-top: 1px solid #cccccc;
    font-family: dinnextprolight,"Helvetica Neue",Helvetica,Arial,sans-serif;
    
}


</style>
</head>
<body>

<div class="row">
   <c:forEach items="${productList}" var="product" >
  <div class="col-sm-4 product-title">
    <a href="productviewpage">
      <img src="resources/img/${product.name}.jpg" width="220px" height="220px">

      <div class="product-info">
        <div class="h4">
          <span>${product.name}</span>
        </div>
        <div class="price">
          <span>Rs.${product.price}</span>
        </div>
      </div>

    </a>
    
  </div>
  </c:forEach>




 </div>



</body>
</html>