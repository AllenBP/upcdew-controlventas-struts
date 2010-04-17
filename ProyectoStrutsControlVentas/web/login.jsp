<%-- 
    Document   : index
    Created on : 23/01/2010, 09:32:50 AM
    Author     : u814296
--%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>


<%@page contentType="text/html" pageEncoding="UTF-8" session="true" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html:html lang="true">
    <head>
        <title>Sistema de Control de Ventas</title>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1251">
        <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
        <link rel="stylesheet" href="style/styleSheet.css" />
        <script type="text/javascript">
            function submitform()
            {
                document.forms["LoginForm"].submit();
            }
        </script>
        <html:base/>
    </head>
<body>

<!-- Start editing template here -->

<jsp:include page="include/header.jsp" flush="true" />

<table width="766" height="410" border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td width="228" valign="top" align="left">

        <jsp:include page="include/menuCategorias.jsp" flush="true" />

            <html:form action="Login.do"  >
                
            <table width="208" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td><a href="home.jsp"><img src="images/sign-up-header.jpg" border="0" alt="header"></a>
                    <table width="210" height="65" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td style="border-bottom:1px solid #A3A3A3; border-right:1px solid #A3A3A3" align="center" colspan="2">
                            <strong class="text">Necesita acceder para comprar.</strong><br><br>
                            <table width="210" height="65" border="0" cellspacing="0" cellpadding="0">
                              <tr>
                                  <td align="left"><strong class="text">Usuario: </strong> </td>
                                  <td align="left"><strong class="text">
                                          <html:text name="LoginForm" property="userName" styleClass="text" />
                                          <!--input type="text" name="username" class="text" /--></strong></td>
                              </tr>
                              <tr>
                                <td><strong class="text">Contraseña: </strong></td>
                                <td><html:password name="LoginForm" property="password" styleClass="text" />
                                    <!--input type="password" name="password" class="text" /--></td>
                              </tr>
                              <tr>
                                  <td colspan="2">
                                    <a href="home.jsp"><img src="images/spacer.gif" width="100%" height="7" border="0" alt="space"></a>
                                    <a href="javascript:submitform();"><img src="images/but-signup.jpg" border="0" alt="SignUp"></a>
                                    <!--html:submit value="Login" /-->
                                    </td>
                              </tr>
                              <tr>
                                  <td colspan="2">
                                      <div style="color:red">
                                        <html:errors />
                                    </div>
                                  </td>
                              </tr>
                            </table>
                        </td>
                      </tr>
                    </table>
                    <a href="home.jsp"><img src="images/spacer.gif" width="100%" height="9" border="0"></a>
                    </td>
              </tr>
            </table>

        </html:form>

    </td>
    <td width="538" valign="top" align="left">
        <jsp:include page="include/listaProductos.jsp" flush="true" />
    </td>
  </tr>
</table>

<jsp:include page="include/footer.jsp" flush="true" />

<!-- End template editing here -->

</body>
</html:html>