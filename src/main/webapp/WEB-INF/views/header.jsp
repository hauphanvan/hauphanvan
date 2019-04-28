<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>HauPhanVan.com</title>
	<link rel="shortcut icon" type="image/x-icon" href='<c:url value="/img/title4.png"></c:url>' />
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>

<body>
	<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href='<c:url value="/"></c:url>'>Hauphanvan</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li><a href='<c:url value="/product/products"></c:url>'>Home</a></li>
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="'<c:url value="/product/products/Smartphone"></c:url>'">SmartPhone<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">IPhone</a></li>
            <li><a href="#">SamSung</a></li>
            <li><a href="#">Huawei</a></li>
          </ul>
        </li>
        <li><a href='<c:url value="/product/products/Tablet"></c:url>'>Tablet</a></li>
        <li><a href='<c:url value="/product/products/Laptop"></c:url>'>Laptop</a></li>
        <li><a href='<c:url value="/product/add"></c:url>'>Add New Product</a></li>
        <li><a href='<c:url value="/about"></c:url>'>About</a><li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href='<c:url value="/Signup"></c:url>'><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
        <li><a href='<c:url value="/login"></c:url>'><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
        <li class="dropdown">
        	<a class="dropdown-toggle" data-toggle="dropdown" href="#">Language</a>
        	<ul class="dropdown-menu">
        		<li><a href="?language=en">English</a></li>
        		<li><a href="?language=vi">VietNam</a></li>
        	</ul>
        </li>
      </ul>
    </div>
  </div>
</nav>