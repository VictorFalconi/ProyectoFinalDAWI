package pe.edu.cibertec.ProyectoFinalDAWI.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.ProyectoFinalDAWI.model.bd.Cita;
import pe.edu.cibertec.ProyectoFinalDAWI.model.bd.Mascota;
import pe.edu.cibertec.ProyectoFinalDAWI.model.bd.Veterinario;
import pe.edu.cibertec.ProyectoFinalDAWI.model.dto.request.CitaRequest;
import pe.edu.cibertec.ProyectoFinalDAWI.model.dto.response.Response;
import pe.edu.cibertec.ProyectoFinalDAWI.service.ICitaService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/cita")
public class CitaController {
    private ICitaService iCitaService;

    @GetMapping("")
    public String formcita(Model model) {
        model.addAttribute("listaCitas", iCitaService.listarCitas());
        return "formcita";
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Cita> listarCitas() {
        return iCitaService.listarCitas();
    }

    @PostMapping("/registrar")
    @ResponseBody
    public Response registrarCita(@RequestBody CitaRequest citaRequest) {
        String mensaje = "Cita registrada correctamente";
        boolean respuesta = true;
        try{
            Cita cita = new Cita();
            if(citaRequest.getIdcita() > 0) {
                cita.setIdcita(citaRequest.getIdcita());
            }
            cita.setFechahoracita(citaRequest.getFechahoracita());
            Mascota mascota = new Mascota();
            mascota.setIdmascota(citaRequest.getIdmascota());
            cita.setMascota(mascota);
            Veterinario veterinario = new Veterinario();
            veterinario.setIdveterinario(citaRequest.getIdveterinario());
            cita.setVeterinario(veterinario);
            iCitaService.registrarCita(cita);
        }
        catch(Exception ex) {
            mensaje = ex.getMessage();
            respuesta = false;
        }
        return Response.builder().mensaje(mensaje).respuesta(respuesta).build();
    }
}
