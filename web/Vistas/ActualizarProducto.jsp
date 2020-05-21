<%-- 
    Document   : ActualizarProducto
    Created on : 11/05/2020, 04:30:04 PM
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
            <h1>Editar Producto</h1>
        <s:form action="EditarProducto" method="post">
            <s:hidden name="accion" value="UPD"></s:hidden>
            <s:hidden name="codigo" value="%{producto.codigo}"></s:hidden>
            <s:textfield name="nombre" label="Nombre" value="%{producto.nombre}"></s:textfield>
            <s:url action="ListarCategoria" var="urlCboCategoria"></s:url>
            <js:select href="%{urlCboCategoria}" headerKey="0" headerValue="Seleccionar"
                       list="listarcategoria" listKey="codigocategoria" listValue="categoria" 
                       value="%{producto.idcategoria}" name="codigo_categoria" label="Categoria"
                       ></js:select>
            <s:textfield name="idproveedor" label="Proveedor" value="%{producto.idproveedor}"></s:textfield>
            <s:textfield name="stockinicial" label="Stock Inicial" value="%{producto.stockinicial}" ></s:textfield>
            <s:textfield name="stockminimo" label="Stock Minimo" value="%{producto.stockminimo}"></s:textfield>
            <s:textfield name="codigobarra" label="Codigo de Barra" value="%{producto.codigobarra}"></s:textfield>
            <s:textfield name="fechaven" type="date" label="Fecha Ven" value="%{producto.fechaven2}" 
                         
                         ></s:textfield>
            <s:textfield name="preciounitario" label="Precio Unitario" value="%{producto.preciounitario}"></s:textfield>
            <s:submit value="Guardar"></s:submit>
        </s:form>
    </body>
</html>
