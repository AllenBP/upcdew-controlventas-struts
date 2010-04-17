package pe.edu.upc.dew.controlventas.model;

/**
 * Clase objeto de datos del Rol
 * @author u814296  
 */
public class Rol {

    /**
     * Codigo del Rol
     */
    private Integer idRol;
    /**
     * Nombre del Rol
     */
    private String nombre;
    /**
     * Dirección enlace del Rol
     */
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
