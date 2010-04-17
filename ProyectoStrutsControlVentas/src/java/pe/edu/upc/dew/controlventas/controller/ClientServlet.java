/**
 * Paquete de clases controladores que almacena los servlets usados en la aplicación.
 */
package pe.edu.upc.dew.controlventas.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.upc.dew.controlventas.factory.MyFactory;
import pe.edu.upc.dew.controlventas.model.Cliente;
import pe.edu.upc.dew.controlventas.service.ClienteService;

/**
 * Servlet de Matenimiento de Cliente
 *
 * @author u814296
 */
public class ClientServlet extends HttpServlet {
    
    /**
     * Clase privada para obtener los servicios de Cliente.
     */
    private ClienteService clienteService = MyFactory.getInstance().getClienteService();

    /**
     * Método Get donde se ejecuta la funcionalidad de listado o ingreso de cliente.
     * @param req   Request donde se puede obtener los parametros de la web
     * @param resp  Reponse donde se puede enviar los parametros de la web
     * @throws ServletException Excepción en caso ocurra un error en el servlet
     * @throws IOException Excepción que se produce en un error de E/S.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String metodo = (String) req.getParameter("metodo");
        metodo = (metodo == null) ? "listar" : metodo;

        if (metodo.equals("ingresar")) {
            doIngresar(req, resp);
        } else {
            if (metodo.equals("listar")) {
                doListar(req, resp);
            }
        }

    }

    /**
     * Método Post donde se llama al método Get
     * @param req   Request donde se puede obtener los parametros de la web
     * @param resp  Reponse donde se puede enviar los parametros de la web
     * @throws ServletException Excepción en caso ocurra un error en el servlet
     * @throws IOException Excepción que se produce en un error de E/S.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    /**
     * Método que se encargar de ingresar un cliente.
     *
     * @param req   Request donde se puede obtener los parametros de la web
     * @param resp  Reponse donde se puede enviar los parametros de la web
     * @throws ServletException Excepción en caso ocurra un error en el servlet
     * @throws IOException Excepción que se produce en un error de E/S.
     */
    protected void doIngresar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cliente cliente = new Cliente();

        cliente.setUsername(req.getParameter("txtEmail"));
        cliente.setPassword(req.getParameter("txtPassword"));

        cliente.setEmail(req.getParameter("txtEmailNoLogeo"));
        cliente.getLineaCredito().setCreditoReal(Double.parseDouble(req.getParameter("txtLineaCredito")));

        cliente.setNombre(req.getParameter("txtNombres"));
        cliente.setApellidoPaterno(req.getParameter("txtApellidoPaterno"));
        cliente.setApellidoMaterno(req.getParameter("txtApellidoMaterno"));
        cliente.setFechaNacimiento(req.getParameter("cmbFecha1Fecha") + "/"
                + req.getParameter("cmbFecha1Mes") + "/"
                + req.getParameter("cmbFecha1Anio"));
        cliente.getTipoDocumento().setId(Integer.parseInt(req.getParameter("cmbDocumentoIdentidad")));
        cliente.setNroDocumento(Integer.parseInt(req.getParameter("txtNumeroDNI")));
        cliente.setSexo("radSexo");

        clienteService.addCliente(cliente);

        if (true) {
            req.getRequestDispatcher("ClientServlet?metodo=listar").forward(req, resp);
        } else {
            req.getRequestDispatcher("home.jsp").forward(req, resp);
        }


    }

    /**
     * Método utilizado para la redireccion de la página de Listado de clientes actual;
     * @param req   Request donde se puede obtener los parametros de la web
     * @param resp  Reponse donde se puede enviar los parametros de la web
     * @throws ServletException Excepción en caso ocurra un error en el servlet
     * @throws IOException Excepción que se produce en un error de E/S.
     */
    protected void doListar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listaClientes", clienteService.getClientes());
        req.setAttribute("countlistaClientes", clienteService.getClientes().size());

        req.getRequestDispatcher("clientList.jsp").forward(req, resp);

    }

}
