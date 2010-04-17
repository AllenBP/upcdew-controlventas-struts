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
import pe.edu.upc.dew.controlventas.model.LineaCredito;
import pe.edu.upc.dew.controlventas.model.ParamRecomendacion;
import pe.edu.upc.dew.controlventas.service.LineaCreditoService;

/**
 * Servlet de Consulta de Línea de Crédito
 * @author u814296
 */
public class LineaCreditoServlet extends HttpServlet {
 
     /**
      * Clase privada para obtener los servicios de la Linea de Credito.
      */
     private LineaCreditoService lineaCreditoService = MyFactory.getInstance().getLineaCreditoService();


    /**
     * Método Post donde se ejecuta la funcionalidad de consulta para la Linea de Credito.
     * @param req   Request donde se puede obtener los parametros de la web
     * @param resp  Reponse donde se puede enviar los parametros de la web
     * @throws ServletException Excepción en caso ocurra un error en el servlet
     * @throws IOException Excepción que se produce en un error de E/S.
     */
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
