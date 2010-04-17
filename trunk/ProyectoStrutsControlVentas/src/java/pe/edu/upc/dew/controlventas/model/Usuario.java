package pe.edu.upc.dew.controlventas.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Usuario que ingresa a la aplicacion
 *
 * @author u814296
 */
public class Usuario {

    /**
     * Código del usuario
     */
    private Integer idUsuario;
    /**
     * Nick del usuario
     */
    private String username;
    /**
     * Contraseña del usuario
     */
    private String password;
    /**
     * Nombre del usuario
     */
    private String nombre;
    /**
     * Apellido paterno del usuario
     */
    private String apellidoPaterno;
    /**
     * Apellido materno del usuario
     */
    private String apellidoMaterno;
    /**
     * Lista de Roles del uusuario
     */
    private List<Rol> roles;

    public Usuario() {
        this.roles = new ArrayList<Rol>();
    }

    public void agregarRol(Rol rol) {
        roles.add(rol);
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }



    public String getNombreCompleto() {
        return nombre + " " + apellidoPaterno + " " + apellidoMaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Valida que el usuario tenga el rol
     * @param nombre del rol
     * @return true si tiene el rol
     */
    public boolean tieneRol(String nombre) {
        for (int i = 0; i < roles.size(); i++) {
            Rol rol = roles.get(i);
            if (rol.getNombre().equals(nombre)) {
                return true;
            }
        }
        return false;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
