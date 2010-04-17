package pe.edu.upc.dew.controlventas.model;

/**
 * Clase objeto de datos de la Linea de credito
 *
 * @author u814296
 */
public class LineaCredito  {

    /**
     * Codigo de la linea de credito
     */
    private int id;
    /**
     * Nombre de la linea de credito
     */
    private String nombre;
    /**
     * Rango minimo de la linea de credito
     */
    private double rangoMin;
    /**
     * Rango Maximo de la linea de credito
     */
    private double rangoMax;
    /**
     * Credito Real
     */
    private double creditoReal;

    public double getCreditoReal() {
        return creditoReal;
    }

    public void setCreditoReal(double creditoReal) {
        this.creditoReal = creditoReal;
    }

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

    public double getRangoMax() {
        return rangoMax;
    }

    public void setRangoMax(double rangoMax) {
        this.rangoMax = rangoMax;
    }

    public double getRangoMin() {
        return rangoMin;
    }

    public void setRangoMin(double rangoMin) {
        this.rangoMin = rangoMin;
    }



}