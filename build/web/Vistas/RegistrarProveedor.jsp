<%-- 
    Document   : RegistrarProveedor
    Created on : 02/05/2020, 03:09:58 PM
    Author     : bryan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <s:fielderror/>
        <h1>Registro Proveedor</h1>
        <s:form action="proveedor">
            <s:hidden name="accion" value="INS"></s:hidden>
            <s:textfield name="nombre" label="Nombre"></s:textfield>
            <s:textfield name="direccion" label="Direccion"></s:textfield>
            <s:select list="ListarTerritorio" listKey="codigoterritorio" listValue="distrito" name="codigo_territorio" label="Distrito"></s:select>
            <s:textfield name="email" label="Email"></s:textfield>
            <s:textfield name="telefono" label="Telefono"></s:textfield>
            <s:submit value="Enviar"></s:submit>
        </s:form>
    </body>
</html>
