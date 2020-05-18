<%-- 
    Document   : ListarUsuarios
    Created on : 17/05/2020, 08:08:15 PM
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
    </head>
    <body>
        <table style="margin: auto; width: 500px">
            <thead>
                <tr>
                    <td>Codigo</td>
                    <td>Usuario</td>
                    <td>Correo</td>
                    <td>Fecha Registro</td>
                    <td>Tipo</td>
                    <td>Accion</td>
                </tr>
            </thead>
            <tbody>
                <s:iterator value="listausuario" status="p">
                    <tr>
                        <td><s:property value="codigo"></s:property></td>
                        <td><s:property value="nombre"></s:property></td>
                        <td><s:property value="correo"></s:property></td>
                        <td><s:property value="utlima_sesion"></s:property></td>
                        <td><s:property value="tipo"></s:property></td>
                        </tr>
                </s:iterator>
            </tbody>
            <tfoot>
                <tr>
                    <td><s:url action="agregarusuario" var="urlINS">
                        </s:url>
                        <s:a href="%{urlINS}"><input type="button" value="Agregar"></s:a></td>
                </tr>
            </tfoot>
        </table>
    </body>
</html>