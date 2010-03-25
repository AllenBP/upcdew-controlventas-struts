
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
        <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
        <link rel="stylesheet" href="style/styleSheet.css" />
        <script type='text/javascript' src='http://www.google.com/jsapi'></script>
        <script type='text/javascript'>
          google.load('visualization', '1', {packages:['table']});
          google.setOnLoadCallback(drawTable);
          function drawTable() {
            var data = new google.visualization.DataTable();
            data.addColumn('string', 'Nombre');
            data.addColumn('string', 'Ape. Paterno');
            data.addColumn('string', 'Ape. Materno');
            data.addColumn('string', 'Email');
            data.addColumn('string', 'Fec. Nac.');
            data.addColumn('string', 'Tipo Crédito');
            data.addColumn('number', 'Linea Crédito');

                data.addRows(${countlistaClientes});
                
            <c:forEach items="${listaClientes}" var="cli" varStatus="rowCounter" >

                data.setCell(${rowCounter.count - 1}, 0, '${cli.nombre}');
                data.setCell(${rowCounter.count - 1}, 1, '${cli.apellidoPaterno}');
                data.setCell(${rowCounter.count - 1}, 2, '${cli.apellidoMaterno}');
                data.setCell(${rowCounter.count - 1}, 3, '${cli.email}');
                data.setCell(${rowCounter.count - 1}, 4, '${cli.fechaNacimiento}');
                data.setCell(${rowCounter.count - 1}, 5, '${cli.lineaCredito.nombre}');
                data.setCell(${rowCounter.count - 1}, 6, ${cli.lineaCredito.creditoReal}, 'S/. ${cli.lineaCredito.creditoReal}');

            </c:forEach>

           var table = new google.visualization.Table(document.getElementById('table_div'));
           table.draw(data, {showRowNumber: true});
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
        <strong class="text"><h3>Lista de Clientes</h3></strong>

        <div id='table_div'></div>


        <A class="text" href="client.jsp">Agregar cliente</A>

    </td>
  </tr>
</table>

<jsp:include page="include/footer.jsp" flush="true" />

<!-- End template editing here -->

</body>
</html>