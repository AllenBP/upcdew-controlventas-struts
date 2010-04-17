<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : menuSistema
    Created on : 13/02/2010, 10:20:17 AM
    Author     : u814296
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>

<jsp:useBean id="userSession" class="pe.edu.upc.dew.controlventas.model.Usuario" scope="session" />


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<table width="208" border="0" cellspacing="1" cellpadding="0">


    <c:forEach items="${userSession.roles}" var="rol">

        <tr>
            <td id="m1" class="menu" height="22" onMouseOver="this.className='menu_on'"
                    onMouseOut="this.className='menu'">
                    <a href="${rol.url}" class="menu2">
                     - ${rol.nombre}
                    </a></td>
        </tr>

    </c:forEach>

</table>
