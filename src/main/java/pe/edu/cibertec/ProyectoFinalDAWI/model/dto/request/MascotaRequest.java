package pe.edu.cibertec.ProyectoFinalDAWI.model.dto.request;

import lombok.Data;

@Data
public class MascotaRequest {
    private Integer idmascota;
    private String nombremascota;
    private Integer edad;
    private Integer idcliente;
}
