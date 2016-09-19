
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<form method="POST"
	action='j_security_check' name="loginForm">
<table>
	<tr>
		<td>Username:</td>
		<td><input type="text" name="j_username"></td>
	</tr>
	<tr>
		<td>Password:</td>
		<td><input type="password" name="j_password"></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="submit" value="Login"> <input
			type="reset" value="Reset"></td>
	</tr>
</table>
</form>
</body>
</html>