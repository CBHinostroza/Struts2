<%-- 
    Document   : index
    Created on : 02/05/2020, 12:48:36 PM
    Author     : bryan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Menu navegacion</h1>
        <h2><s:property value="tipo"></s:property></h2>
        <s:url action="ListarProveedor" var="urlQRYProveedor">
            <s:param name="accion">QRY</s:param>
        </s:url>
        <s:a href="%{urlQRYProveedor}" ><input type="button" value="Proveedores"></s:a>
        <s:url action="ListarProducto" var="urlQRYProducto">
            <s:param name="accion" >QRY</s:param>
        </s:url>
        <s:a href="%{urlQRYProducto}"><input type="button" value="Productos"></s:a>
        <s:url action="ListarUsuario" var="urlQRYUsuario">
            <s:param name="accion">QRY</s:param>
        </s:url>
        <s:a href="%{urlQRYUsuario}"><input type="button" value="Usuarios"></s:a>
        
        <s:url action="logout" var="urlLogout"></s:url>
        <s:a href="%{urlLogout}"><input type="button" value="Cerrar Sesion"></s:a>
    </body>
</html>
