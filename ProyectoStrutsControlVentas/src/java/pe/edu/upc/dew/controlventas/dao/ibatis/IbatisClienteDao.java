/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.dew.controlventas.dao.ibatis;

import pe.edu.upc.dew.controlventas.dao.ClienteDao;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import pe.edu.upc.dew.controlventas.model.Cliente;

/**
 * Clase de mapeo de datos que graba al cliente.
 * @author u814296
 */
public class IbatisClienteDao extends SqlMapClientDaoSupport implements ClienteDao {

    /**
     * Metodo a ingreso de Cliente.
     * @param cliente Datos del nuevo cliente
     */
    public List<Cliente> getClientes() {
        List<Cliente> clientes = (List<Cliente>) getSqlMapClientTemplate().queryForList("getClientes");
        return clientes;
    }

    /**
     * Listado de Clientes desde BD
     * @return Lista de Clientes
     */
    public void addCliente(Cliente cliente) {
        Object obj = getSqlMapClientTemplate().insert("addCliente", cliente);
    }
}
