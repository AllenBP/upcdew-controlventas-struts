/**
 * Paquete de clases controladores que almacena los servlets usados en la aplicación.
 */
package pe.edu.upc.dew.controlventas.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.upc.dew.controlventas.model.DetallePedido;
import pe.edu.upc.dew.controlventas.model.Pedido;
import pe.edu.upc.dew.controlventas.model.Producto;
import pe.edu.upc.dew.controlventas.model.Usuario;
import pe.edu.upc.dew.controlventas.service.CarroCompraService;

/**
 *
 * Servlet de Carro de compras
 *
 * @author u814296
 */
public class CarroComprasServlet extends HttpServlet {

    /**
     * Clase privada para obtener los servicios de carro de compra.
     */
     private CarroCompraService carroComprasService;

    /**
     * Método Get donde se ejecuta la funcionalidad de agregación de elementos de compras.
     *
     * @param req   Request donde se puede obtener los parametros de la web
     * @param resp  Reponse donde se puede enviar los parametros de la web
     * @throws ServletException Excepción en caso ocurra un error en el servlet
     * @throws IOException Excepción que se produce en un error de E/S.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String metodo = (String)req.getParameter("metodo");
        metodo = (metodo==null)?"listar":metodo;

        if(metodo.equals("agregar")){
            doIngresar(req, resp);
        }else{
            if(metodo.equals("listar")){
                doListar(req, resp);
            }
        }

    }

    /**
     * Método Post donde se ejecuta la funcionalidad de agregación de elementos de compras.
     *
     * @param req   Request donde se puede obtener los parametros de la web
     * @param resp  Reponse donde se puede enviar los parametros de la web
     * @throws ServletException Excepción en caso ocurra un error en el servlet
     * @throws IOException Excepción que se produce en un error de E/S.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    /**
     * Método que se encargar de ingresar los elementos de compra.
     * 
     * @param req   Request donde se puede obtener los parametros de la web
     * @param resp  Reponse donde se puede enviar los parametros de la web
     * @throws ServletException Excepción en caso ocurra un error en el servlet
     * @throws IOException Excepción que se produce en un error de E/S.
     */
    protected void doIngresar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

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

        req.getRequestDispatcher("carroCompra.jsp").forward(req, resp);


    }


    /**
     * Método utilizado para la redireccion de la pagina de Listado de compras actual;
     * @param req   Request donde se puede obtener los parametros de la web
     * @param resp  Reponse donde se puede enviar los parametros de la web
     * @throws ServletException Excepción en caso ocurra un error en el servlet
     * @throws IOException Excepción que se produce en un error de E/S.
     */
    protected void doListar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("carroCompra.jsp").forward(req, resp);

    }



}
