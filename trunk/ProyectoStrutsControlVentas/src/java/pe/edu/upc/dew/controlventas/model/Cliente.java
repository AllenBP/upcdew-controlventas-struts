    package pe.edu.upc.dew.controlventas.model;


/**
 * Usuario que ingresa a la aplicacion
 *
 * @author u814296
 */
public class Cliente extends Usuario {

    private String email;
    private String fechaNacimiento;
    private int nroDocumento;
    private String sexo;
    private LineaCredito lineaCredito;
    private TipoDocumento tipoDocumento;

    public Cliente(){
        lineaCredito = new LineaCredito();
        tipoDocumento = new TipoDocumento();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public LineaCredito getLineaCredito() {
        return lineaCredito;
    }

    public void setLineaCredito(LineaCredito lineaCredito) {
        this.lineaCredito = lineaCredito;
    }

    public int getNroDocumento() {
        return nroDocumento;
    }

    public void setNroDocumento(int nroDocumento) {
        this.nroDocumento = nroDocumento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    

}
