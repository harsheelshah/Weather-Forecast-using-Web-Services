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






<div class="container">
<button type="button" class="btn btn-warning">WSDL Web-service</button>
<br>
<br>
<div class="well">

	<form action="MyWSDLservice" method="post">
		Enter WSDL Url: 
		<br><input type="text" name="wsdlURL" style="width: 700px;"> 
		<br>
		Set WSDL Name: 
		<br><input type="text" name="wsdlName" style="width: 150px;">
		<br><br><input
			type="submit" value="getmethods">
	</form>
</div>

<div class="well">
Methods:

	<form action="MyWSDLmethod" method="post">
		<select name="method">
			<c:forEach items="${methods}" var="method">
				<option value="${method}">${method}</option>
			</c:forEach>
		</select> <input type="submit" name="getParameter" value="getParameter"><br>
	</form>
</div>	

	<br>
	
<div class="well">
	
		<form action="MyWSDLinput" method="post">
	
		<c:forEach items="${inputs}" var="input">
			${input}:<input type="text" name="${input}">
				
			</c:forEach>
			<input type="submit" name="hitService" value="hitService">
			</form>
</div>
			
			<br>
			
			<div class="well">
			<h4><font color="red">Response time : ${diff }ms</font></h4>
			<c:if test="${flag eq false } ">
			<c:forEach items="${output}" var="output">
			${output.name}:${output.value}<br>
				
			</c:forEach> 
			</c:if>
			</div>		
			
			
			<div class="well">
			<table>
			<tr> 
			<td>
			<form action="MyWSDLinput" method="post">
			<input type="submit" name="save" class=" btn btn-success" value="Save Project" />&nbsp;&nbsp;&nbsp;
			</form>
			
			</td>
			<td>
			<form action="Graph" method="get">
			<input type="submit" name="showgraph" class=" btn btn-danger" value="Graphical representation" />&nbsp;&nbsp;&nbsp;
 			</form>  
 			</td>
 			<td>
 			<form action="Comparator" method="get">
			<input type="submit" name="showgraph" class=" btn btn-danger" value="Graphical Comparision" />
		
 			</form>
 			</td>
 			</tr>
			</table>
			
			</div>
			</div>
			
			

</body>
</html>