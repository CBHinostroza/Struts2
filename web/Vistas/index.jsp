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
        <s:url action="proveedor" var="urlQRY">
            <s:param name="accion">QRY</s:param>
        </s:url>
            <s:a href="%{urlQRY}"><input type="button" value="Proveedor"></s:a>
        <s:url action="ListarProducto" var="urlQRY">
            <s:param name="accion" >QRY</s:param>
        </s:url>
        <s:a href="%{urlQRY}"><input type="button" value="Producto"></s:a>
    </body>
</html>
