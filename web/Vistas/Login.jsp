

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <s:form action="validar" style="margin: auto; width: 400px" theme="simple" method="post">
            <table>
                <tr>
                    <td><s:textfield name="username" placeholder="Nombre"></s:textfield></td> 
                    </tr>
                    <tr>
                        <td><s:password name="password" placeholder="Password"></s:password></td>
                    </tr>
                    <tr>
                        <td>
                        <s:actionerror></s:actionerror></td>
                    </tr>
                    <tr>
                        <td><s:submit style="width:100%" value="Aceptar"></s:submit></td>
                    </tr>
                </table>

        </s:form>
    </body>
</html>
