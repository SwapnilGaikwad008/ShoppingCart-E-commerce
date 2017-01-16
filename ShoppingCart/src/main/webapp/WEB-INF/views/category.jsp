<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>Add Category</title>
   <meta charset="utf-8">
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
   <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

 ${message}
<div class="container" >
  <h1 class="well center"><center>Add category</center></h1>
  <div class="col-lg-12 well">
    <div class="row">
    <form  action="addcategory" method="post" >
      <div class="col-sm-12">
        <div class="row">
          <div>
            <center><h2>Category Details</h2></center>
          </div>
          <div class="col-sm-6 form-group">
              <h4>ID</h4>
                <input type="text" placeholder="Enter ID.."
                  class="form-control" name="id"></input>
              </div>

              <div class="col-sm-6 form-group">
              <h4>Name</h4>
                <input type="text" placeholder="Enter Name.."
                  class="form-control"  name="name"></input>
              </div>
              
              </div>     

                        <div class="row">
                          <div class="col-sm-12 form-group">
              <h4>Description</h4>
                <textarea type="text" placeholder="Enter Description"
                  class="form-control" name="description"></textarea>
              </div>
                        </div>

                 

            <div class="form-actions">
              <button type="submit" class="btn  btn-lg btn " >Add Category</button>
      
            </div>

        </div>
        
        
        
      </div>
    </form>

     <div class="form-actions " style="float: right">
              <button type="submit" class="btn  btn-lg btn "><a href="categorytable">View Category</a></button>
            </div>
      
    </div>
  </div>
</div>

</body>
</html>