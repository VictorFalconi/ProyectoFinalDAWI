package pe.edu.cibertec.ProyectoFinalDAWI.model.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response {
    private Boolean respuesta;
    private String mensaje;
}
