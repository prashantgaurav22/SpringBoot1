<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@page import="java.time.LocalDate"%>
<html>
<head>


</head>
<body bgcolor="LightBlue">

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


table {
    border-collapse: collapse;
    border: 2px solid rgb(200, 200, 200);
    letter-spacing: 1px;
    font-family: sans-serif;
    font-size: .8rem;
}
</style>
        <h2><a href="/home">Home</a></h2>
<center>
        <h1>
			<b><u>Dxc Technology</u></b>
		</h1>
		
	<form:form action="add" method="POST" modelAttribute="Employee">
       
		<table >
		
			<tr>
				<h3>Employee Registration Form</h3>
			</tr>
			
			<tr>
				<th scope="row">Employee Id:</th>
				<td><input type="number" name="employeeId" ></td>
			</tr>

			<tr>
			   <th scope="row">First Name:</th>
				<td><input type="text" name="firstName" ></td>
			</tr>
			
			<tr>
			    <th scope="row">Last Name:</th>
				<td><input type="text" name="lastName" ></td>
			</tr>
			
			<tr>
			    <th scope="row">Email:</th>
				<td><input type="text" name="email" ></td>
			</tr>
			
            <tr>
				<th scope="row">Department Id:</th>
				<td><input type="number" name="department">
					

				</td>
		</table>

     <br />
	<br />
       <button >Register</button>
		
	</form:form>
</center>
	<br />
	<br />
	
</body>
</html>