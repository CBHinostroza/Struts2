<%-- 
    Document   : ListarProveedor
    Created on : 02/05/2020, 03:00:12 PM
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
            <h1>Hello World!</h1>
            <table>
                <thead>
                    <tr>
                        <td>Codigo</td>
                        <td>Nombre</td>
                        <td>Direccion</td>
                        <td>Distrito</td>
                        <td>Telefono</td>
                        <td>Email</td>
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
                        <td><s:property value=""></s:property></td>
                        <td><s:property value="email"></s:property></td>
                        </tr>
                </s:iterator>
            </tbody>
            <tfoot>
                <td>
                    <s:url action="mostrarDistritos" var="irRegistro"></s:url>
                    <s:a href="%{irRegistro}"><input type="button" value="Agregar"></s:a>
                </td>
            </tfoot>
        </table>
    </body>
</html>
