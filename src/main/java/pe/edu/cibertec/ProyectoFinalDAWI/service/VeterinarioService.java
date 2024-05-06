package pe.edu.cibertec.ProyectoFinalDAWI.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.ProyectoFinalDAWI.model.bd.Veterinario;
import pe.edu.cibertec.ProyectoFinalDAWI.repository.VeterinarioRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class VeterinarioService implements IVeterinarioService{
    private VeterinarioRepository veterinarioRepository;

    @Override
    public List<Veterinario> listarVeterinarios() {
        return veterinarioRepository.findAll();
    }

    @Override
    public void registrarVeterinario(Veterinario veterinario) {
        veterinarioRepository.save(veterinario);
    }
}
