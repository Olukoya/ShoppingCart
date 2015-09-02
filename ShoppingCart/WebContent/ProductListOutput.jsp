<!DOCTYPE html>
<html lang="en">
<%@ page import ="javax.servlet.http.HttpSession" %>

<% String user= (String) session.getAttribute("username");%>
<head>
  <title>Product List</title>
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
      <a class="navbar-brand" href="index.jsp">All Products!</a>
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
</body>
</html>
