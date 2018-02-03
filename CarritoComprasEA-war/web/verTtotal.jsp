<%--
    Document   : verCarrito
    Created on : 01-27-2018, 11:38:41 AM
    Author     : Gerardo
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><title>Total Carrito</title></head>
<body>
<center>
<h1>Total Carrito</h1>
<%=(String)request.getAttribute("total")%>
<br/><br/>
<a href="index.html">Inicio</a>
</center>
</body>
</html>
