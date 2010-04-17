/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.dew.controlventas.dao.ibatis;

import pe.edu.upc.dew.controlventas.dao.UsuarioDao;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import pe.edu.upc.dew.controlventas.model.Usuario;

/**
 * Clase de mapeo de datos que consulta los datos del usuario
 * @author u814296
 */
public class IbatisUsuarioDao extends SqlMapClientDaoSupport implements UsuarioDao {

    /**
     * Obtiene un Usuario por username de la BD
     * @param username  Nombre del Usuario
     * @return Usuario  Retorna los datos completos del usuario
     */
    public Usuario getUsuarioPorUsername(String username) {
        return (Usuario) getSqlMapClientTemplate().queryForObject("getUsuarioPorUsername", username);
    }
}
