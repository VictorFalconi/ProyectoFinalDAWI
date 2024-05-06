package pe.edu.cibertec.ProyectoFinalDAWI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.ProyectoFinalDAWI.model.bd.Veterinario;

@Repository
public interface VeterinarioRepository
        extends JpaRepository<Veterinario, Integer> {
}
