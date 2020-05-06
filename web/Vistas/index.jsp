<%-- 
    Document   : index
    Created on : 02/05/2020, 12:48:36 PM
    Author     : bryan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Menu navegacion</h1>
        <s:a action="listar"><input type="button" value="Proveedores"></s:a>
        <s:a action="listarproducto"><input type="button" value="Productos"></s:a>
    </body>
</html>
