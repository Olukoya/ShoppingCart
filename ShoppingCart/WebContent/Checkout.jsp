<!DOCTYPE html>
<html lang="en">
<%@ page import ="javax.servlet.http.HttpSession" %>

<% String user= (String) session.getAttribute("username");%>
<head>
  <title>Checkout</title>
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
      <a class="navbar-brand" href="#">Checkout</a>
    </div>
    <%-- Comment --%>
    <%--
    <div>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="Signup.jsp"><span class="glyphicon glyphicon-user"></span> Sign-up</a></li>
        <li><a href="Login.jsp"><span class="glyphicon glyphicon-user"></span> Login</a></li>
      </ul>
    </div>
    --%>
  </div>
</nav>
<div class="container-fluid">
${message}
${message2}
</div>
<div class="container-fluid">
   <form name="checkout" action="Close" method="POST">
    <div style="text-align:center" class="form-group">
 	<button type="submit" class="btn btn-primary btn-md" name="checkout" id="checkout">Pay and Checkout</button>
	</div>
  </form>
  <form name="checkout" action="Close" method="GET">
    <div style="text-align:center" class="form-group">
 	<button type="submit" class="btn btn-primary btn-md" name="checkout" id="checkout">Logout</button>
	</div>
  </form>
  <form name="continue" action="ProductList" method="POST">
    <div style="text-align:center" class="form-group">
 	<button type="submit" class="btn btn-primary btn-md" name="continue" id="continue">Continue Shopping</button>
	</div>
  </form>
</div> 
</body>
</html>
