<%-- 
    Document   : ActualizarProducto
    Created on : 11/05/2020, 01:24:07 PM
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
         <h1>Editar Producto</h1>
        <s:form action="proveedor">
            <s:hidden name="accion" value="UPD"></s:hidden>
            <s:hidden name="codigo" value="%{proveedor.codigo}"></s:hidden>
            <s:textfield name="nombre" label="Nombre" value="%{proveedor.nombre}"></s:textfield>
            <s:textfield name="direccion" label="Direccion" value="%{proveedor.direccion}"></s:textfield>
            <s:select list="ListarTerritorio"  listKey="codigoterritorio" listValue="distrito" value="%{proveedor.codigo_territorio}" name="codigo_territorio" label="Distrito"></s:select>
            <s:textfield name="telefono" label="Telefono" value="%{proveedor.telefono}"></s:textfield>
            <s:textfield name="email" label="Email" value="%{proveedor.email}"></s:textfield>
            <s:submit value="Guardar"></s:submit>
        </s:form>
    </body>
</html>
