<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RegisterPage</title>
</head>
<body>
	<H1 style="color: red;text-align: center;">WELCOME TO ORDER METHOD REGISTER PAGE</H1>
	<form:form action="save" method="POST" modelAttribute="orderMethod">
		<pre>
				ORDER MODE::
						<form:radiobutton path="orderMode" value="Sale"/>Sale
						<form:radiobutton path="orderMode" value="Purchase"/>Purchase
				ORDER CODE::
						<form:input path="orderCode"/>
				ORDER TYPE::
						<form:select path="orderType">
							<form:option value="">--SELECT--</form:option>
							<form:option value="FIFO">FIFO</form:option>
							<form:option value="LIFO">LIFO</form:option>
							<form:option value="FCFO">FCFO</form:option>
							<form:option value="FEFO">FEFO</form:option>
						</form:select>
				ORDER ACCEPT::
						<form:checkbox path="orderAcpt" value="Multi-Model"/>Multi-Model
						<form:checkbox path="orderAcpt" value="Accept-Return"/>Accept-Return
				DESCRIPTION::
						<form:textarea path="desc"/>
				<input type="submit" value="CREATE">
        </pre>
	</form:form>
	${message}
</body>
</html>