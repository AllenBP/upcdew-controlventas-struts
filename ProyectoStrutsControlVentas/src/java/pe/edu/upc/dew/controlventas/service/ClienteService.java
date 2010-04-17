/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.dew.controlventas.service;

import java.util.List;
import pe.edu.upc.dew.controlventas.dao.ClienteDao;
import pe.edu.upc.dew.controlventas.dao.LineaCreditoDao;
import pe.edu.upc.dew.controlventas.model.Cliente;

/**
 *
 * @author u814296
 */
public class ClienteService {

    private ClienteDao clienteDao;
    private LineaCreditoDao lineaCreditoDao;

    public void setClienteDao(ClienteDao clienteDao) {
        this.clienteDao = clienteDao;
    }

    public void setLineaCreditoDao(LineaCreditoDao lineaCreditoDao) {
        this.lineaCreditoDao = lineaCreditoDao;
    }

    public void addCliente(Cliente cliente) {

        double credito = cliente.getLineaCredito().getCreditoReal();

        cliente.setLineaCredito(lineaCreditoDao.buscarLineaCredito(credito));
        cliente.getLineaCredito().setCreditoReal(credito);

        clienteDao.addCliente(cliente);

    }

    public List<Cliente> getClientes() {
        return clienteDao.getClientes();
    }
}
