<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ page import="model.Palindromo"%>
</head>
<body>


 <form name="form1" action="LeerPalabra" method="POST">
      Insertar texto: 
      <input type="text" name="palabra" maxlength="10" size="15" />
      <br/>
      <br>
       <input value="Evaluar" type="submit">
</form>
<%
if(request.getAttribute("isPalindromo")!=null)
{
	boolean isPalindromo = (boolean)request.getAttribute("isPalindromo");
	
	if(isPalindromo)
		out.print("Es palindromo");
	else
		out.print("No es Palindromo");	
}

%>
<form action="index.jsp">
<label>Click para Regresar</label>
<input type="submit" value="regresar"></input>
</form>
</body>
</html>