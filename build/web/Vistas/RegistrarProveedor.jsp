<%-- 
    Document   : RegistrarProveedor
    Created on : 02/05/2020, 03:09:58 PM
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
        <s:fielderror/>
        <h1>Hello World!</h1>
        <s:form action="proveedor">
            <s:textfield name="nombre" label="Nombre:"></s:textfield>
            <s:textfield name="direccion" label="Direccion:"></s:textfield>
            <s:textfield name="codigo_territorio" label="Territorio:"></s:textfield>
            <s:textfield name="email" label="email"></s:textfield>
            <s:textfield name="telefono" label="telefono"></s:textfield>
            <s:submit value="Enviar"></s:submit>
        </s:form>
    </body>
</html>
