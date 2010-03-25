/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.dew.controlventas.service;

import pe.edu.upc.dew.controlventas.dao.UsuarioDao;
import pe.edu.upc.dew.controlventas.model.Usuario;

/**
 *
 * @author u814296
 */
public class UsuarioService {
    private UsuarioDao usuarioDao;

    public UsuarioService(){
        this.usuarioDao = new UsuarioDao();
    }

    public Usuario getUsuarioPorUsername(String username) {
        return usuarioDao.getUsuarioPorUsername(username);
    }
}
