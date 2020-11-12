//package
package cl.inacap.examenespreventivosevaluacion2.dao;
//imports
import java.util.ArrayList;
import java.util.List;
import cl.inacap.examenespreventivosevaluacion2.dto.Paciente;
//class
public class PacientesDAOLista  implements PacientesDAO {
    //list
    private List<Paciente> pacientes = new ArrayList<>();
    //attribute instance
    private static PacientesDAOLista instancia;
    //private constructor of class
    private PacientesDAOLista() {
        Paciente p = new Paciente();
        p.setRut("19774017-5");
        p.setNombre("Bernardo");
        p.setApellido("Segovia");
        pacientes.add(p);
    }
    //get
    public static PacientesDAOLista getInstance() {
        if(instancia == null) {
            instancia = new PacientesDAOLista();
        }
        return instancia;
    }





    //1
    @Override
    public List<Paciente> getAll() {
        return pacientes;
    }
    //2
    @Override
    public Paciente save(Paciente p) {
        pacientes.add(p);
        return p;
    }
}
//end