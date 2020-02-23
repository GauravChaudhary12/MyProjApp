<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DataPage</title>
</head>
<body>
<a href="excel">Excel Export</a>
<H1 style="color: red;text-align: center;">WELCOME TO SHIPMENTTYPE DATA PAGE</H1>
<c:choose>
<c:when test="${!empty list }">
<table border="1" style="margin: auto;">
	<tr>
		<th>ID</th>
		<th>MODE</th>
		<th>CODE</th> 
		<th>ENABLE</th> 
		<th>GRADE</th> 
		<th>NOTE</th> 
		<th colspan="3">OPERATION</th> 
	</tr>
	<c:forEach items="${list}" var="ob">
		<tr>
			<td>${ob.shipId}</td>
			<td>${ob.shipMode}</td>
			<td>${ob.shipCode}</td>
			<td>${ob.enbShip}</td>
			<td>${ob.shipGrad}</td>
			<td>${ob.shipDesc}</td>
			<td>
				<a href="delete?id=${ob.shipId}">DELETE</a>
			</td>
			<td>
				<a href="edit?id=${ob.shipId}">EDIT</a>
			</td>
			<td>
				<a href="view?id=${ob.shipId}">VIEW</a>
			</td>
		</tr>
	</c:forEach>
</table>
</c:when>
<c:otherwise>
<h3 style="color: red;">No Data Found</h3>
</c:otherwise>
</c:choose>
${message}
</body>
</html>