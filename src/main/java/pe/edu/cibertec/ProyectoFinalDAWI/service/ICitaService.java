package pe.edu.cibertec.ProyectoFinalDAWI.service;

import pe.edu.cibertec.ProyectoFinalDAWI.model.bd.Cita;

import java.util.List;

public interface ICitaService {
    List<Cita> listarCitas();
    void registrarCita(Cita cita);
}
