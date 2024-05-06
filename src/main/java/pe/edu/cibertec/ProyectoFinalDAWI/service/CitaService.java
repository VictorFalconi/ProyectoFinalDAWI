package pe.edu.cibertec.ProyectoFinalDAWI.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.ProyectoFinalDAWI.model.bd.Cita;
import pe.edu.cibertec.ProyectoFinalDAWI.repository.CitaRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class CitaService implements ICitaService{
    private CitaRepository citaRepository;

    @Override
    public List<Cita> listarCitas() {
        return citaRepository.findAll();
    }

    @Override
    public void registrarCita(Cita cita) {
        citaRepository.save(cita);
    }
}
