<html>
<head>

</head>
<body bgcolor="pink">

<center>
<h1>
		<b> <u>DXC Technology</u> </b>

	</h1>

<h3>Search Employee Details</h3>

	<form action="view" method="POST">

<table>

 
<tr>

		<th>Enter DepId: </th>
		</tr>
		<tr>
		<td> <input type="number" value="${dep}"
			name="department" pattern="[1-9][0-9]{5}" required /></td>
			 </tr>
			 
			 <br /> 
			 <br />
</table>
		<button>Search</button>

	</form>
	
	<br />
	<br />

	<h3><a href="/home">GoToHome</a></h3>
	</center>
	
</body>
</html>