<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
</head>
<body>
	<h4>JSP1</h4>
	<form:form action="/micoach/redireccionar" method="POST" modelAttribute="person" >
		<table>
			<tr>
				<td>
					<form:label path="name" >Nombre</form:label>
				</td>
			
				<td>
					<form:input id="idNombre" name="name" path="name" type="text"/>
				</td>
			</tr>
			<tr>
				<td><input id="btnAceptar"  value="send" type="submit"></td>
			</tr>
		</table>
	</form:form>
	
	<div id="jspVista">
	</div>
</body>


 <script type="text/javascript">
 
	$('#btnAceptar').click(function(){
		//window.location.href = "http://localhost:8080/micoach/redireccionar"
	
		$.ajax({
			  type: "GET",
			  url: "http://localhost:8080/micoach/redireccionar",
			  data: $('#btnAceptar').val(),
			  //success: success,
			  dataType: 'html',
			  success: function(data){
					    $("#jspVista").html(data);
			  }
			});
	});
	
 </script>
</html>