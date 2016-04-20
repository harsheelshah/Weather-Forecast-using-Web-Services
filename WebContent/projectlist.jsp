<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Web Services - WSDL</title>
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
		
      
      
      <form action="Graph" class="navbar-form navbar-left" method="get">
			<input type="submit" name="showgraph" class=" btn btn-info" value="Graphical representation" />
 			</form>
 			<form action="Comparator" class="navbar-form navbar-left" method="get">
			<input type="submit" name="showgraph" class=" btn btn-info" value="Graphical Comparision" />
		
 			</form>

    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav> 


<body>

<form action="MyWSDLList"  method="post" >
<div class="container">
<div class="well">
<table class="table">
<tr class="danger">
<th>
ID
</th>


<th>
WSDL Name
</th>

<th>
Response Time
</th>

<th>
Opration
</th>
</tr>
<c:forEach items="${project}" var="output">
<tr class="info">
<td>
			${output.id}</td>
<td>			${output.name}</td>
<td>			${output.time}</td>
<td>			
<a href="Delete?id=${output.id}" >Delete</a></td></tr>
<%-- <input type="submit" value="Delete" >
				<input type="hidden" name="delete" value="${output.id}"></td></tr> --%>
			</c:forEach>
			</table>
			</div>
			</div>
			</form>
</body>
</html>