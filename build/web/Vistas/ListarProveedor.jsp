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
        <h1>Hello World!</h1>
        <table>
            <thead>
                <tr>
                    <td>Codigo</td>
                    <td>Nombre</td>
                    <td>Direccion</td>
                    <td>Territorio</td>
                    <td>Telefono</td>
                    <td>Email</td>
                    <td colspan="2">Accion</td>
                </tr>
            </thead>
            <tbody>
                <s:property value="mensaje"></s:property>
            </tbody>
            <tfoot>
            <a href="RegistrarProveedor.jsp"><input type="submit" value="Agregar"></a>
            </tfoot>
        </table>
    </body>
</html>
