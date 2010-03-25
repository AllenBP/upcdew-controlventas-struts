package pe.edu.upc.dew.controlventas.model;

/**
 * Usuario que ingresa a la aplicacion
 *
 * @author u814296
 */
public class LineaCredito  {

    private int id;
    private String nombre;
    private double rangoMin;
    private double rangoMax;
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