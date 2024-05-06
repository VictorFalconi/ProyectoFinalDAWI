package pe.edu.cibertec.ProyectoFinalDAWI.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.ProyectoFinalDAWI.model.bd.Mascota;
import pe.edu.cibertec.ProyectoFinalDAWI.repository.MascotaRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class MascotaService implements IMascotaService{
    private MascotaRepository mascotaRepository;

    @Override
    public List<Mascota> listarMascotas() {
        return mascotaRepository.findAll();
    }

    @Override
    public void registrarMascota(Mascota mascota) {
        mascotaRepository.save(mascota);
    }
}
