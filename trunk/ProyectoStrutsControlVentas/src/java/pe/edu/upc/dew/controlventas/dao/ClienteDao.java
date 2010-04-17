/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.dew.controlventas.dao;

import java.util.List;
import pe.edu.upc.dew.controlventas.model.Cliente;

/**
 * Clase de acceso a datos que grabar los datos del cliente.
 * @author u814296
 */
public interface ClienteDao {

    /**
     * Metodo a ingreso de Cliente.
     * @param cliente Datos del nuevo cliente
     */
    void addCliente(Cliente cliente);

    /**
     * Listado de Clientes desde BD
     * @return Lista de Clientes
     */
    List<Cliente> getClientes();
}
