/**
 * Paquete de clases controladores que almacena los servlets usados en la aplicación.
 */
package pe.edu.upc.dew.controlventas.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet de Logout, salir del sistema
 * @author u814296
 */
public class LogoutServlet extends HttpServlet {

    /**
     * Método Post donde se encarga de eliminar la variables de sesion y salir del sistema
     * @param req   Request donde se puede obtener los parametros de la web
     * @param resp  Reponse donde se puede enviar los parametros de la web
     * @throws ServletException Excepción en caso ocurra un error en el servlet
     * @throws IOException Excepción que se produce en un error de E/S.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("Ingreso a LogoutServlet");
        req.getSession().removeAttribute("userSession");
        req.getSession().removeAttribute("listaCarroDeCompras");
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    /**
     * Método Post donde se llama al metodo Get
     * @param req   Request donde se puede obtener los parametros de la web
     * @param resp  Reponse donde se puede enviar los parametros de la web
     * @throws ServletException Excepción en caso ocurra un error en el servlet
     * @throws IOException Excepción que se produce en un error de E/S.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}
