package pe.edu.upc.dew.controlventas.model;

/**
 * Clase objeto de datos del Tipo de documento
 *
 * @author u814296
 */
public class TipoDocumento {

    /**
     * Codigo del tipo de documento
     */
    private int id;
    /**
     * Nombre del tipo de documento
     */
    private String nombre;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



}