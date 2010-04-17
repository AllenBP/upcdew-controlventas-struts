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
import pe.edu.upc.dew.controlventas.model.DetallePedido;
import pe.edu.upc.dew.controlventas.model.Pedido;
import pe.edu.upc.dew.controlventas.model.Producto;
import pe.edu.upc.dew.controlventas.model.Usuario;

/**
 * Action de Carro de compras
 * @author u814296
 */
public class CarroComprasAction extends org.apache.struts.action.Action {


    /* forward name="success" path="" */
    private final static String SUCCESS = "success";
    private final static String FAILURE = "failure";
    
    /**
     * Esta es una acción cuando se llama al action de Carro de Compras
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

        String metodo = (String) req.getParameter("metodo");
        metodo = (metodo == null) ? "listar" : metodo;

        if (metodo.equals("agregar")) {
            boolean exito = addIngresar(req);

            if(!exito)
                return mapping.findForward(FAILURE);

        }


        return mapping.findForward(SUCCESS);


    }

    /**
     * Método que se encargar de ingresar los elementos de compra.
     * @param req   Request donde se puede obtener los parametros de la web
     * @return Verdadero si se ingreso correctamente, Falso si no.
     */
    protected boolean addIngresar(HttpServletRequest req) {

        try{

            //Datos Usuario
            Usuario usuario = (Usuario) req.getSession().getAttribute("userSession");
            Pedido pedido = (Pedido) req.getSession().getAttribute("listaCarroDeCompras");

            if ( pedido == null ){
                pedido = new Pedido();
                pedido.setCliente(usuario);
            }

            DetallePedido dPedido = new DetallePedido();
            dPedido.setCantidad(1);

            Producto producto = new Producto();

            producto.setNombre(req.getParameter("nombre"));
            producto.setPrecio(Double.parseDouble(req.getParameter("precio")));

            dPedido.setProducto(producto);

            pedido.getDetallesPedidos().add(dPedido);

            pedido.setMontoTotal(pedido.getMontoTotal() + producto.getPrecio());

            req.getSession().setAttribute("listaCarroDeCompras", pedido);



        }catch(Exception ex){
            return false;
        }

        return true;

    }

}
