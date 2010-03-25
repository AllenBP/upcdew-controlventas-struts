/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.upc.dew.controlventas.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.edu.upc.dew.controlventas.model.Usuario;
import pe.edu.upc.dew.controlventas.service.UsuarioService;

/**
 *
 * @author u814296
 */
public class LoginServlet extends HttpServlet {
   
     private UsuarioService usuarioService;

    public LoginServlet(){
        this.usuarioService = new UsuarioService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Ingreso a LoginServlet doPost");

        // Recuperamos los parametros del jsp
        // Se relaciona al atributo "name"
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Usuario usuario = usuarioService.getUsuarioPorUsername(username);

        HttpSession session = req.getSession(true);
        
        if (usuario.getPassword().equals(password)){
            session.setAttribute("userSession", usuario);
            req.getRequestDispatcher("home.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
    }
}
