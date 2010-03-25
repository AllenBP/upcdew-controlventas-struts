<%-- 
    Document   : lineaCredito
    Created on : Feb 16, 2010, 12:55:25 PM
    Author     : QTUSR003
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calcular linea de credito</title>
        <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
        <link rel="stylesheet" href="style/styleSheet.css" />

        <script type="text/javascript">
            function aceptarLinea()
            {
                var form = window.opener.document.forms['frmCliente'];

                form.elements['lblMensajeLineaCredito'].value = '${mensajeCredito}';
                
                window.close();
            }

            //Función para validar que solo puedan ingresarse números.
            function isNumeric(e)
            {
                var tecla = (document.all) ? e.keyCode : e.which;
                if (tecla==8) return true;
                if (tecla==0 && !document.all) return true;
                var patron = /[0-9]/;
                var te = String.fromCharCode(tecla);
                return patron.test(te);
            }


        </script>

    </head>
    <body style="padding: 10px;">
        <span class="text">
            <h1 > Responda las preguntar para elegir una línea de credito.</h1>
        </span>


        <form id="frmLineaCredito" NAME="frmLineaCredito" action="LineaCreditoServlet" method="post">
            
            <table width="100%" border="0" cellspacing="0" cellpadding="0" align="center">
              <tr>
                  <td class="text" >Sueldo Neto</td>
                  <td><input name="txtSueldo" id="txtSueldo" onkeypress="return isNumeric(event)" ></td>
              </tr>
              <tr>
                  <td class="text" >Nro Tarjetas de Credito</td>
                  <td><input name="txtNroTarjetas" id="txtNroTarjetas" onkeypress="return isNumeric(event)" ></td>
              </tr>
              <tr>
                  <td class="text" >¿Casa Propia?</td>
                  <td><input id="radCasa" value="S" type="radio" checked name="radCasa" class="text">
                        Si&nbsp;&nbsp;&nbsp;
                        <input id="radCasa" value="N" type="radio" name="radCasa" class="text">
                        No</td>
              </tr>
              <tr>
                  <td class="text" >¿Auto Propio?</td>
                  <td><input id="radAuto" value="S" type="radio" checked name="radAuto" class="text">
                        Si&nbsp;&nbsp;&nbsp;
                        <input id="radAuto" value="N" type="radio" name="radAuto" class="text">
                        No</td>
              </tr>



              <tr>
                  <td class="text" colspan="2" >

                    <c:if test="${mensajeCredito==null}">
                        <input type="submit" value="Calcular" />
                    </c:if>
                    <c:if test="${mensajeCredito!='' && mensajeCredito!=null}">
                        <br>
                        <span class="text">
                            <B> ${mensajeCredito} </B>
                        </span>
                        <br><br>
                        <input type="button" onclick="aceptarLinea()" value="Aceptar" />
                    </c:if>

                  </td>
              </tr>


            </table>

        </form>

    </body>
</html>
