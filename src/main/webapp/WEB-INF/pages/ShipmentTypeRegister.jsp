<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RegisterPage</title>
</head>
<body style="background-color:silver;">
<h1 style="color: white;text-align: center;">Shipment Type Register Page</h1>
<form:form action="save" method="POST" modelAttribute="shipmentType">
<pre>
SHIPMENT MODE::<form:select path="shipMode">
				<form:option value="">--select--</form:option>
				<form:option value="Air">Air</form:option>
				<form:option value="Truck">Truck</form:option>
				<form:option value="Train">Train</form:option>
				</form:select>
SHIPMENT CODE::<form:input  path="shipCode"/>
ENABLE SHIPMENT::<form:select path="enbShip">
					<form:option value="">--Select---</form:option>
					<form:option value="Yes">Yes</form:option>
					<form:option value="No">No</form:option>
				</form:select>
SHIPMENT GRADE::
				<form:radiobutton  path="shipGrad" value="A"/>A
				<form:radiobutton path="shipGrad" value="B"/>B
				<form:radiobutton path="shipGrad" value="C"/>C
DESCRIPTION::
			<form:textarea path="shipDesc"></form:textarea>
<input type="submit" value="Create">
</pre>
</form:form>
${message} 
</body>
</html>