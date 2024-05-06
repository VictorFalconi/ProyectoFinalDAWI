package pe.edu.cibertec.ProyectoFinalDAWI.model.bd;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="veterinario")
public class Veterinario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idveterinario;
    @Column(name = "nombreveterinario")
    private String nombreveterinario;
    @Column(name = "apellidoveterinario")
    private String apellidoveterinario;
}
