<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Spring MVC Form Handling</title>
	</head>
	<body bgcolor="palegreen">
	<center>
		<h1><b style="color:blue;">Update Student Data</b></h1>
		<form:form method="POST" action="/sdnext/update.html">
	   		<table>
			    <tr>
			        <td><form:label path="id">Student ID:</form:label></td>
			        <td><form:input path="id" value="${student.id}" readonly="true"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="name">Student Name:</form:label></td>
			        <td><form:input path="name" value="${student.name}"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="marks">Student Marks:</form:label></td>
			        <td><form:input path="marks" value="${student.marks}"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="email">Student Email:</form:label></td>
			        <td><form:input path="email" value="${student.email}"/></td>
			    </tr>
			    
			    <tr>
			        <td><form:label path="address">Student Address:</form:label></td>
                    <td><form:input path="address" value="${student.address}"/></td>
			    </tr>
			    <tr>
			      <td colspan="2"><input type="submit" value="Submit"/></td>
		      </tr>
			</table> 
		</form:form>
		<a href="index.html"><b style="color:red;">HomePage</b></a>
	</center>
	</body>
</html>