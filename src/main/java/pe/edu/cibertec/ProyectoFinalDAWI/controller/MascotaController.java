package pe.edu.cibertec.ProyectoFinalDAWI.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.ProyectoFinalDAWI.model.bd.Cliente;
import pe.edu.cibertec.ProyectoFinalDAWI.model.bd.Mascota;
import pe.edu.cibertec.ProyectoFinalDAWI.model.dto.request.MascotaRequest;
import pe.edu.cibertec.ProyectoFinalDAWI.model.dto.response.Response;
import pe.edu.cibertec.ProyectoFinalDAWI.service.IMascotaService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/mascota")
public class MascotaController {
    private IMascotaService iMascotaService;

    @GetMapping("")
    public String formmascota(Model model){
        model.addAttribute("listaMascotas", iMascotaService.listarMascotas());
        return "formmascota";
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Mascota> listarMascotas(){
        return iMascotaService.listarMascotas();
    }

    @PostMapping("/registrar")
    @ResponseBody
    public Response registrarMascota(@RequestBody MascotaRequest mascotaRequest){
        String mensaje = "Mascota registrada correctamente";
        boolean respuesta = true;
        try{
            Mascota mascota = new Mascota();
            if(mascotaRequest.getIdmascota() > 0) {
                mascota.setIdmascota(mascotaRequest.getIdmascota());
            }
            mascota.setNombremascota(mascotaRequest.getNombremascota());
            mascota.setEdad(mascotaRequest.getEdad());
            Cliente cliente = new Cliente();
            cliente.setIdcliente(mascotaRequest.getIdcliente());
            mascota.setCliente(cliente);
            iMascotaService.registrarMascota(mascota);
        }
        catch(Exception ex) {
            mensaje = ex.getMessage();
            respuesta = false;
        }
        return Response.builder().mensaje(mensaje).respuesta(respuesta).build();
    }
}
