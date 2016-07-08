<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body bgcolor="palegreen">
<h3><b>Your login success ${loginForm.userName}</b></h3>
<table>
	<tr>
		<td><a href="loginform.html"><b style="color:blue;">LoginPage</a></td>
	</tr>
</table>
<a href=ipl.html><b style="color:blue;">Click TO View List of IPL Teams</b></a><br>
<a href="search.html?search_field=&search_item="><b style="color:blue;">Click Here To Search Information</b></a><br>
<a href="sort.html?sort_field=&sort_order="><b style="color:blue;">Click Here To Sort Player Information In Ascending Or Descending Order</b></a><br>
<a href="/IplProjectSearchingAndAscOrDescOrder"><b style="color:blue;">Homepage</b></a><br>
</body>
</html>