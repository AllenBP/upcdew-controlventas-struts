
<%@page contentType="text/html" pageEncoding="UTF-8" session="true"  %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
        <link rel="stylesheet" href="style/styleSheet.css" />
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
        <jsp:include page="include/listaProductos.jsp" flush="true" />
    </td>
  </tr>
</table>

<jsp:include page="include/footer.jsp" flush="true" />

<!-- End template editing here -->

</body>
</html>