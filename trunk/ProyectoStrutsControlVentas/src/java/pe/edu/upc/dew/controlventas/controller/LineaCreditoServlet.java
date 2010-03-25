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
import pe.edu.upc.dew.controlventas.model.LineaCredito;
import pe.edu.upc.dew.controlventas.model.ParamRecomendacion;
import pe.edu.upc.dew.controlventas.service.LineaCreditoService;

/**
 *
 * @author u814296
 */
public class LineaCreditoServlet extends HttpServlet {
   
     private LineaCreditoService lineaCreditoService;

    public LineaCreditoServlet(){
        this.lineaCreditoService = new LineaCreditoService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Ingreso a LineaCreditoServlet doPost");

        String mensaje = "";

        try{

                ParamRecomendacion recom = new ParamRecomendacion();

                recom.setSueldo(Double.parseDouble(req.getParameter("txtSueldo")));
                recom.setNroTarjeta(Integer.parseInt(req.getParameter("txtNroTarjetas")));

                recom.setIsCasa(req.getParameter("radCasa"));
                recom.setIsAuto(req.getParameter("radAuto"));

                LineaCredito lc = lineaCreditoService.asignarLineaCredito(recom);

                mensaje = "Se recomienda que el cliente tenga un rango de credito de ";
                mensaje += lc.getRangoMin() + " a " + lc.getRangoMax();
                mensaje += ", Categoria: " + lc.getNombre();

        }catch(Exception ex){

            mensaje = "Con la informacion ingresada no se puede recomendar ninguna línea de credito";

        }

        req.setAttribute("mensajeCredito", mensaje);

        req.getRequestDispatcher("lineaCredito.jsp").forward(req, resp);

    }
}
