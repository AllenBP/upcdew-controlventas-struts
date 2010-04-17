/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.upc.dew.controlventas.model;

/**
 * Clase objeto de datos del Producto
 *
 * @author u814296
 */
public class Producto {

    /**
     * Nombre del producot
     */
    private String nombre;
    /**
     * Precio del producto
     */
    private double precio;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

}
