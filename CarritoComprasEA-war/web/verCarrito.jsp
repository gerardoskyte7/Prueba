<%--
    Document   : verCarrito
    Created on : 01-27-2018, 11:38:41 AM
    Author     : Gerardo
--%>
<%@ page import="modelo.*,java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><title>Lista Carrito</title></head>
<body>
<center>
<h1>Productos</h1>
<%=(String)request.getAttribute("carrito")%>
<br/><br/>
<a href="index.html">Inicio</a>
</center>
</body>
</html>
