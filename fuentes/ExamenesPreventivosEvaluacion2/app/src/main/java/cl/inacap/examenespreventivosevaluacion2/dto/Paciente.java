//package
package cl.inacap.examenespreventivosevaluacion2.dto;
//imports
import android.widget.EditText;
import android.widget.Spinner;
//class
public class Paciente {
    //attributes
    private String rut;
    private String nombre;
    private String apellido;
    private EditText fecha;
    private Spinner areaTrabajo;
    private boolean presentaSintomas;
    private double temperatura;
    private boolean presentaTos;
    private int presionArterial;
    //getters and setters
    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public EditText getFecha() {
        return fecha;
    }

    public void setFecha(EditText fecha) {
        this.fecha = fecha;
    }

    public Spinner getAreaTrabajo() {
        return areaTrabajo;
    }

    public void setAreaTrabajo(Spinner areaTrabajo) {
        this.areaTrabajo = areaTrabajo;
    }

    public boolean isPresentaSintomas() {
        return presentaSintomas;
    }

    public void setPresentaSintomas(boolean presentaSintomas) {
        this.presentaSintomas = presentaSintomas;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public boolean isPresentaTos() {
        return presentaTos;
    }

    public void setPresentaTos(boolean presentaTos) {
        this.presentaTos = presentaTos;
    }

    public int getPresionArterial() {
        return presionArterial;
    }

    public void setPresionArterial(int presionArterial) {
        this.presionArterial = presionArterial;
    }
}
//end