/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.dew.controlventas.service;

import java.util.List;
import javax.servlet.http.HttpSession;
import pe.edu.upc.dew.controlventas.dao.ClienteDao;
import pe.edu.upc.dew.controlventas.model.Cliente;
import pe.edu.upc.dew.controlventas.model.LineaCredito;

/**
 *
 * @author u814296
 */
public class ClienteService {
    private ClienteDao ClienteDao;
    private HttpSession session;

    public ClienteService(HttpSession _session){

        session = _session;

        if(session.getAttribute("clientesSession")==null){
            this.ClienteDao = new ClienteDao();
        }else{
            this.ClienteDao = (ClienteDao) session.getAttribute("clientesSession");
        }

    }

    public void addCliente(Cliente cliente) {

        double credito = cliente.getLineaCredito().getCreditoReal();
        
        cliente.setLineaCredito((new LineaCreditoService()).buscarLineaCredito(credito));
        cliente.getLineaCredito().setCreditoReal(credito);

        ClienteDao.addCliente(cliente);
        session.setAttribute("clientesSession", ClienteDao);

    }

    public List<Cliente> getClientes() {
        return ClienteDao.getClientes();
    }

}
