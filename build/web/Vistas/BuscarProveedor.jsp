<%-- 
    Document   : ObtenerProveedor
    Created on : 09/05/2020, 08:02:40 PM
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
        <h1>Seleccionar Proveedor</h1>
        <table>
            <thead>
                <tr>
                    <td>Codigo</td>
                    <td>Nombre</td>
                    <td>Direccion</td>
                    <td>Distrito</td>
                    <td>Telefono</td>
                    <td>Email</td>
                    <td>Accion</td>
                </tr>
            </thead>
            <tbody>
                <s:iterator value="lista" status="estado">
                    <tr>
                        <td><s:property value="codigo"></s:property></td>
                        <td><s:property value="nombre"></s:property></td>
                        <td><s:property value="direccion"></s:property></td>
                        <td><s:property value="distrito"></s:property></td>
                        <td><s:property value="telefono"></s:property></td>
                        <td><s:property value="email"></s:property></td>
                            <td>
                            <s:url action="MostrarCodigoProveedor" var="urlINS">
                                <s:param name="idproveedor"><s:property value="codigo"/></s:param>
                            </s:url>
                            <s:a href="%{urlINS}"><input type="button" value="Agregar"></s:a>
                            </td>
                        </tr>
                </s:iterator>
            </tbody>
        </table>
    </body>
</html>
