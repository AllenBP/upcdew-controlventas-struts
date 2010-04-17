/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.upc.dew.controlventas.dao;

import pe.edu.upc.dew.controlventas.model.Usuario;

/**
 * Clase de acceso a datos que consulta los datos del Usuario
 * @author u814296
 */
public interface UsuarioDao {

    /**
     * Obtiene un Usuario por username de la BD
     * @param username  Nombre del Usuario
     * @return Usuario  Retorna los datos completos del usuario
     */
    Usuario getUsuarioPorUsername(String username);

}
