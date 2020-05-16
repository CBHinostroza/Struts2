<%-- 
    Document   : RegistrarProducto
    Created on : 04/05/2020, 03:29:32 PM
    Author     : bryan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="js" uri="/struts-jquery-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <js:head></js:head>
    </head>
    <body>
        <h1>Registrar Producto</h1>
        <s:url action="BuscarProveedor" var="urlQRY">
            <s:param name="accion">QRY</s:param>
        </s:url>
        <s:a href="%{urlQRY}"><input type="button" value="Agregar proveedor"></s:a>
       
        <s:form action="RegistrarProducto" theme="">
            <s:hidden name="accion" value="INS"></s:hidden>
            <s:textfield name="nombre" label="Nombre" ></s:textfield>
            <s:url action="ListarCategoria" var="urlCboCategoria"></s:url>
            <js:select href="%{urlCboCategoria}" headerKey="0" headerValue="Seleccionar" list="listarcategoria" 
                      listKey="codigocategoria" listValue="categoria" name="codigo_categoria" label="Categoria"  ></js:select>
            <s:textfield name="idproveedor" label="Proveedor" value="%{idproveedor}"></s:textfield>
            <s:textfield name="stockinicial" label="Stock Inicial"></s:textfield>
            <s:textfield name="stockminimo" label="Stock Minimo"></s:textfield>
            <s:textfield name="codigobarra" label="Codigo de Barra" ></s:textfield>
            <s:textfield name="fechaven" type="date" label="Fecha Ven"></s:textfield>
            <s:textfield name="preciounitario" label="Precio Unitario"></s:textfield>
            <s:submit value="Guardar"></s:submit>
        </s:form>
    
    </body>
</html>
