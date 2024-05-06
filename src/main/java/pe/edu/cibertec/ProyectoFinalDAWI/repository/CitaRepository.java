package pe.edu.cibertec.ProyectoFinalDAWI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.ProyectoFinalDAWI.model.bd.Cita;

@Repository
public interface CitaRepository
        extends JpaRepository<Cita, Integer> {
}
