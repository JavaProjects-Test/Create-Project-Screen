<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" import="javax.servlet.jsp.PageContext"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.6/jquery.min.js"
	type="text/javascript"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"
	type="text/javascript"></script>
<link
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css"
	rel="Stylesheet" type="text/css" />
<script type="text/javascript">
	$(function() {
		$('#txtDate').datepicker({
			dateFormat : "dd/MM/yy",
			changeMonth : true,
			changeYear : true
		});
	});
</script>
<style type="text/css">
body {
	font-family: Arial;
	font-size: 10pt;
}

#txtDate {
	background-image:
		url(http://i988.photobucket.com/albums/af3/mudassarkhan/calender.png);
	background-repeat: no-repeat;
	padding-left: 25px;
}
</style>







<title>Insert title here</title>
</head>
<body>

	<form action="projectCreated" method="post">
		<c:if test="${not emptymessage}">
			<h4 style="color: red">${messageForProjectName}</h4>
		</c:if>
		Project Name<br> <input type="text" name="projectName" /> 
		
		
		 <br>Deadline
		Date<br> <input type="text" id="txtDate" name="date" />
		<c:if test="${not emptymessage}">
			<h4 style="color: red">${messageForDeadlineDate}</h4>
		</c:if>


		<br>Application form <select
			name="selectionApplicationForm">
			<option value="Select">Select</option>
			<option value="Application form">Default Form</option>
		</select><br> <br> Project tag <select name="selectionProjectTag">
			<option value="Select">Select</option>
			<option value="Test">Test</option>
			<option value="Value">Value</option>
		</select><br> <br> Project Description<br>
		<textarea rows="4" cols="50" name="projectDescription"></textarea>
<br>
		<input type="submit" value="submit" />

	</form>



</body>
</html>