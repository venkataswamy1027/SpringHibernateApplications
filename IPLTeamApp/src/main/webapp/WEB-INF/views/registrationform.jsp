<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<center>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body bgcolor="beige">
<h1 style="color:blue;"><b>User Registration Form</b></h1>
<form:form method="post" action="registrationform.html"  modelAttribute="registration"
	commandName="registration">
	<table>
		<tr>
			<td>User Name:<FONT color="red"><form:errors
				path="userName" /></FONT></td>
		</tr>
		<tr>
			<td><form:input path="userName" /></td>
		</tr>

		<tr>
			<td>Password:<FONT color="red"><form:errors
				path="password" /></FONT></td>
		</tr>
		<tr>
			<td><form:password path="password" /></td>
		</tr>

		<tr>
			<td>Confirm Password:<FONT color="red"><form:errors
				path="confirmPassword" /></FONT></td>
		</tr>
		<tr>
			<td><form:password path="confirmPassword" /></td>
		</tr>

		<tr>
			<td>Email:<FONT color="red"><form:errors path="email" /></FONT></td>
		</tr>
		<tr>
			<td><form:input path="email" /></td>
		</tr>
		<tr>
			<td>Mobile No:<FONT color="red"><form:errors path="mobile" /></FONT></td>
		</tr>
		<tr>
			<td><form:input path="mobile" /></td>
		</tr>
		<tr>
			<td><input type="submit" value="Submit" /></td>
		</tr>
	</table>
</form:form>
</body>
</center>
</html>