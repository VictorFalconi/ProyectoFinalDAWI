package pe.edu.cibertec.ProyectoFinalDAWI.model.bd;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="mascota")
public class Mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idmascota;
    @Column(name = "nombremascota")
    private String nombremascota;
    @Column(name = "edad")
    private Integer edad;
    @ManyToOne
    @JoinColumn(name = "idcliente")
    private Cliente cliente;
}
