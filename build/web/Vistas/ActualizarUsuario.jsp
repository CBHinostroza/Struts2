<%-- 
    Document   : ActualizarUsuario
    Created on : 18/05/2020, 12:52:03 PM
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
        <js:head ></js:head>
    </head>
    <body>
         <s:form action="EditarUsuario" theme="simple" style="margin: auto; width: 400px" method="post" >
            <fieldset>
                <legend>Editar Usuario</legend>
                <s:fielderror></s:fielderror>
                <s:hidden name="accion" value="UPD"></s:hidden>
                <s:hidden name="codigo" value="%{usuario.codigo}"></s:hidden>
                    <table>
                        <tr>
                            <td style="text-align: right"><s:label for="txtnombre">Nombre:</s:label></td>
                        <td><s:textfield id="txtnombre" name="username" value="%{usuario.nombre}"></s:textfield></td>
                        </tr>
                        <tr>
                            <td style="text-align: right"><s:label for="txtpassword">Password:</s:label></td>
                        <td><s:password id="txtpassword" name="password" value="%{usuario.contraseña}"></s:password><br></td>
                        </tr>
                        <tr>
                            <td style="text-align: right"><s:label for="txtconfirm">Confirm Password:</s:label></td>
                        <td><s:password id="txtconfirm" name="confirm_password"></s:password><br></td>
                        </tr>
                        <tr>
                            <td style="text-align: right"><s:label for="txtcorreo">Correo:</s:label></td>
                        <td><s:textfield id="txtcorreo" name="correo" value="%{usuario.correo}"></s:textfield></td>
                        </tr>
                        <tr>
                            <td style="text-align: right"><s:label for="cboTipo">Tipo:</s:label></td>
                            <td>
                            <s:url action="ListarTipoUsuario" var="urlcboTipo"></s:url>
                            <js:select href="%{urlcboTipo}" headerKey="0" headerValue="Seleccione" value="%{usuario.cod_tipo}"
                                       list="listatipo" listKey="codigo" listValue="tipo" name="codtipo" id="cbotipo"></js:select></td>
                        </tr>
                        <tr></tr>
                        <tr></tr>
                        <tr>
                            <td></td>
                            <td style="text-align: right">
                                <!--
                            <surl action="reset" var="urlReset"></surl>
                            <sa href="%{urlReset}"><ssubmit value="Limpiar"></ssubmit></sa>-->
                                <!--<input type="button" value="Limpiar" onclick="Limpiar()"></input>-->
                            <s:reset value="Reset"></s:reset>
                            <s:submit value="Guardar"></s:submit></td>
                        </tr>
                    </table>
                </fieldset>
        </s:form>
    </body>
</html>
