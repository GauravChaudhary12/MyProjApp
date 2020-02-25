<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Uom Register</title>
</head>
<body>
<h1 style="color:red;text-align: center; ">Uom Register Page</h1>
<form:form action="save" method="POST" modelAttribute="uom">
<pre>
  UOM TYPE::<form:select path="uomType">
  				<form:option value="">--select--</form:option>
  				<form:option value="Packing">Packing</form:option>
  				<form:option value="NoPacking">NoPacking</form:option>
  				<form:option value="NA">-NA-</form:option>
            </form:select>
  UOM MODEL::<form:input path="uomModel"/>
  DESCRIPTION::<form:textarea path="uomDesc"/>
<input type="submit" value="CREATE UOM"/>
</pre>
</form:form>
${message}
</body>
</html>