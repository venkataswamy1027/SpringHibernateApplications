<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>All Students</title>
</head>
<body bgcolor="palegreen">
<h1><b style="color:blue;">List Of Students</b></h1>
<c:if test="${!empty students}">
	<table border="3" bordercolor="#c86260" bgcolor="#ffffcc" cellpadding="3"  width="70%">
		<tr>
			<th>Student ID</th>
			<th>Student Name</th>
			<th>Student Marks</th>
			<th>Student Email</th>
			<th>Student Address</th>
		</tr>
		<c:forEach items="${students}" var="student">
			<tr>
				<td><c:out value="${student.id}"/></td>
				<td><c:out value="${student.name}"/></td>
				<td><c:out value="${student.marks}"/></td>
				<td><c:out value="${student.email}"/></td>
				<td><c:out value="${student.address}"/></td>
			</tr>
		</c:forEach>
	</table>
</c:if>
<br>
&nbsp;&nbsp;<a href="index.html"><b style="color:red;">HomePage</b></a>
</body><br>
<br>
</html>