/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.dew.controlventas.service;

import pe.edu.upc.dew.controlventas.dao.CarroCompraDao;
import pe.edu.upc.dew.controlventas.model.DetallePedido;


/**
 * Servicio de Carro de Compras
 * @author u814296
 */
public class CarroCompraService {



    public CarroCompraService(){
       
    }

    private CarroCompraDao carroCompraDao;

    public CarroCompraDao getCarroCompraDao() {
        return carroCompraDao;
    }

    public void setCarroCompraDao(CarroCompraDao carroCompraDao) {
        this.carroCompraDao = carroCompraDao;
    }

    public void addCarroCompra(DetallePedido detallePedido) {
        carroCompraDao.addCarroCompra(detallePedido);
    }


}
