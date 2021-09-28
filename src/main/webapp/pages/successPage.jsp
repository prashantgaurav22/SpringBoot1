<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success</title>
</head>
<body bgcolor="pink">

<style>td,
th {
    border: 1px solid rgb(190, 190, 190);
    padding: 10px;
}

td {
    text-align: center;
}

tr:nth-child(even) {
    background-color: #eee;
}

th[scope="col"] {
    background-color: #696969;
    color: #fff;
}

th[scope="row"] {
    background-color: #d7d9f2;
}

caption {
    padding: 10px;
    caption-side: bottom;
}

table {
    border-collapse: collapse;
    border: 2px solid rgb(200, 200, 200);
    letter-spacing: 1px;
    font-family: sans-serif;
    font-size: .8rem;
}
</style>

<center><h1>DXC Technology!</h1>
<h2>Thanks For Registering With Us!<a href="/home">GotoHome</a></h2>
<h3>Registration successfully Done!</h3>



	<table>
	 <tr>
		 <tr>
			<th scope="row">Employee Id:</th>
			<td>${emp.employeeId }</td>
			</tr>
			<tr>
			<th scope="row">First Name:</th>
			<td>${emp.firstName }</td>
			</tr>
			<tr>
			<th scope="row">Last Name:</th>
			<td>${emp.lastName }</td>
			</tr>
			<tr>
			<th scope="row">Email:</th>
			<td>${emp.email }</td>
			</tr>
			<tr>
			<th scope="row">Department Id:</th>
			<td>${emp.department.departmentId }</td>
			</tr>
		    <tr>
			<th scope="row">Department Name:</th>
			<td>${emp.department.departmentName }</td>
			</tr>
			
</tr>

		</table>
		</center>
</body>
</html>