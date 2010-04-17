
<%@page contentType="text/html" pageEncoding="UTF-8" session="true"  %>

<%-- 
    Document   : index
    Created on : 23/01/2010, 09:32:50 AM
    Author     : u814296
--%>

<jsp:useBean id="userSession" class="pe.edu.upc.dew.controlventas.model.Usuario" scope="session" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>Sistema de Control de Ventas</title>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1251">
        <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
        <link rel="stylesheet" href="style/styleSheet.css" />

        <script type="text/javascript">
            function consultar()
            {
                document.forms["frmEstadoCuenta"].submit();
            }


        </script>

    </head>
    <body>


        <!-- Start editing template here -->

        <jsp:include page="include/header.jsp" flush="true" />

        <table width="766" height="410" border="0" cellspacing="0" cellpadding="0" align="center">
            <tr>
                <td width="228" valign="top" align="left">

                    <jsp:include page="include/menuSistema.jsp" flush="true" />
                    <jsp:include page="include/menuCategorias.jsp" flush="true" />

                    <jsp:include page="include/dataUser.jsp" flush="true" />

                </td>
                <td width="538" valign="top" align="left">

                    <br>
                    <strong class="text"><h3>Estado de Cuenta del mes</h3></strong>
                    <form id="frmEstadoCuenta" NAME="frmEstadoCuenta" action="EstadoCuentaServlet" method="post">

                        <table border="0" cellspacing="0" cellpadding="0" width="400" height="25">
                            <tbody>
                                <tr>
                                    <td height="25" valign="bottom" width="367" align="right">
                                        <a onclick="javascript:consultar();" href="#">
                                            <img border="0" src="images/botenviar.gif"
                                                 width="100" height="25"></a>
                                    </td>
                                    <td width="238" align="right">
                                        &nbsp;
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </form>






                </td>
            </tr>
        </table>

        <jsp:include page="include/footer.jsp" flush="true" />

        <!-- End template editing here -->

    </body>
</html>