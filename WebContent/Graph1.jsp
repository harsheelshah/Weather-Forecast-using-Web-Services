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
  <head>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">


 
  
 <%-- ${project.time} --%>
  <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
  <script type="text/javascript">
  
      google.charts.load('current', {'packages':['corechart']});
    
      
    	 google.charts.setOnLoadCallback(drawChart);
     
    	     function drawChart() {
    	    	 var i=1;     	
        var data = google.visualization.arrayToDataTable([
	['Time in MS','Response Time'],
		<c:set var="count" value="1" scope="page" />                                                 
		<c:forEach items="${project}" var="output"  > 
		 [${count},${output.time}],


          <c:set var="count" value="${count + 1}" scope="page"/>
          </c:forEach> 
        ]); 
        var options = {
          title: 'Web Service Performance',
           /* bars: 'vertical',  */
          curveType: 'function',
          legend: { position: 'bottom' },
          hAxis: {
              minValue: 0,
              ticks: [0,1,2,3,4,5,6,7,8,9,10]
            }
        };

       // var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));
		 var chart = new google.visualization.ColumnChart(document.getElementById('curve_chart'));
        chart.draw(data, options);
        
      }
      
      
    </script>
    
   
  </head>
  <body>
 
  <div class="container">
  <br>
  <h2><font color="white"> <center><b>Comparison of Different Services by Response Time (in ms)</b></center>
  </font></h2><br><br>  
  <div class="well">
  
    <div id="curve_chart" style="width: 900px; height: 500px"></div>
    </div>
    </div>
  </body>
</html>