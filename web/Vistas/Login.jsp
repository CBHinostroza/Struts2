

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <s:form action="validar" style="margin: auto; width: 400px">
            <s:textfield name="username" label="Usuario"></s:textfield>
            <s:password name="password" label="Contraseña"></s:password>
            <s:submit value="Aceptar"></s:submit>
        </s:form>
    </body>
</html>
