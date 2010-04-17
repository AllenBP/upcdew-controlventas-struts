/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.dew.controlventas.dao.ibatis;

import pe.edu.upc.dew.controlventas.dao.CarroCompraDao;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import pe.edu.upc.dew.controlventas.model.DetallePedido;

/**
 * Clase de mapeo de datos que graba las compras del cliente.
 * @author u814296
 */
public class IbatisCarroCompraDao extends SqlMapClientDaoSupport implements CarroCompraDao {

    /**
     * Metodo a ingreso de Producto en un venta.
     * @param detallePedido Datos del producto y detalle de ese pedido
     */
    public void addCarroCompra(DetallePedido detallePedido) {
        Object obj = getSqlMapClientTemplate().insert("addCarroCompra", detallePedido);
    }
}
