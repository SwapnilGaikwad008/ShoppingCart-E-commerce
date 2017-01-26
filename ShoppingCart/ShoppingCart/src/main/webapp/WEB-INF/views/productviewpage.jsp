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
body {
  background-size: cover;
  background-repeat: no-repeat;
}
</style>
</head>
<body>
  
<div class="row">
  <div class="row" style="padding-top:50px;">
    <div class="row">
        <div class="col-sm-1">
        </div>
       <div class="col-sm-5">
          <img src="resources/img/${selectedProduct.product.name}.jpg" class="img-rounded" alt="${selectedProduct.productname}" width="504" height="536" style="box-shadow:1px  gray;">
        </div>
        <div class="col-sm-5">
            <div class="row">
               <div class="col-sm-12">
                  <h3>${selectedProduct.product.name}</h3>
                    <h5>${selectedProduct.category.name} Shoes</h5><br>
                    <h3>Price : ${selectedProduct.product.price}</h3>
                    <div class="row">
                      <div class="col-sm-4">

                        <div class="dropdown">
                          <button class="btn dropdown-toggle btn-md" type="button" data-toggle="dropdown" style="background-color:#C8C8C8;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>Size</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                          <span class="caret"></span></button>
                          <ul class="dropdown-menu">
                            <li><a href="#">5</a></li>
                            <li><a href="#">6</a></li>
                            <li><a href="#">7</a></li>
                          </ul>
                        </div>

                      </div>
                      <div class="col-sm-4">

                        <div class="dropdown" style="margin-left:-70px;">
                          <button class="btn dropdown-toggle btn-md" type="button" data-toggle="dropdown" style="background-color:#C8C8C8;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>Qunatity</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                          <span class="caret"></span></button>
                          <ul class="dropdown-menu" style="margin-left:-5px;">
                            <li><a href="#">5</a></li>
                            <li><a href="#">6</a></li>
                            <li><a href="#">7</a></li>
                          </ul>
                        </div>

                      </div>
                      <div class="col-sm-4" style="margin-left:-110px;">
                          <a  class="btn btn-lg btn-success" href="cart_checkout">Buy</a><br><br>  
                      <c:if test="${not empty loggedInUser}">
               <a class="btn btn-lg btn-success" class="icon-shopping-cart" href="<c:url value='/cart_add?productame=${selectedProduct.productname}'/>">Add to cart</a>
            </c:if>                          
                      </div>
                    </div>
          
                </div>
                <div class="col-sm-8">
                </div>
            </div>
            <h5>FREE DELIVERY Applies to orders of ₹14,000 or more. Returns are free for Nike+ members</h5>
        </div>
        <div class="col-sm-1">
        </div>
    </div>
  </div>
</div>

</body>
</html>