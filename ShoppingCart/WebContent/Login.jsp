<!DOCTYPE html>
<html lang="en">
<%@ page import ="javax.servlet.http.HttpSession" %>

<% String user= (String) session.getAttribute("username");%>
<head>
  <title>Login</title>
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
      </ul>
    </div>
  </div>
</nav>

<div class="container">
  <h2>Login Form</h2>
   <form name="loginForm" action="ProductList" method="post">
    <div class="form-group">
      <label for="username">Username: </label>
	  <input type="text" class="form-control" id="username" name= "username">
    </div>
    <div class="form-group">
      <label for="password">Password:</label>
      <input type="password" class="form-control" id="password" name="password">
    </div>
    <div class="form-group">
 	<button type="submit" class="btn btn-primary btn-md" name="login" id="login">Submit</button>
 	<a class="btn btn-primary btn-md" href="index.jsp">Cancel</a>
	</div>
  </form>
</div>

<% } else { %>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="index.jsp">Welcome to Shoppers!</a>
    </div>
    <div>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="index.jsp"><span class="glyphicon glyphicon-user"></span> Logout</a></li>
        <li><a href="ProductDetails"><span class="glyphicon glyphicon-shopping-cart"></span> View Cart</a></li>
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
