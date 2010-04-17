
<%@page contentType="text/html" pageEncoding="UTF-8" session="true" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- 
    Document   : index
    Created on : 23/01/2010, 09:32:50 AM
    Author     : u814296
--%>

<jsp:useBean id="userSession" class="pe.edu.upc.dew.controlventas.model.Usuario" scope="session" />
<jsp:useBean id="listaCarroDeCompras" class="pe.edu.upc.dew.controlventas.model.Pedido" scope="session" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>Sistema de Control de Ventas</title>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1251">
        <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
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

        <br>
        <strong class="text"><h3>Lista de Compras</h3></strong>

         <table border="0" cellspacing="1" cellpadding="2" width="558">
            <tbody>

                <c:forEach items="${listaCarroDeCompras.detallesPedidos}" var="prod">

                    <tr>
                    <!--td width="30" align="middle">
                        <input id="nameChkComplemento_217" onclick="gblPag.clickComplemento(0,false)" value="217"
                            type="checkbox" />
                    </td-->
                    <td width="86" class="text">
                        &nbsp;</td>
                    <td width="290" class="text">
                        ${prod.producto.nombre}
                    </td>
                    <td width="56" align="middle" class="text">
                        S/.${prod.producto.precio}
                    </td>
                    <td width="52" align="middle">
                        &nbsp;</td>
                </tr>

                </c:forEach>

                <tr>
                    <td  width="86" class="text">
                        &nbsp;</td>
                    <td width="290" class="text">
                        <B>TOTAL</B>
                    </td>
                    <td width="56" align="middle" class="text">
                        S/.${listaCarroDeCompras.montoTotal}
                    </td>
                    <td width="52" align="middle">
                        &nbsp;</td>
                </tr>

                <tr>
                    <td colspan="4"> <A href="/ProyectoStrutsControlVentas/Ventas.do" class="texto"> Aprobar compra</A> </td>
                </tr>

            </tbody>
        </table>

    </td>
  </tr>
</table>

<jsp:include page="include/footer.jsp" flush="true" />

<!-- End template editing here -->

</body>
</html>