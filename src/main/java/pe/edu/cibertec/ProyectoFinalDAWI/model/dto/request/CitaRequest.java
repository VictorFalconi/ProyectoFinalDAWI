package pe.edu.cibertec.ProyectoFinalDAWI.model.dto.request;

import lombok.Data;

import java.util.Date;

@Data
public class CitaRequest {
    private Integer idcita;
    private Date fechahoracita;
    private Integer idmascota;
    private Integer idveterinario;
}
