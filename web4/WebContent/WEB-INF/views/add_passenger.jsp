<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PMW AirLines</title>
</head>
<body>

	<div class="container">
		<div class="title">Add a Passenger</div>
		<%
			if (request.getAttribute("errors") != null) {
		%>
		<fieldset>
			<legend>Errors</legend>
			<ul>
				<%
					if (request.getAttribute("firstname_error") != null) {
				%>
				<li class="error">First name error</li>
				<%
					}
				%>
				<%
					if (request.getAttribute("lastname_error") != null) {
				%>
				<li class="error">Last name error</li>
				<%
					}
				%>
				<%
					if (request.getAttribute("date_format_error") != null) {
				%>
				<li class="error">Date of birth invalid</li>
				<%
					}
				%>
			</ul>
		</fieldset>
		<%
			}
		%>

	</div>
	<fieldset>
		<legend>Passenger Details</legend>
		<form action="AddPassenger" method="post">
			<div class=inputField>
				<label for="first-name" class="inputLable">First Name : </label> <input
					name="firstname" type="text"></input>
			</div>

			<div class=inputField>
				<label for="last-name" class="inputLable">Last Name : </label> <input
					name="lastname" type="text"></input>
			</div>

			<div class=inputField>
				<label for="dob" class="inputLable">Date of Birth : </label> <input
					name="dob" type="text"></input>
			</div>
			<div class=inputField>
				<label for="gender" class="inputLable">Gender : </label> <select
					name="gender">
					<option value="Male">Male</option>
					<option value="Female">Female</option>
				</select>
				<div class="inputField" id="submitField">
					<input id="submitBtn" type="submit" value="Add New Passenger"></input>
				</div>
			</div>
		</form>
	</fieldset>



</body>
</html>