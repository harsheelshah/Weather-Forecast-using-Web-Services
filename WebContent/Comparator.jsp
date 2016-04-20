<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Web Service - Compare</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

</head>
<body background="img.jpg">
<br>

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="index.jsp">WSDL</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
      
      	 <li class="active">
         <a href="/iif-generic-soap-client-master/MyWSDLList">List Projects <span class="sr-only">(current)</span></a></li>
		
      <form class="navbar-form navbar-left" role="search">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
      </form>

    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

<div class="container">
<div class="well">
<form method="post" action="Comparator_Graph">
<h2>

<font color="blue">
Select Project 1:
</font>
<select id="project1" name ="project1">

<c:forEach items="${project}" var="p1">
<option value = "${p1.id }">${p1.id }</option>

</c:forEach>
</select>

<br/><br>
<font color="blue">
Select Project 2:
</font>
<select id="project2" name ="project2">
<c:forEach items="${project }" var="p2">
<option value = "${p2.id }">${p2.id }</option>


</c:forEach>
</select>
<br><br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="submit"  class="btn-success" value="Compare Projects" />
</h2>
</form>
</div>
</div>
</body>
</html>