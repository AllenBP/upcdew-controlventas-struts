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
import pe.edu.upc.dew.controlventas.factory.MyFactory;
import pe.edu.upc.dew.controlventas.model.DetallePedido;
import pe.edu.upc.dew.controlventas.model.Pedido;
import pe.edu.upc.dew.controlventas.model.Usuario;
import pe.edu.upc.dew.controlventas.service.CarroCompraService;

/**
 * Action de Venta
 * @author u814296
 */
public class VentaAction extends org.apache.struts.action.Action {

    
    private CarroCompraService carroCompraService = MyFactory.getInstance().getCarroCompraService();


    /* forward name="success" path="" */
    private final static String SUCCESS = "success";
    private final static String FAILURE = "failure";
    /**
     * This is the action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param req   Request donde se puede obtener los parametros de la web
     * @param resp  Reponse donde se puede enviar los parametros de la web
     * @throws java.lang.Exception Excepción en caso ocurra un error
     * @return Direccion donde se ira al finalizar el método.
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest req, HttpServletResponse resp)
            throws Exception {

            Usuario usuario = (Usuario) req.getSession().getAttribute("userSession");
            Pedido pedido = (Pedido) req.getSession().getAttribute("listaCarroDeCompras");

            if ( pedido == null ){
                return mapping.findForward(FAILURE);
            }


            for (int i = 0; i < pedido.getDetallesPedidos().size(); i++) {
                DetallePedido dPedido = pedido.getDetallesPedidos().get(i);
                dPedido.setIdCliente(usuario.getIdUsuario());
                carroCompraService.addCarroCompra(dPedido);
            }

            return mapping.findForward(SUCCESS);

    }



}
