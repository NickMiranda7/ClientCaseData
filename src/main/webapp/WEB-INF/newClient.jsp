<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Client</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
			rel="stylesheet" 
			integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
			crossorigin="anonymous">
</head>
<body>
<div class="container">
<br>
<div class="float-right">
		<ul class="nav nav-tabs">
		  <li class="nav-item">
		     <a class="nav-link" href="/dashboard">Dashboard</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link active" href="/client/new">New Client</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link" href="/logout">Logout</a>
		  </li>
		</ul>
	    <br>
	    <form action="/search/clients" class="form-inline my-2 my-lg-0">
	      <input class="form-control mr-sm-2" type="text" name="name" placeholder="Search" aria-label="Search">
	      <button class="btn btn-outline-dark my-2 my-sm-0">Search</button>
	    </form> 
	    <br>
</div>

<h1>New Client</h1>
<br>


<br>
<br>
<form:form action="/client/new" method="POST" modelAttribute="client">
<form:input type="hidden" value="${user_id}" path="caseWorker"/>
    <div class="form-group">
    	<p>
          <form:label path="caseNumber">Case Number</form:label>
          <form:errors path="caseNumber"/>
          <form:input type="text" class="form-control" path="caseNumber"/>
       	</p>   
        <p>
          <form:label path="name">Name</form:label>
          <form:errors path="name"/>
          <form:input type="text" class="form-control" path="name"/>
        </p>
        <p>
          <form:label path="expedited">Expedited</form:label>
	      <form:errors path="expedited"/>
	      <form:select type="text" class="form-control" path="expedited">
	        	<option value="Yes">Yes</option>
				<option value="No">No</option>
		   </form:select>
	    </p> 
	    <p>
          <form:label path="socialSecurityIncome">Social Security Income</form:label>
	      <form:errors path="socialSecurityIncome"/>
	      <form:textarea type="number" step= "0.01" class="form-control" path="socialSecurityIncome"></form:textarea>
	    </p> 
	    <p>
          <form:label path="notes">Notes</form:label>
	      <form:errors path="notes"/>
	      <form:textarea type="text" class="form-control" path="notes"></form:textarea>
	    </p> 
	    <p>
          <form:label path="pending">Pending</form:label>
	      <form:errors path="pending"/>
	      <form:textarea type="text" class="form-control" path="pending"></form:textarea>
	    </p> 
          
      </div>
      <button class="btn btn-info">Post Client</button>
</form:form>


</div>
</body>
</html>