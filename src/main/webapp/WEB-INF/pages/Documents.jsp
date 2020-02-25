<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DocumentsUpload</title>
</head>
<body>
<H1 style="color: red;text-align: center;">WELCOME TO DOCUMENTS PAGE</H1>
<form action="upload" method="POST" enctype="multipart/form-data">
<pre>
	ID::<input type="text" name="fileId"/>
	DOC::<input type="file" name="fileOb"/>
	<input type="submit" value="upload"/>
</pre>
</form>
${message }
</body>
</html>