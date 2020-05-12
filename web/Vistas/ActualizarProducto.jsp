<%-- 
    Document   : ActualizarProducto
    Created on : 11/05/2020, 04:30:04 PM
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
        <s:form action="producto">
            <s:hidden name="accion" value="UPD"></s:hidden>
            <s:hidden name="codigo" value="%{producto.codigo}"></s:hidden>
            <s:textfield name="nombre" label="Nombre" value="%{producto.nombre}"></s:textfield>
            <s:select list="listarcategoria" listKey="codigocategoria" listValue="categoria" value="%{producto.idcategoria}" name="codigo_categoria" label="Categoria"></s:select>
            <s:textfield name="idproveedor" label="Proveedor" value="%{producto.idproveedor}"></s:textfield>
            <s:textfield name="stockinicial" label="Stock Inicial" value="%{producto.stockinicial}" ></s:textfield>
            <s:textfield name="stockminimo" label="Stock Minimo" value="%{producto.stockminimo}"></s:textfield>
            <s:textfield name="codigobarra" label="Codigo de Barra" value="%{producto.codigobarra}"></s:textfield>
            <s:textfield name="fechaven" label="Fecha Ven" value="%{producto.fechaven}"></s:textfield>
            <s:textfield name="preciounitario" label="Precio Unitario" value="%{producto.preciounitario}"></s:textfield>
            <s:submit value="Guardar"></s:submit>
        </s:form>
    </body>
</html>
