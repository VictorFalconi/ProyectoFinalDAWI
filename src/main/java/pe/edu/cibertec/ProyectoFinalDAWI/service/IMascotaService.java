package pe.edu.cibertec.ProyectoFinalDAWI.service;

import pe.edu.cibertec.ProyectoFinalDAWI.model.bd.Mascota;

import java.util.List;

public interface IMascotaService {
    List<Mascota> listarMascotas();
    void registrarMascota(Mascota mascota);
}
