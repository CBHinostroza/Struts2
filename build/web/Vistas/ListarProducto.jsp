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
        <script src="../JS/Util.js" type="text/javascript"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <s:a href="inicio">Regresar</s:a>
            <hr>
            <h1>Listado de Productos!</h1>
            <table>
                <thead>
                    <tr>
                        <td>Codigo</td>
                        <td>Nombre</td>
                        <td>Categoria</td>
                        <td>Proveedor</td>
                        <td>Stock</td>
                        <td>Fecha Registro Stock</td>
                        <td>Stock minimo</td>
                        <td>Codigo de barra</td>
                        <td>Fecha vencimiento</td>
                        <td>Precio unitario</td>
                        <td>Accion</td>
                    </tr>
                </thead>
                <tbody>
                <s:iterator value="lista" status="p">
                    <tr>
                        <td><s:property value="codigo"></s:property></td>
                        <td><s:property value="nombre"></s:property></td>
                        <td><s:property value="nombrecategoria"></s:property></td>
                        <td><s:property value="nombreproveedor"></s:property></td>
                        <td><s:property value="stockinicial"></s:property></td>
                        <td><s:property value="fechaRegistro"></s:property></td>
                        <td><s:property value="stockminimo"></s:property></td>
                        <td><s:property value="codigobarra"></s:property></td>
                        <td><s:property value="fechaven"></s:property></td>
                        <td><s:property value="preciounitario"></s:property></td>
                            <td>
                            <s:url action="producto" var="urlUPD">
                                <s:param name="accion">GET</s:param>
                                <s:param name="codigo">
                                    <s:property value="codigo"></s:property>
                                </s:param>
                            </s:url>
                            <s:a href="%{urlUPD}"><input type="button" value="Editar"></s:a>
                            <s:url action="producto" var="urlDEL">
                                <s:param name="accion">DEL</s:param>
                                <s:param name="codigo">
                                    <s:property value="codigo"></s:property>
                                </s:param>
                            </s:url>
                            <s:a href="%{urlDEL}" onclick="return alerta()"><input type="button" value="Eliminar"></s:a>
                            </td>
                        </tr>
                </s:iterator>
            </tbody>
            <tfoot>
                <tr>
                    <td>
                        <s:url action="producto" var="irRegistro">
                            <s:param name="accion">INS</s:param>
                            <s:param name="estado">false</s:param>
                        </s:url>
                        <s:a href="%{irRegistro}"><input type="button" value="Agregar"></s:a>
                    </td>
                </tr>
            </tfoot>
        </table>
        <!--
        <sform action="MostrarCodigoList">
            <sselect list="lista" headerKey = "- 1" headerValue = "Seleccionar" listKey="codigobarra" listValue="nombre" name="codigo"></sselect>
            <scheckboxlist list="lista" listKey="codigobarra" listValue="nombre" name="codigo"></scheckboxlist>
            <sradio list="lista" listKey="codigobarra" listValue="nombre" name="codigo"></sradio>
            <ssubmit value="Enviar"></ssubmit>
        </sform> -->
    </body>
</html>
