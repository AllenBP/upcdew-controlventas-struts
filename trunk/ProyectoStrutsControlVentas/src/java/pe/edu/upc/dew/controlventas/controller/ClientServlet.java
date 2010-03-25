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
import pe.edu.upc.dew.controlventas.model.Cliente;
import pe.edu.upc.dew.controlventas.service.ClienteService;

/**
 *
 * @author u814296
 */
public class ClientServlet extends HttpServlet {

     private ClienteService clienteService;

    public ClientServlet(){
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String metodo = (String)req.getParameter("metodo");
        metodo = (metodo==null)?"listar":metodo;

        if(metodo.equals("ingresar")){
            doIngresar(req, resp);
        }else{
            if(metodo.equals("listar")){
                doListar(req, resp);
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    protected void doIngresar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        clienteService = new ClienteService(req.getSession());

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
                + req.getParameter("cmbFecha1Anio") );
        cliente.getTipoDocumento().setId(Integer.parseInt(req.getParameter("cmbDocumentoIdentidad")));
        cliente.setNroDocumento(Integer.parseInt(req.getParameter("txtNumeroDNI")));
        cliente.setSexo("radSexo");

        clienteService.addCliente(cliente);

        if (true){
            req.getRequestDispatcher("ClientServlet?metodo=listar").forward(req, resp);
        } else {
            req.getRequestDispatcher("home.jsp").forward(req, resp);
        }


    }


    protected void doListar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        clienteService = new ClienteService(req.getSession());

        req.setAttribute("listaClientes", clienteService.getClientes());
        req.setAttribute("countlistaClientes", clienteService.getClientes().size());

        req.getRequestDispatcher("clientList.jsp").forward(req, resp);

    }



}
