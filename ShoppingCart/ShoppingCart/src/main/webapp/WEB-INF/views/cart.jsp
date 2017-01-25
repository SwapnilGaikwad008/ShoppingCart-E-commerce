<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cart</title>
</head>
<body>

<div class="container"> 
<div class="col-md-6">            
  <table class="table">
    <thead>
      <tr>
        <th>CART ID</th>
        <th>PRODUCT NAME</th>
        <th>STOCK</th>
        <th>PRICE</th>
          <th>DELETE</th>
      </tr>
    </thead>
   <tbody>
   <c:forEach items="${CartList}" var="cart">
        <tr>
        
            <td>${cart.id}</td>
            <td>${cart.productname}</td>
            <td>${cart.stock}</td>
             <td>${cart.price}</td>
             <td>${cart.addedDate}</td>
            <td><a href="<c:url value='/cart_delete?id=${cart.id }'/>" button class="btn btn-danger btn-sm">Delete</a></td>
            </tr>
            </c:forEach>
            </tbody>   
  </table>
  
  <h2> Total Cost: ${totalAmount}</h2>
</div>

<a href="cart_checkout"  class="btn btn-md btn-default" >Checkout</a>


</body>
</html>