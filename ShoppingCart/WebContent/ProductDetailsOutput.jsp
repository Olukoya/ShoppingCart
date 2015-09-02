<!DOCTYPE html>
<html lang="en">
<%@ page import ="javax.servlet.http.HttpSession" %>

<% String user= (String) session.getAttribute("username");%>
<head>
  <title>Product Details</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
 <link rel="stylesheet" href="jquery.rateyo.css"/>
  
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="index.jsp">Product Details</a>
    </div>
   <div>
<form action = "ProductDetails" method="post">
 <div class="form-group">
 	<button style="float: right" type="submit" class="glyphicon glyphicon-shopping-cart" name="view" id="view"></button>
	</div>
  </form>
</div>
  </div>
  
</nav>

<div class="container-fluid">
${message}
</div>
<div style="text-align:center">
<form name="cart" action="Cart" method="POST">
<div class="form-group">
	<select name= "quantity" id= "quantity">
  <option value=1>1</option>
  <option value=2>2</option>
  <option value=3>3</option>
  <option value=4>4</option>
  <option value=5>5</option>
  <option value=6>6</option>
  <option value=7>7</option>
  <option value=8>8</option>
  <option value=9>9</option>
  <option value=10>10</option>
	</select>
 	<button type="submit" class="btn btn-primary btn-xs" name="cart" id="cart">Add to Cart</button>
	
	</div>
	
</form>
</div>
<div class="container-fluid">
   <form name="return" action="ProductList" method="POST">
    <div style="text-align:center" class="form-group">
 	<button type="submit" class="btn btn-primary btn-xs" name="return" id="return">Return to Item List</button>

	</div>
  </form>
</div> 
</body>
</html>
