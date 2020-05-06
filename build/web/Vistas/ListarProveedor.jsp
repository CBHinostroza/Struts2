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
                    <td>Nombre</td>
                    <td>Direccion</td>
                    <td>Territorio</td>
                    <td>Telefono</td>
                    <td>Email</td>

                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><s:property value="proveedor.nombre"></s:property></td>
                    <td><s:property value="proveedor.direccion"></s:property></td>
                    <td><s:property value="proveedor.codigo_territorio"></s:property></td>
                    <td><s:property value="proveedor.email"></s:property></td>
                    <td><s:property value="proveedor.telefono"></s:property></td>
                    </tr>
                </tbody>
                <tfoot>
            <s:a href="RegistrarProveedor.jsp"><input type="button" value="Agregar"></s:a>
            </tfoot>
        </table>
    </body>
</html>
