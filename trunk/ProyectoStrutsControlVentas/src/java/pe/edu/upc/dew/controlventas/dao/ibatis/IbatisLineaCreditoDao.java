/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.dew.controlventas.dao.ibatis;

import pe.edu.upc.dew.controlventas.dao.LineaCreditoDao;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import pe.edu.upc.dew.controlventas.model.LineaCredito;

/**
 * Clase de mapeo de datos que graba o consulta la Linea de Credito
 * @author u814296
 */
public class IbatisLineaCreditoDao extends SqlMapClientDaoSupport implements LineaCreditoDao {

    /**
     * Metodo encargado de retornar una Linea de credito deacuerdo al monto ingresado
     * @param sueldo    Sueldo de cliente
     * @return Retorna una linea de credito desde BD
     */
    public LineaCredito buscarLineaCredito(double sueldo) {
        return (LineaCredito) getSqlMapClientTemplate().queryForObject("buscarLineaCredito", sueldo);
    }

    /**
     * Listado de Lineas de Credito
     * @return Listado de creditos
     */
    public List<LineaCredito> getLineasCreditos() {
        List<LineaCredito> lineasCreditos = (List<LineaCredito>) getSqlMapClientTemplate().queryForList("getLineasCreditos");
        return lineasCreditos;
    }
}
