    package pe.edu.upc.dew.controlventas.model;


/**
 * Clase objeto de datos del Cliente
 *
 * @author u814296
 */
public class Cliente extends Usuario {

    /**
     * Correo Electronico del cliente
     */
    private String email;
    /**
     * Fecha de nacimiento del cliente
     */
    private String fechaNacimiento;
    /**
     * Numero de documento del cliente
     */
    private int nroDocumento;
    /**
     * Genero del cliente
     */
    private String sexo;
    /**
     * Linea de credito del cliente
     */
    private LineaCredito lineaCredito;
    /**
     * Tipo de documento del cliente
     */
    private TipoDocumento tipoDocumento;

    /**
     *
     */
    public Cliente(){
        lineaCredito = new LineaCredito();
        tipoDocumento = new TipoDocumento();
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     */
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     *
     * @param fechaNacimiento
     */
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     *
     * @return
     */
    public LineaCredito getLineaCredito() {
        return lineaCredito;
    }

    /**
     *
     * @param lineaCredito
     */
    public void setLineaCredito(LineaCredito lineaCredito) {
        this.lineaCredito = lineaCredito;
    }

    /**
     *
     * @return
     */
    public int getNroDocumento() {
        return nroDocumento;
    }

    /**
     *
     * @param nroDocumento
     */
    public void setNroDocumento(int nroDocumento) {
        this.nroDocumento = nroDocumento;
    }

    /**
     *
     * @return
     */
    public String getSexo() {
        return sexo;
    }

    /**
     *
     * @param sexo
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     *
     * @return
     */
    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    /**
     *
     * @param tipoDocumento
     */
    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    

}
