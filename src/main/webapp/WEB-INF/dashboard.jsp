<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Clients</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
<div class="container">
<h1>Welcome, ${user.firstName}</h1>

<div class="float-right">
		<ul class="nav nav-tabs">
		  <li class="nav-item">
		     <a class="nav-link active" href="/dashboard">Dashboard</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link" href="/client/new">New Client</a>
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

	<table class="table table-striped">
		<thead class="thead-dark">
			<tr>
				<th>Name</th>
				<th>Case Number</th>
				<th>Expedited</th>
				<th>Pending</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${client}" var="client">
			<tr>	
				<td><a href="/edit/${client.id}"><c:out value="${client.name}"/></a></td>
				<td><c:out value="${client.caseNumber}"/></td>
				<td><c:out value="${client.expedited}"/></td>
				<td><c:out value="${client.pending}"/></td>
					<td><a href="/edit/${client.id}">View</a> | <a href="/client/delete/${client.id }">Delete</a></td>

			</tr>
		</c:forEach>
		</tbody>
	</table>

</div>
</body>
</html>