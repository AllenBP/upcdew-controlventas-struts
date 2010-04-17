/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.upc.dew.controlventas.dao;

import java.util.List;
import pe.edu.upc.dew.controlventas.model.LineaCredito;

/**
 * Clase de acceso a datos que consulta los datos de Linea de Credito
 * @author u814296
 */
public interface LineaCreditoDao {

    /**
     * Metodo encargado de retornar una Linea de credito deacuerdo al monto ingresado
     * @param sueldo    Sueldo de cliente
     * @return Retorna una linea de credito desde BD
     */
    LineaCredito buscarLineaCredito(double sueldo);

    /**
     * Listado de Lineas de Credito
     * @return Listado de creditos
     */
    List<LineaCredito> getLineasCreditos();

}
