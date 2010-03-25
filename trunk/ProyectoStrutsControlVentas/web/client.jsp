
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
        <script type="text/javascript">
            function crearCliente()
            {
                var isValid = true;
                var textValid = '';

                if( document.getElementById("txtEmail").value == '' ||
                    document.getElementById("txtPassword").value == '' ||
                    document.getElementById("txtPasswordVerificar").value == '' ||
                    document.getElementById("txtEmailNoLogeo").value == '' ||
                    document.getElementById("txtNombres").value == '' ||
                    document.getElementById("txtApellidoPaterno").value == '' ||
                    document.getElementById("txtApellidoMaterno").value == '' ||
                    document.getElementById("txtNumeroDNI").value == '' )
                {
                    isValid = false;
                    textValid += 'Ingrese todos los datos \n';
                }

                if(document.getElementById("txtPassword").value !=
                    document.getElementById("txtPasswordVerificar").value  )
                {
                    isValid = false;
                    textValid += 'Las contraseñas no son iguales \n';
                }

                if(document.getElementById("txtPassword").value !=
                    document.getElementById("txtPasswordVerificar").value  )
                {
                    isValid = false;
                    textValid += 'Las contraseñas no son iguales \n';
                }

                if (!(valEmail(document.getElementById("txtEmailNoLogeo").value)))
                {
                    isValid = false;
                    textValid += 'El correo electronico es incorrecto. \n';
                }

                if(isValid){
                   document.forms["frmCliente"].submit();
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


        <form id="frmCliente" NAME="frmCliente" action="ClientServlet?metodo=ingresar" method="post">

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
                                        <label id="lblErrortxtEmail" class="error">
                                        </label>
                                    </td>
                                    <td width="11">
                                        :
                                    </td>
                                    <td width="151" class="text">
                                        <input maxlength="20" name="txtEmail" id="txtEmail">
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="4">
                                    </td>
                                    <td>
                                    </td>
                                    <td colspan="3" class="text">
                                        <label id="lblErrortxtEmailVerificar" class="error">
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
                                        <input value="" maxlength="19" type="password" name="txtPassword" id="txtPassword">
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
                                        <input maxlength="50" name="txtEmailNoLogeo" id="txtEmailNoLogeo">
                                    </td>
                                    <td>
                                    </td>
                                    <td colspan="3">
                                        <label id="lblErrortxtEmailNoLogeo" class="error">
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
                                        <input maxlength="50" name="txtLineaCredito" id="txtLineaCredito" onkeypress="return isNumeric(event)" >
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
                                        <input maxlength="60" name="txtNombres" id="txtNombres">
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
                                        <input maxlength="40" name="txtApellidoPaterno" id="txtApellidoPaterno">
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                    </td>
                                    <td colspan="3">
                                        <label id="lblErrortxtNombres" class="error">
                                        </label>
                                    </td>
                                    <td>
                                    </td>
                                    <td colspan="3">
                                        <label id="lblErrortxtApellidoPaterno" class="error">
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
                                        <input maxlength="40" name="txtApellidoMaterno" id="txtApellidoMaterno">
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
                                        <select onchange='eventoCambioCombosFechaFecha("frmCliente","cmbFecha1")' name="cmbFecha1Fecha" class="text">
                                            <option selected value="1">1</option>
                                            <option value="2">2</option>
                                            <option value="3">3</option>
                                            <option value="4">4</option>
                                            <option value="5">5</option>
                                            <option value="6">6</option>
                                            <option value="7">7</option>
                                            <option value="8">8</option>
                                            <option value="9">9</option>
                                            <option value="10">10</option>
                                            <option value="11">11</option>
                                            <option value="12">12</option>
                                            <option value="13">13</option>
                                            <option value="14">14</option>
                                            <option value="15">15</option>
                                            <option value="16">16</option>
                                            <option value="17">17</option>
                                            <option value="18">18</option>
                                            <option value="19">19</option>
                                            <option value="20">20</option>
                                            <option value="21">21</option>
                                            <option value="22">22</option>
                                            <option value="23">23</option>
                                            <option value="24">24</option>
                                            <option value="25">25</option>
                                            <option value="26">26</option>
                                            <option value="27">27</option>
                                            <option value="28">28</option>
                                            <option value="29">29</option>
                                            <option value="30">30</option>
                                            <option value="31">31</option>
                                        </select>
                                        <select onchange='eventoCambioCombosFecha("frmCliente","cmbFecha1")' name="cmbFecha1Mes" class="text">
                                            <option selected value="0">Enero</option>
                                            <option value="1">Febrero</option>
                                            <option value="2">Marzo</option>
                                            <option value="3">Abril</option>
                                            <option value="4">Mayo</option>
                                            <option value="5">Junio</option>
                                            <option value="6">Julio</option>
                                            <option value="7">Agosto</option>
                                            <option value="8">Septiembre</option>
                                            <option value="9">Octubre</option>
                                            <option value="10">Noviembre</option>
                                            <option value="11">Diciembre</option>
                                        </select>
                                        <select onchange='eventoCambioCombosFecha("frmCliente","cmbFecha1")' name="cmbFecha1Anio" class="text">
                                            <option value="2003">2003</option>
                                            <option value="2002">2002</option>
                                            <option value="2001">2001</option>
                                            <option value="2000">2000</option>
                                            <option value="1999">1999</option>
                                            <option value="1998">1998</option>
                                            <option value="1997">1997</option>
                                            <option value="1996">1996</option>
                                            <option value="1995">1995</option>
                                            <option value="1994">1994</option>
                                            <option value="1993">1993</option>
                                            <option value="1992">1992</option>
                                            <option value="1991">1991</option>
                                            <option selected value="1990">1990</option>
                                            <option value="1989">1989</option>
                                            <option value="1988">1988</option>
                                            <option value="1987">1987</option>
                                            <option value="1986">1986</option>
                                            <option value="1985">1985</option>
                                            <option value="1984">1984</option>
                                            <option value="1983">1983</option>
                                            <option value="1982">1982</option>
                                            <option value="1981">1981</option>
                                            <option value="1980">1980</option>
                                            <option value="1979">1979</option>
                                            <option value="1978">1978</option>
                                            <option value="1977">1977</option>
                                            <option value="1976">1976</option>
                                            <option value="1975">1975</option>
                                            <option value="1974">1974</option>
                                            <option value="1973">1973</option>
                                            <option value="1972">1972</option>
                                            <option value="1971">1971</option>
                                            <option value="1970">1970</option>
                                            <option value="1969">1969</option>
                                            <option value="1968">1968</option>
                                            <option value="1967">1967</option>
                                            <option value="1966">1966</option>
                                            <option value="1965">1965</option>
                                            <option value="1964">1964</option>
                                            <option value="1963">1963</option>
                                            <option value="1962">1962</option>
                                            <option value="1961">1961</option>
                                            <option value="1960">1960</option>
                                            <option value="1959">1959</option>
                                            <option value="1958">1958</option>
                                            <option value="1957">1957</option>
                                            <option value="1956">1956</option>
                                            <option value="1955">1955</option>
                                            <option value="1954">1954</option>
                                            <option value="1953">1953</option>
                                            <option value="1952">1952</option>
                                            <option value="1951">1951</option>
                                            <option value="1950">1950</option>
                                            <option value="1949">1949</option>
                                            <option value="1948">1948</option>
                                            <option value="1947">1947</option>
                                            <option value="1946">1946</option>
                                            <option value="1945">1945</option>
                                            <option value="1944">1944</option>
                                            <option value="1943">1943</option>
                                            <option value="1942">1942</option>
                                            <option value="1941">1941</option>
                                            <option value="1940">1940</option>
                                            <option value="1939">1939</option>
                                            <option value="1938">1938</option>
                                            <option value="1937">1937</option>
                                            <option value="1936">1936</option>
                                            <option value="1935">1935</option>
                                            <option value="1934">1934</option>
                                            <option value="1933">1933</option>
                                        </select>
                                        <input value="631171824773" size="1" type="hidden" name="hidFecha1">

                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                    </td>
                                    <td colspan="3">
                                        <label id="lblErrortxtApellidoMaterno" class="error">
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
                                        <select name="cmbDocumentoIdentidad" class="text">
                                            <option selected value="1">D.N.I.</option>
                                            <option value="2">C.E</option>
                                            <option value="3">L.E.</option>
                                            <option value="4">Pasaporte</option>
                                        </select>
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
                                        <input maxlength="20" name="txtNumeroDNI" id="txtNumeroDNI" onkeypress="return isNumeric(event)" >
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
                                        <label id="lblErrortxtNumeroDNI" class="error">
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
                                        <input id="radSexo" value="1M" type="radio" checked name="radSexo" class="text">
                                        M&nbsp;&nbsp;&nbsp;
                                        <input id="radSexo" value="F" type="radio" name="radSexo" class="text">
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

        </form>
    </td>
  </tr>
</table>

<jsp:include page="include/footer.jsp" flush="true" />

<!-- End template editing here -->

</body>
</html>