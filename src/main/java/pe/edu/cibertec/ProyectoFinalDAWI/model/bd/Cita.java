package pe.edu.cibertec.ProyectoFinalDAWI.model.bd;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name="cita")
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idcita;
    @Column(name = "fechahoracita")
    private Date fechahoracita;
    @ManyToOne
    @JoinColumn(name = "idmascota")
    private Mascota mascota;
    @ManyToOne
    @JoinColumn(name = "idveterinario")
    private Veterinario veterinario;
}
