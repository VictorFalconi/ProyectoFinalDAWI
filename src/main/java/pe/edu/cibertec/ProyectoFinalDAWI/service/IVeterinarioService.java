package pe.edu.cibertec.ProyectoFinalDAWI.service;

import pe.edu.cibertec.ProyectoFinalDAWI.model.bd.Veterinario;

import java.util.List;

public interface IVeterinarioService {
    List<Veterinario> listarVeterinarios();
    void registrarVeterinario(Veterinario veterinario);
}
