<%@page import="java.util.ArrayList"%>
<%@page import="model.Registros"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Base de Datos de Contactos</title>
</head>
<body>
	<form action="Busqueda" method="POST">
		Nombre:<br> 
		<input type="text" name="contactName" placeholder="Username"> 
			<br> Telefono:<br> 
			<input type="text" name="phoneNumber" placeholder="Phone Number"> <br>
		<br> <input type="submit" value="Buscar">
	</form>
	<br>
	<br>
	<br>
	<table>
		<thead>
			<tr>
				<th>Nombre</th>
				<th>Num. Telefono</th>
			</tr>
		</thead>
		<tbody>
			<%
			ArrayList<Registros> list = new ArrayList<>();
				if (request.getAttribute("error") != null) {
					out.print(request.getAttribute("error"));
				} else {
					if(request.getAttribute("registros") != null )
					{
						list = (ArrayList<Registros>) request.getAttribute("registros");
					
					
					for (Registros registro : list) {
			%>
			<tr>
				<td><%=registro.getNombre()%></td>
				<td><%=registro.getTelefono()%></td>
			</tr>
			<%
					}
				}
				}
			%>
		</tbody>
	</table>
</body>
</html>