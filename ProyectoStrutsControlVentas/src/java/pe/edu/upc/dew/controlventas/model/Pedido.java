/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.upc.dew.controlventas.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase objeto de datos del Pedido
 *
 * @author u814296
 */
public class Pedido {

    /**
     *  NOmbre del pedido
     */
    private String nombre;
    /**
     * Cliente que esta comprando
     */
    private Cliente cliente;
    /**
     * Monto total de venta
     */
    private double montoTotal;
    /**
     * Lista de productos en la venta
     */
    private List<DetallePedido> detallesPedidos;

    public Pedido() {
        detallesPedidos = new ArrayList<DetallePedido>();
        cliente = new Cliente();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setCliente(Usuario usuario) {
        this.cliente = new Cliente();
//        this.cliente.setNombre(usuario.getNombre());
//        this.cliente.setApellidoPaterno(usuario.getApellidoPaterno());
//        this.cliente.setApellidoMaterno(usuario.getApellidoMaterno());
        
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<DetallePedido> getDetallesPedidos() {
        return detallesPedidos;
    }

    public void setDetallesPedidos(List<DetallePedido> detallesPedidos) {
        this.detallesPedidos = detallesPedidos;
    }

    
}
