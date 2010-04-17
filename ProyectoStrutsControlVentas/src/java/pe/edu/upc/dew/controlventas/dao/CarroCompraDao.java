/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.dew.controlventas.dao;

import pe.edu.upc.dew.controlventas.model.DetallePedido;

/**
 *
 * Clase de acceso a datos que graba las compras del cliente.
 *
 * @author u814296
 */
public interface CarroCompraDao {

    /**
     * Metodo a ingreso de Producto en un venta.
     * @param detallePedido Datos del producto y detalle de ese pedido
     */
    void addCarroCompra(DetallePedido detallePedido);

}
