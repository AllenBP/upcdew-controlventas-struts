/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.upc.dew.controlventas.model;

/**
 *
 * @author u814296
 */
public class ParamRecomendacion {

    private double sueldo;
    private int nroTarjeta;
    private String isCasa;
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
