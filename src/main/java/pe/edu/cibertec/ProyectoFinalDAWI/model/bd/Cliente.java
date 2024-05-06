package pe.edu.cibertec.ProyectoFinalDAWI.model.bd;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idcliente;
    @Column(name = "nombrecliente")
    private String nombrecliente;
    @Column(name = "apellidocliente")
    private String apellidocliente;
}
