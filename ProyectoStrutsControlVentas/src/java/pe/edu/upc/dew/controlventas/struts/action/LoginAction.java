/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.dew.controlventas.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import pe.edu.upc.dew.controlventas.factory.MyFactory;
import pe.edu.upc.dew.controlventas.model.Usuario;
import pe.edu.upc.dew.controlventas.service.UsuarioService;
import pe.edu.upc.dew.controlventas.struts.forms.LoginForm;

/**
 * Action Login
 * @author u814296
 */
public class LoginAction extends org.apache.struts.action.Action {

    private UsuarioService usuarioService;


    /**
     *
     */
    public LoginAction() {
        this.usuarioService = MyFactory.getInstance().getUsuarioService();
    }

    /* forward name="success" path="" */
    private final static String SUCCESS = "success";
    private final static String FAILURE = "failure";
    /**
     * Esta es una acción cuando se llama al action de acceso al sistema
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param req   Request donde se puede obtener los parametros de la web
     * @param resp  Reponse donde se puede enviar los parametros de la web
     * @throws java.lang.Exception Excepción en caso ocurra un error
     * @return Direccion donde se ira al finalizar el método.
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        LoginForm loginForm = (LoginForm) form;

        Usuario usuario = usuarioService.getUsuarioPorUsername(loginForm.getUserName());
        HttpSession session = request.getSession(true);

        if (loginForm.getPassword().equals(loginForm.getPassword())) {
            session.setAttribute("userSession", usuario);
            return mapping.findForward(SUCCESS);
        } else {
            return mapping.findForward(FAILURE);
        }
    }
}
