package cl.inacap.examenespreventivosevaluacion2.dao;

import java.util.List;

import cl.inacap.examenespreventivosevaluacion2.dto.Paciente;

public interface PacientesDAO {

    List<Paciente> getAll();
    Paciente save(Paciente p);

}
