/**
 * Paquete de clases controladores que almacena los servlets usados en la aplicación.
 */
package pe.edu.upc.dew.controlventas.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.edu.upc.dew.controlventas.factory.MyFactory;
import pe.edu.upc.dew.controlventas.model.Usuario;
import pe.edu.upc.dew.controlventas.service.UsuarioService;

/**
 * Servlet de Logueo, acceso al sistema
 * 
 * @author u814296
 */
public class LoginServlet extends HttpServlet {

    /**
     * Clase privada para obtener los servicios del Usuario.
     */
    private UsuarioService usuarioService = MyFactory.getInstance().getUsuarioService();

    /**
     * Método Post donde se ejecuta la funcionalidad de consulta y acceso del Usuario.
     *
     * @param req   Request donde se puede obtener los parametros de la web
     * @param resp  Reponse donde se puede enviar los parametros de la web
     * @throws ServletException Excepción en caso ocurra un error en el servlet
     * @throws IOException Excepción que se produce en un error de E/S.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Ingreso a LoginServlet doPost");

        // Recuperamos los parametros del jsp
        // Se relaciona al atributo "name"
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Usuario usuario = usuarioService.getUsuarioPorUsername(username);

        HttpSession session = req.getSession(true);

        if (usuario.getPassword().equals(password)) {
            session.setAttribute("userSession", usuario);
            req.getRequestDispatcher("home.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
    }
}
