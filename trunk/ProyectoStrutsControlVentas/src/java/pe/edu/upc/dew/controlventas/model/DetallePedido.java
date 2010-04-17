/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.upc.dew.controlventas.model;

/**
 * Clase objeto de datos del detalle de la venta
 *
 * @author u814296
 */
public class DetallePedido {
    /**
     * Id de transaccion
     */

    private int idtransaccion;
    /**
     * Id de cliente
     */

     private int idCliente;

    /**
     * Valor de cuota capital
     */
     private String valorcuotacapital;
    /**
     * Valor de cuota intenres
     */
     private String valorcuotainteres;
    /**
     * Abono de venta
     */
     private String abono;
    /**
     * Coutas cargadas de venta
     */
     private String cuotascargadas;

    public String getAbono() {
        return abono;
    }

    public void setAbono(String abono) {
        this.abono = abono;
    }

    public String getCuotascargadas() {
        return cuotascargadas;
    }

    public void setCuotascargadas(String cuotascargadas) {
        this.cuotascargadas = cuotascargadas;
    }

    public String getValorcuotacapital() {
        return valorcuotacapital;
    }

    public void setValorcuotacapital(String valorcuotacapital) {
        this.valorcuotacapital = valorcuotacapital;
    }

    public String getValorcuotainteres() {
        return valorcuotainteres;
    }

    public void setValorcuotainteres(String valorcuotainteres) {
        this.valorcuotainteres = valorcuotainteres;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    private Producto producto;
    private int cantidad;

    public int getIdtransaccion() {
        return idtransaccion;
    }

    public void setIdtransaccion(int idtransaccion) {
        this.idtransaccion = idtransaccion;
    }
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
}
