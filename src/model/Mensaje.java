
package model;

/**
 *
 * @author Nimrod
 * 
 */
public class Mensaje {
    
    private int idMensaje;
    private String arbMensaje;
    private String cphMensaje;
    private String cpsMensaje;
    private String desMensaje;
    private String crbMensaje;

    public Mensaje(int idMensaje, String arbMensaje, String cphMensaje, String cpsMensaje, String desMensaje, String crbMensaje) {
        this.idMensaje = idMensaje;
        this.arbMensaje = arbMensaje;
        this.cphMensaje = cphMensaje;
        this.cpsMensaje = cpsMensaje;
        this.desMensaje = desMensaje;
        this.crbMensaje = crbMensaje;
    }

    public Mensaje() {
    }

    public int getIdMensaje() {
        return idMensaje;
    }

    public void setIdMensaje(int idMensaje) {
        this.idMensaje = idMensaje;
    }

    public String getArbMensaje() {
        return arbMensaje;
    }

    public void setArbMensaje(String arbMensaje) {
        this.arbMensaje = arbMensaje;
    }

    public String getCphMensaje() {
        return cphMensaje;
    }

    public void setCphMensaje(String cphMensaje) {
        this.cphMensaje = cphMensaje;
    }

    public String getCpsMensaje() {
        return cpsMensaje;
    }

    public void setCpsMensaje(String cpsMensaje) {
        this.cpsMensaje = cpsMensaje;
    }

    public String getDesMensaje() {
        return desMensaje;
    }

    public void setDesMensaje(String desMensaje) {
        this.desMensaje = desMensaje;
    }

    public String getCrbMensaje() {
        return crbMensaje;
    }

    public void setCrbMensaje(String crbMensaje) {
        this.crbMensaje = crbMensaje;
    }

    @Override
    public String toString() {
        return "Mensaje{" + "idMensaje=" + idMensaje + ", arbMensaje=" + arbMensaje + ", cphMensaje=" + cphMensaje + ", cpsMensaje=" + cpsMensaje + ", desMensaje=" + desMensaje + ", crbMensaje=" + crbMensaje + '}';
    }
    
}
