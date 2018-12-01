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


 <form name="form1" action="/LeerPalabra" method="POST">
      Insertar texto: 
      <input type="text" name="palabra" maxlength="10" size="15" />
      <br/>
      <br>
       <input value="Evaluar" type="submit">

</form>
<%
String resultadoPalabra = "";
/* int evaluador = Palindromo.evaluar(wording); */
%>
</body>
</html>