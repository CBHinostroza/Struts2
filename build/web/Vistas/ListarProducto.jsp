<%-- 
    Document   : ListarProducto
    Created on : 04/05/2020, 04:02:58 PM
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
        <s:a href="inicio">Regresar</s:a>
            <hr>
            <h1>Listado de Productos!</h1>
            <table>
                <thead>
                    <tr>
                        <td>Nombre</td>
                        <td>Categoria</td>
                        <td>Proveedor</td>
                        <td>Stock Inicial</td>
                        <td>Stock Minimo</td>
                        <td>Codigo de Barra</td>
                        <td>Fecha Ven</td>
                        <td>Precio Unitario</td>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><s:property value="producto.nombre"></s:property></td>
                    <td><s:property value="producto.idcategoria"></s:property></td>
                    <td><s:property value="producto.idproveedor"></s:property></td>
                    <td><s:property value="producto.stockinicial"></s:property></td>
                    <td><s:property value="producto.stockminimo"></s:property></td>
                    <td><s:property value="producto.codigobarra"></s:property></td>
                    <td><s:property value="producto.fechaven"></s:property></td>
                    <td><s:property value="producto.preciounitario"></s:property></td>
                    </tr>
                </tbody>
                <tfoot>
                    <tr>
                        <td>
                        <s:a href="RegistrarProducto.jsp"><input type="button" value="Agregar"></s:a>
                        </td>
                    </tr>
                </tfoot>
            </table>
            <hr>
            <br>
            <p>Ejemplo arreglo</p>
            <p>El arreglo tiene <s:property value="cantidad"></s:property> registros</p>
            <ul>
            <s:iterator value="lista" var="valor" status="estado">
                <li>
                    <s:property value="#estado.index"></s:property>
                    <s:property value="nombre"></s:property>
                    <s:property value="codigobarra"></s:property>
                    </li>
            </s:iterator>
        </ul>
        <hr>
        <br>
        <p>Ejemplo lista desplegable donde listKey sera su valor y listValue el dato a mostrar</p>
        <s:form action="MostrarCodigoList">
            <s:select list="lista" headerKey = "- 1" headerValue = "Seleccionar" listKey="codigobarra" listValue="nombre" name="codigo"></s:select>
            <s:submit value="Enviar"></s:submit>
        </s:form>
    </body>
</html>
