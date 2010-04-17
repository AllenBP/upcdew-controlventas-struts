/**
 * Paquete de clases controladores que almacena los servlets usados en la aplicación.
 */
package pe.edu.upc.dew.controlventas.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperRunManager;
import pe.edu.upc.dew.controlventas.factory.MyFactory;
import pe.edu.upc.dew.controlventas.model.Usuario;

/**
 * Servlet de Estado de Cuenta
 * @author u814296
 */
public class EstadoCuentaServlet extends HttpServlet {

    /**
     * Proceso request donde carga el reporte de estado de cuenta del cliente.
     * @param req   Request donde se puede obtener los parametros de la web
     * @param resp  Reponse donde se puede enviar los parametros de la web
     * @throws ServletException Excepción en caso ocurra un error en el servlet
     * @throws IOException Excepción que se produce en un error de E/S.
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Usuario usuario = (Usuario) request.getSession().getAttribute("userSession");

        Connection conn = null;
        try {
            response.setHeader("Content-disposition", "attachment; filename=EstadoDCuenta.pdf");
            response.setContentType("application/pdf");

            ServletOutputStream servletOutputStream = response.getOutputStream();
            InputStream reportStream = getServletConfig().getServletContext().getResourceAsStream("/reporte/rptEstadoCuenta.jasper");

            conn = MyFactory.getInstance().getConection();
            Map map = new HashMap();
            map.put("paramIdUsuario", usuario.getIdUsuario());

            JasperRunManager.runReportToPdfStream(reportStream,
                    servletOutputStream, map, conn);
            servletOutputStream.flush();
            servletOutputStream.close();
        } catch (Exception e) {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            e.printStackTrace(printWriter);
            response.setContentType("text/plain");
            response.getOutputStream().print(stringWriter.toString());
        } finally {
            if (conn != null) {
                MyFactory.getInstance().releaseConection(conn);
            }
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
