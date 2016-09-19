
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Rate this article</title>
</head>
<body>

<b>Rate this page</b>

<FORM action="Rate" method="get">Please rate this article. <%
	String requestURL = request.getRequestURL().toString();
		String remoteAddr = request.getRemoteAddr();

		String feedback = "";
		if (request.getAttribute("feedback") != null) {
			feedback = request.getAttribute("feedback").toString();
		}
%>

<p><input type="hidden" value=<%= requestURL %> name="article"></p>
<p><input type="hidden" value=<%= remoteAddr %> name="remoteAddr"></p>
<table>
	<tr>
		<td width="60"><input type="radio" name="rating" value="1" /> 1</td>
		<td width="60"><input type="radio" name="rating" value="2" /> 2</td>
		<td width="60"><input type="radio" name="rating" value="3" /> 3</td>
		<td width="60"><input type="radio" name="rating" value="4" /> 4</td>
		<td width="60"><input type="radio" name="rating" value="5" /> 5</td>
	</tr>
	<tr>
		<td width="60">Worst Ever</td>
		<td width="60">Not good</td>
		<td width="60">Ok</td>
		<td width="60">Good</td>
		<td>Excellent</td>
	</tr>
</table>
<p>Additional Feedback:<br>
<textarea name="feedback" rows="5" cols="50"><%=feedback%></textarea></p>

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