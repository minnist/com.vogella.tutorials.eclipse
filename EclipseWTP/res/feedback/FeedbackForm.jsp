
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Rate this article</title>
</head>
<body>

<b>Feedback Form</b>

<FORM action="Rate" method="get">Please provide feedback for this
webpage <%
	String requestURL = request.getRequestURL().toString();
	String remoteAddr = request.getRemoteAddr();

	String feedback = "";
	if (request.getAttribute("feedback") != null) {
		feedback = request.getAttribute("feedback").toString();
	}
%>

<p><input type="hidden" value=<%= requestURL %> name="article"></p>

<table>
<tr>
      <td align="right">User:</td>
      <td><input name="user" type="text" size="30" maxlength="30"></td>
    </tr>
    <tr>
      <td align="right">Email:</td>
      <td><input name="email" type="text" size="30" maxlength="40"></td>
    </tr>
    <tr>
      <td align="right" valign="top">Comment:</td>
      <td><textarea name="Text" rows="10" cols="50"></textarea></td>
    </tr>
</table>

<input type="submit" value="Submit"></FORM>
<%
	String errorMessage = "";
	Object error = request.getAttribute("error");
	if (error != null)
		errorMessage = error.toString();
%>
<div id="error"><%=errorMessage%></div>
</body>
</html>
