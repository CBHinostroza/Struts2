<%-- 
    Document   : RegistrarProducto
    Created on : 04/05/2020, 03:29:32 PM
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
        <h1>Hello World!</h1>
        <s:form action="registrar">
            
            <s:textfield name="nombre" label="Nombre"></s:textfield>
            <s:textfield name="idcategoria" label="Categoria"></s:textfield>
            <s:textfield name="idproveedor" label="Proveedor"></s:textfield>
            <s:textfield name="stockinicial" label="Stock Inicial"></s:textfield>
            <s:textfield name="stockminimo" label="Stock Minimo"></s:textfield>
            <s:textfield name="codigobarra" label="Codigo de Barra"></s:textfield>
            <s:textfield name="fechaven" label="Fecha Ven"></s:textfield>
            <s:textfield name="preciounitario" label="Precio Unitario"></s:textfield>
            <s:submit value="Guardar"></s:submit>
        </s:form>
        

    </body>
</html>
