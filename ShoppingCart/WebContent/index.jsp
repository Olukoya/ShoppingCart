<!DOCTYPE html>
<html lang="en">
<%@ page import ="javax.servlet.http.HttpSession" %>

<% String user= (String) session.getAttribute("username");%>
<head>
  <title>Index</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
<% if (user == null || user.equals("")) { %>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="index.jsp">Welcome to Shoppers!</a>
    </div>
    <div>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="Sign-up.jsp"><span class="glyphicon glyphicon-user"></span> Sign-up</a></li>
        <li><a href="Login.jsp"><span class="glyphicon glyphicon-user"></span> Login</a></li>
      </ul>
    </div>
  </div>
</nav>
<div class="container">
   <form name="view" action="ProductList" method="POST">
    <div class="form-group">
 	<button type="submit" class="btn btn-primary btn-md" name="view" id="view">View Items</button>

	</div>
  </form>
</div> 

<% } else { %>
   <div>
<form action = "ProductDetails" method="post">
 <div class="form-group">
 	<button style="float: right" type="submit" class="glyphicon glyphicon-shopping-cart" name="view" id="view"></button>
	</div>
  </form>
</div>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="index.jsp">Welcome to Shoppers!</a>
    </div>
    <div>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="index.jsp"><span class="glyphicon glyphicon-user"></span> Logout</a></li>
      </ul>
    </div>
  </div>
</nav>
<div class="container">
   <form name="view" action="ProductList" method="POST">
    <div class="form-group">
 	<button type="submit" class="btn btn-primary btn-md" name="view" id="view">View Items</button>

	</div>
  </form>
</div> 

<% } %>

</body>
</html>
