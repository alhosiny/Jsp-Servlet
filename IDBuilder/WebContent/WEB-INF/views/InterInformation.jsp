<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Personal Information</title>
</head>
<body>
	<form action="PersonalInformation" method="post">
		<label for="FirstName"> First name: </label>
		<input name="FirstName" type="text" />

		<label for="LastName"> Last name: </label>
		<input name="LastName" type="text" />

		<label for="dob"> Date of birth: </label>
		<input name="dob" type="text" />

		<label for="gender"> Gender: </label>
		<select name="gender">
			<option value="Male">Male</option>
			<option value="Female">Female</option>
		</select>
		<input value="Get ID" type="submit" />

	</form>
</body>
</html>