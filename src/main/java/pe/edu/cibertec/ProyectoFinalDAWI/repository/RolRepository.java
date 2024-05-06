package pe.edu.cibertec.ProyectoFinalDAWI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.ProyectoFinalDAWI.model.bd.Rol;

@Repository
public interface RolRepository
        extends JpaRepository<Rol, Integer> {
    Rol findByNomrol(String nombrerol);
}
