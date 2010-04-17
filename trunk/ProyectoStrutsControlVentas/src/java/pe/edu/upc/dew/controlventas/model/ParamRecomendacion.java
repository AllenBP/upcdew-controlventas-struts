/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.upc.dew.controlventas.model;

/**
 * Clase objeto de datos del parametros para la recomendacion de la linea de credito
 *
 * @author u814296
 */
public class ParamRecomendacion {

     /**
     * Sueldo del cliente
     */
   private double sueldo;
    /**
     * El numero de tarjeta del cliente
     */
    private int nroTarjeta;
    /**
     * Si el cliente tiene casa
     */
    private String isCasa;
    /**
     *  Si el cliente tiene Auto
     */
    private String isAuto;

    public String getIsAuto() {
        return isAuto;
    }

    public void setIsAuto(String isAuto) {
        this.isAuto = isAuto;
    }

    public String getIsCasa() {
        return isCasa;
    }

    public void setIsCasa(String isCasa) {
        this.isCasa = isCasa;
    }

    public int getNroTarjeta() {
        return nroTarjeta;
    }

    public void setNroTarjeta(int nroTarjeta) {
        this.nroTarjeta = nroTarjeta;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    
}
