/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.dew.controlventas.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;

/**
 * Action LogOut
 * @author u814296  
 */
public class LogoutAction extends org.apache.struts.action.Action {

    
    /* forward name="success" path="" */
    private final static String SUCCESS = "success";
    private final static String FAILURE = "failure";
    /**
     * Esta es una acción cuando se llama al action de salir del sistema
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request
     * @param response
     * @throws java.lang.Exception Excepción en caso ocurra un error
     * @return Direccion donde se ira al finalizar el método.
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        request.getSession().removeAttribute("userSession");
        request.getSession().removeAttribute("listaCarroDeCompras");

        return mapping.findForward(SUCCESS);

    }
}
