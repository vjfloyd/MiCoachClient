<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
</head>
<body>
	<h4>JSP2</h4>
	<form action="">
	 	<label> hola </label>
		<div id="linea">${personx}</div>
		<input id="nameval" name="personx" type="hidden">
		
	</form>
</body>

 <script type="text/javascript">
	        $('#linea').append($('#nameval').val());
 </script>
</html>