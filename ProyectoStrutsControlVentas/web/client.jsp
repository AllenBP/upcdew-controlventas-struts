
<%@page contentType="text/html" pageEncoding="UTF-8" session="true"  %>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- 
    Document   : index
    Created on : 23/01/2010, 09:32:50 AM
    Author     : u814296
--%>

<jsp:useBean id="userSession" class="pe.edu.upc.dew.controlventas.model.Usuario" scope="session" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html:html lang="true">
    <head>
        <title>Sistema de Control de Ventas</title>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1251">
        <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
        <link rel="stylesheet" href="style/styleSheet.css" />
        <script type="text/javascript">
            function crearCliente()
            {
                var isValid = true;
                var textValid = '';

                if( document.ClientForm.username.value == '' ||
                    document.ClientForm.password.value == '' ||
                    document.ClientForm.txtPasswordVerificar.value == '' ||
                    document.ClientForm.email.value == '' ||
                    document.ClientForm.nombre.value == '' ||
                    document.ClientForm.apellidoPaterno.value == '' ||
                    document.ClientForm.apellidoMaterno.value == '' ||
                    document.ClientForm.nroDocumento.value == '' )
                {
                    isValid = false;
                    textValid += 'Ingrese todos los datos \n';
                }

                if(document.ClientForm.password.value !=
                    document.ClientForm.txtPasswordVerificar.value  )
                {
                    isValid = false;
                    textValid += 'Las contraseñas no son iguales \n';
                }

                if(document.ClientForm.password.value !=
                    document.ClientForm.txtPasswordVerificar.value  )
                {
                    isValid = false;
                    textValid += 'Las contraseñas no son iguales \n';
                }

                if (!(valEmail(document.ClientForm.email.value)))
                {
                    isValid = false;
                    textValid += 'El correo electronico es incorrecto. \n';
                }

                if(isValid){
                   document.forms["ClientForm"].submit();
                }else{
                    alert(textValid);
                }

                
            }

            function valEmail(valor){
                re=/^[_a-z0-9-]+(.[_a-z0-9-]+)*@[a-z0-9-]+(.[a-z0-9-]+)*(.[a-z]{2,3})$/
                if(!re.exec(valor))    {
                    return false;
                }else{
                    return true;
                }
            }

        </script>
        <script type="text/javascript" language="JavaScript">
            function Abrir_ventana (pagina) {
                var opciones="toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=no, resizable=yes, width=508, height=300, top=85, left=140";
                window.open(pagina,"",opciones);
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


        <html:form action="Client.do?metodo=ingresar"  >
        
        <br>
        <table border="0" cellspacing="0" cellpadding="0" width="400" height="473">
            <tbody>
                <tr>
                    <td valign="bottom">
                        <img src="images/estrella.gif" width="12"
                            height="12">
                        <strong><span class="text">Datos de usuario</span></strong>
                    </td>
                </tr>
                <tr>
                    <td height="18" background="images/linpunteada.gif">
                        &nbsp;
                    </td>
                </tr>
                <tr>
                    <td height="36">
                        <table border="0" cellspacing="0" cellpadding="0" width="400" height="44">
                            <tbody>
                                <tr>
                                    <td width="24">
                                        <img src="images/reg-icono2.gif" width="19"
                                            height="17">
                                    </td>
                                    <td width="107" class="text">
                                        Usuario
                                        <br>
                                        <label id="lblErrorusername" class="error">
                                        </label>
                                    </td>
                                    <td width="11">
                                        :
                                    </td>
                                    <td width="151" class="text">
                                        <html:text name="ClientForm" property="username"  maxlength="20" />
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="4">
                                    </td>
                                    <td>
                                    </td>
                                    <td colspan="3" class="text">
                                        <label id="lblErrorusernameVerificar" class="error">
                                        </label>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <img src="images/reg-icono2.gif" width="19"
                                            height="17">
                                    </td>
                                    <td class="text">
                                        Contrase&ntilde;a
                                    </td>
                                    <td>
                                        :
                                    </td>
                                    <td>
                                        <html:password name="ClientForm" property="password" maxlength="19" />
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <img src="images/reg-icono2.gif" width="19"
                                            height="17">
                                    </td>
                                    <td class="text">
                                        Verificar contrase&ntilde;a
                                    </td>
                                    <td class="text">
                                        :
                                    </td>
                                    <td>
                                        <input value="" maxlength="19" type="password" name="txtPasswordVerificar" id="txtPasswordVerificar">
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                    </td>
                                    <td colspan="3">
                                        <label id="lblErrortxtPassword" class="error">
                                        </label>
                                    </td>
                                    <td>
                                    </td>
                                    <td colspan="3">
                                        <label id="lblErrortxtPasswordVerificar" class="error">
                                        </label>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <img src="images/reg-icono2.gif" width="19"
                                            height="17">
                                    </td>
                                    <td class="text">
                                        Email
                                    </td>
                                    <td class="text">
                                        :
                                    </td>
                                    <td>
                                        <html:text name="ClientForm" property="email" maxlength="50" />
                                    </td>
                                    <td>
                                    </td>
                                    <td colspan="3">
                                        <label id="lblErroremail" class="error">
                                        </label>
                                    </td>
                                    <td>
                                    </td>
                                    <td>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <img src="images/reg-icono2.gif" width="19"
                                            height="17">
                                    </td>
                                    <td class="text">
                                        Linea de credito
                                    </td>
                                    <td class="text">
                                        :
                                    </td>
                                    <td>
                                        <html:text name="ClientForm" property="lineaCreditoReal" maxlength="50" onkeypress="return isNumeric(event)" />
                                    </td>
                                    <td>
                                    </td>
                                    <td colspan="3">
                                        &nbsp;
                                        <A href="javascript:Abrir_ventana('lineaCredito.jsp');" class="text"> Calcular </A>
                                    </td>
                                    <td>
                                    </td>
                                    <td>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        &nbsp;
                                    </td>
                                    <td class="text" colspan="9">
                                        <textarea id="lblMensajeLineaCredito" class="text" style="width: 300px;">
                                            
                                        </textarea>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td height="31" valign="bottom">
                        <img src="images/estrella.gif" width="12"
                            height="12">
                        <strong><span class="text">Datos personales </span></strong>
                    </td>
                </tr>
                <tr>
                    <td height="18" background="images/linpunteada.gif">
                        &nbsp;
                    </td>
                </tr>
                <tr>
                    <td height="93" valign="top">
                        <table border="0" cellspacing="0" cellpadding="0" width="400" height="93">
                            <tbody>
                                <tr>
                                    <td height="23">
                                        <img src="images/reg-icono2.gif" width="19"
                                            height="17">
                                    </td>
                                    <td width="131" class="text">
                                        Nombres
                                    </td>
                                    <td width="7" class="text">
                                        :
                                    </td>
                                    <td width="148">
                                        <html:text name="ClientForm" property="nombre" maxlength="60" />
                                    </td>
                                </tr>
                                <tr>
                                    <td width="25" align="">
                                        <img src="images/reg-icono2.gif" width="19"
                                            height="17">
                                    </td>
                                    <td width="145" class="text">
                                        Apellido Paterno
                                    </td>
                                    <td width="8" class="text">
                                        :
                                    </td>
                                    <td width="148">
                                        <html:text name="ClientForm" property="apellidoPaterno" maxlength="40" />
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                    </td>
                                    <td colspan="3">
                                        <label id="lblErrornombres" class="error">
                                        </label>
                                    </td>
                                    <td>
                                    </td>
                                    <td colspan="3">
                                        <label id="lblErrorapellidoPaterno" class="error">
                                        </label>
                                    </td>
                                </tr>
                                <tr>
                                    <td height="23">
                                        <img src="images/reg-icono2.gif" width="19"
                                            height="17">
                                    </td>
                                    <td class="text">
                                        Apellido Materno
                                    </td>
                                    <td class="text">
                                        :
                                    </td>
                                    <td>
                                        <html:text name="ClientForm" property="apellidoMaterno" maxlength="40" />
                                    </td>
                                </tr>
                                <tr>
                                    <td align="">
                                        <img src="images/reg-icono2.gif" width="19"
                                            height="17">
                                    </td>
                                    <td class="text">
                                        Fecha de nacimiento
                                    </td>
                                    <td class="text">
                                        :
                                    </td>
                                    <td>
                                        <html:select onchange="eventoCambioCombosFechaFecha('ClientForm','dia')"
                                                     name="ClientForm" property="dia" styleClass="text">
                                            <html:option value="1" ></html:option>
                                            <html:option value="2">2</html:option>
                                            <html:option value="3">3</html:option>
                                            <html:option value="4">4</html:option>
                                            <html:option value="5">5</html:option>
                                            <html:option value="6">6</html:option>
                                            <html:option value="7">7</html:option>
                                            <html:option value="8">8</html:option>
                                            <html:option value="9">9</html:option>
                                            <html:option value="10">10</html:option>
                                            <html:option value="11">11</html:option>
                                            <html:option value="12">12</html:option>
                                            <html:option value="13">13</html:option>
                                            <html:option value="14">14</html:option>
                                            <html:option value="15">15</html:option>
                                            <html:option value="16">16</html:option>
                                            <html:option value="17">17</html:option>
                                            <html:option value="18">18</html:option>
                                            <html:option value="19">19</html:option>
                                            <html:option value="20">20</html:option>
                                            <html:option value="21">21</html:option>
                                            <html:option value="22">22</html:option>
                                            <html:option value="23">23</html:option>
                                            <html:option value="24">24</html:option>
                                            <html:option value="25">25</html:option>
                                            <html:option value="26">26</html:option>
                                            <html:option value="27">27</html:option>
                                            <html:option value="28">28</html:option>
                                            <html:option value="29">29</html:option>
                                            <html:option value="30">30</html:option>
                                            <html:option value="31">31</html:option>
                                        </html:select>
                                        <html:select onchange="eventoCambioCombosFecha('ClientForm','mes')"
                                                     name="ClientForm" property="mes" styleClass="text">
                                            <html:option value="0">Enero</html:option>
                                            <html:option value="1">Febrero</html:option>
                                            <html:option value="2">Marzo</html:option>
                                            <html:option value="3">Abril</html:option>
                                            <html:option value="4">Mayo</html:option>
                                            <html:option value="5">Junio</html:option>
                                            <html:option value="6">Julio</html:option>
                                            <html:option value="7">Agosto</html:option>
                                            <html:option value="8">Septiembre</html:option>
                                            <html:option value="9">Octubre</html:option>
                                            <html:option value="10">Noviembre</html:option>
                                            <html:option value="11">Diciembre</html:option>
                                        </html:select>
                                        <html:select onchange="eventoCambioCombosFecha('ClientForm','anio')"
                                                     name="ClientForm" property="anio" styleClass="text">
                                            <html:option value="2003">2003</html:option>
                                            <html:option value="2002">2002</html:option>
                                            <html:option value="2001">2001</html:option>
                                            <html:option value="2000">2000</html:option>
                                            <html:option value="1999">1999</html:option>
                                            <html:option value="1998">1998</html:option>
                                            <html:option value="1997">1997</html:option>
                                            <html:option value="1996">1996</html:option>
                                            <html:option value="1995">1995</html:option>
                                            <html:option value="1994">1994</html:option>
                                            <html:option value="1993">1993</html:option>
                                            <html:option value="1992">1992</html:option>
                                            <html:option value="1991">1991</html:option>
                                            <html:option value="1990">1990</html:option>
                                            <html:option value="1989">1989</html:option>
                                            <html:option value="1988">1988</html:option>
                                            <html:option value="1987">1987</html:option>
                                            <html:option value="1986">1986</html:option>
                                            <html:option value="1985">1985</html:option>
                                            <html:option value="1984">1984</html:option>
                                            <html:option value="1983">1983</html:option>
                                            <html:option value="1982">1982</html:option>
                                            <html:option value="1981">1981</html:option>
                                            <html:option value="1980">1980</html:option>
                                            <html:option value="1979">1979</html:option>
                                            <html:option value="1978">1978</html:option>
                                            <html:option value="1977">1977</html:option>
                                            <html:option value="1976">1976</html:option>
                                            <html:option value="1975">1975</html:option>
                                            <html:option value="1974">1974</html:option>
                                            <html:option value="1973">1973</html:option>
                                            <html:option value="1972">1972</html:option>
                                            <html:option value="1971">1971</html:option>
                                            <html:option value="1970">1970</html:option>
                                            <html:option value="1969">1969</html:option>
                                            <html:option value="1968">1968</html:option>
                                            <html:option value="1967">1967</html:option>
                                            <html:option value="1966">1966</html:option>
                                            <html:option value="1965">1965</html:option>
                                            <html:option value="1964">1964</html:option>
                                            <html:option value="1963">1963</html:option>
                                            <html:option value="1962">1962</html:option>
                                            <html:option value="1961">1961</html:option>
                                            <html:option value="1960">1960</html:option>
                                            <html:option value="1959">1959</html:option>
                                            <html:option value="1958">1958</html:option>
                                            <html:option value="1957">1957</html:option>
                                            <html:option value="1956">1956</html:option>
                                            <html:option value="1955">1955</html:option>
                                            <html:option value="1954">1954</html:option>
                                            <html:option value="1953">1953</html:option>
                                            <html:option value="1952">1952</html:option>
                                            <html:option value="1951">1951</html:option>
                                            <html:option value="1950">1950</html:option>
                                            <html:option value="1949">1949</html:option>
                                            <html:option value="1948">1948</html:option>
                                            <html:option value="1947">1947</html:option>
                                            <html:option value="1946">1946</html:option>
                                            <html:option value="1945">1945</html:option>
                                            <html:option value="1944">1944</html:option>
                                            <html:option value="1943">1943</html:option>
                                            <html:option value="1942">1942</html:option>
                                            <html:option value="1941">1941</html:option>
                                            <html:option value="1940">1940</html:option>
                                            <html:option value="1939">1939</html:option>
                                            <html:option value="1938">1938</html:option>
                                            <html:option value="1937">1937</html:option>
                                            <html:option value="1936">1936</html:option>
                                            <html:option value="1935">1935</html:option>
                                            <html:option value="1934">1934</html:option>
                                            <html:option value="1933">1933</html:option>
                                        </html:select>

                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                    </td>
                                    <td colspan="3">
                                        <label id="lblErrorapellidoMaterno" class="error">
                                        </label>
                                    </td>
                                    <td>
                                    </td>
                                    <td colspan="3">
                                    </td>
                                </tr>
                                <tr>
                                    <td height="23">
                                        <img src="images/reg-icono2.gif" width="19"
                                            height="17">
                                    </td>
                                    <td class="text">
                                        Tipo de documento
                                    </td>
                                    <td class="text">
                                        :
                                    </td>
                                    <td class="text">
                                        <html:select name="ClientForm" property="tipoDocumento" styleClass="text">
                                            <html:option value="1">D.N.I.</html:option>
                                            <html:option value="2">C.E</html:option>
                                            <html:option value="3">L.E.</html:option>
                                            <html:option value="4">Pasaporte</html:option>
                                        </html:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="">
                                        <img src="images/reg-icono2.gif" width="19"
                                            height="17">
                                    </td>
                                    <td class="text">
                                        N&ordm; de documento
                                    </td>
                                    <td class="text">
                                        :
                                    </td>
                                    <td>
                                        <html:text name="ClientForm" property="nroDocumento" maxlength="20" onkeypress="return isNumeric(event)" />
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                    </td>
                                    <td colspan="3">
                                        <label id="lblErrorcmbDocumentoIdentidad" class="error">
                                        </label>
                                    </td>
                                    <td>
                                    </td>
                                    <td colspan="3">
                                        <label id="lblErrornroDocumento" class="error">
                                        </label>
                                    </td>
                                </tr>
                                <tr>
                                    <td height="24">
                                        <img src="images/reg-icono2.gif" width="19"
                                            height="17">
                                    </td>
                                    <td class="text">
                                        Sexo
                                    </td>
                                    <td class="text">
                                        :
                                    </td>
                                    <td class="text">
                                        <html:radio name="ClientForm" property="sexo" value="M" styleClass="text" />
                                        M&nbsp;&nbsp;&nbsp;
                                        <html:radio name="ClientForm" property="sexo" value="F" styleClass="text" />
                                        F
                                    </td>
                                    <td>
                                        
                                    </td>
                                    <td class="text">
                                        
                                    </td>
                                    <td class="text">
                                        
                                    </td>
                                    <td>

                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                    </td>
                                    <td colspan="5">
                                        <label id="lblErrorradSexo" class="error">
                                        </label>
                                    </td>
                                    <td colspan="2">
                                    </td>
                                </tr>
                                <tr style="display: none">
                                    <td>
                                    </td>
                                    <td>

                                    </td>
                                    <td>
                                        &nbsp;
                                    </td>
                                    <td>
                                        &nbsp;
                                    </td>
                                    <td>
                                        &nbsp;
                                    </td>
                                    <td>
                                        &nbsp;
                                    </td>
                                    <td>
                                        &nbsp;
                                    </td>
                                    <td>
                                        &nbsp;
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </td>
                </tr>

                <tr>
                    <td height="14">
                        <table border="0" cellspacing="0" cellpadding="0" width="400" height="25">
                            <tbody>
                                <tr>
                                    <td height="25" valign="bottom" width="367" align="right">
                                        <a onclick="javascript:crearCliente();" href="#">
                                            <img border="0" src="images/botenviar.gif"
                                                width="100" height="25"></a>
                                    </td>
                                    <td width="238" align="right">
                                        &nbsp;
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </td>
                </tr>
            </tbody>
        </table>


        </html:form>
    </td>
  </tr>
</table>

<jsp:include page="include/footer.jsp" flush="true" />

<!-- End template editing here -->

</body>
</html:html>