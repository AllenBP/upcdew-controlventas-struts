/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.dew.controlventas.struts.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import pe.edu.upc.dew.controlventas.factory.MyFactory;
import pe.edu.upc.dew.controlventas.model.Cliente;
import pe.edu.upc.dew.controlventas.service.ClienteService;
import pe.edu.upc.dew.controlventas.struts.forms.ClientForm;

/**
 * Action de Cliente
 * @author u814296
 */
public class ClientAction extends org.apache.struts.action.Action {

    /**
     * Clase privada para obtener los servicios de Cliente.
     */
    private ClienteService clienteService = MyFactory.getInstance().getClienteService();


    /* forward name="success" path="" */
    private final static String SUCCESS = "success";
    private final static String LIST = "list";
    private final static String FAILURE = "failure";
    /**
     * Esta es una acción cuando se llama al action de Cliente
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param req   Request donde se puede obtener los parametros de la web
     * @param resp  Reponse donde se puede enviar los parametros de la web
     * @throws java.lang.Exception Excepción en caso ocurra un error
     * @return Direccion donde se ira al finalizar el método.
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest req, HttpServletResponse resp)
            throws Exception {

        ClientForm clientForm = (ClientForm) form;

        String metodo = (String) req.getParameter("metodo");
        metodo = (metodo == null) ? "listar" : metodo;

        if (metodo.equals("ingresar")) {
            boolean exito = doIngresar(clientForm);

            if(!exito)
                return mapping.findForward(FAILURE);
            
        }

        req.setAttribute("listaClientes", clienteService.getClientes());
        req.setAttribute("countlistaClientes", clienteService.getClientes().size());

        return mapping.findForward(SUCCESS);

        
    }

    /**
     * Método que se encargar de ingresar un cliente.
     * @param clientForm Datos del formulario del cliente
     * @return Verdadero si se ingreso correctamente, Falso si no.
     */
    protected boolean doIngresar(ClientForm clientForm) {

        try{

        Cliente cliente = new Cliente();

        cliente.setUsername(clientForm.getUsername());
        cliente.setPassword(clientForm.getPassword());

        cliente.setEmail(clientForm.getEmail());
        cliente.getLineaCredito().setCreditoReal(Double.parseDouble(clientForm.getLineaCreditoReal()));

        cliente.setNombre(clientForm.getNombre());
        cliente.setApellidoPaterno(clientForm.getApellidoPaterno());
        cliente.setApellidoMaterno(clientForm.getApellidoMaterno());
        cliente.setFechaNacimiento(clientForm.getDia()+ "/"
                + clientForm.getMes() + "/"
                + clientForm.getAnio() );
        cliente.getTipoDocumento().setId(Integer.parseInt(clientForm.getTipoDocumento()));
        cliente.setNroDocumento(clientForm.getNroDocumento());
        cliente.setSexo(clientForm.getSexo());

        clienteService.addCliente(cliente);

        }catch(Exception ex){
            return false;
        }

        return true;

    }


}
