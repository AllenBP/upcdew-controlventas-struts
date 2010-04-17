<%-- 
    Document   : footer
    Created on : 13/02/2010, 10:13:53 AM
    Author     : u814296
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>

<%
    if(request.getAttribute("userSession")==null)
    {
        response.sendRedirect("index.jsp");
    }
%>

<form action="LoginServlet" method="post">

    <table width="208" border="0" cellspacing="0" cellpadding="0">
        <tr>
            <td><a href="index.html"><img src="images/sign-up-header.jpg" border="0" alt="header"></a>
                <table width="200" height="65" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td style="border-bottom:1px solid #A3A3A3; border-right:1px solid #A3A3A3" align="center" colspan="2">
                            <strong class="text">Acceso aceptado. <br>
                                    Bienvenido Sr(a) ${userSession.nombreCompleto}
                            </strong>
                            <br>
                            <A href="/ProyectoStrutsControlVentas/Logout.do" class="text">Cerrar</A>
                </td>
            </table>
            <a href="index.html"><img src="images/spacer.gif" width="100%" height="9" border="0"></a>
            </td>
      </tr>
    </table>

</form>
