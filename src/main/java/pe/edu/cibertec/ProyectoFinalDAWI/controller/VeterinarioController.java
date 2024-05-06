package pe.edu.cibertec.ProyectoFinalDAWI.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.ProyectoFinalDAWI.model.bd.Veterinario;
import pe.edu.cibertec.ProyectoFinalDAWI.model.dto.request.VeterinarioRequest;
import pe.edu.cibertec.ProyectoFinalDAWI.model.dto.response.Response;
import pe.edu.cibertec.ProyectoFinalDAWI.service.IVeterinarioService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/veterinario")
public class VeterinarioController {
    private IVeterinarioService iVeterinarioService;

    @GetMapping("")
    public String formveterinario(Model model){
        model.addAttribute("listaVeterinarios", iVeterinarioService.listarVeterinarios());
        return "formveterinario";
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Veterinario> listarVeterinarios() {
        return iVeterinarioService.listarVeterinarios();
    }

    @PostMapping("/registrar")
    @ResponseBody
    public Response registrarVeterinario(@RequestBody VeterinarioRequest veterinarioRequest){
        String mensaje = "Veterinario registrado correctamente";
        boolean respuesta = true;
        try{
            Veterinario veterinario = new Veterinario();
            if(veterinarioRequest.getIdveterinario() > 0){
                veterinario.setIdveterinario(veterinarioRequest.getIdveterinario());
            }
            veterinario.setNombreveterinario(veterinarioRequest.getNombreveterinario());
            veterinario.setApellidoveterinario(veterinarioRequest.getApellidoveterinario());
            iVeterinarioService.registrarVeterinario(veterinario);
        }
        catch(Exception ex) {
            mensaje = ex.getMessage();
            respuesta = false;
        }
        return Response.builder().mensaje(mensaje).respuesta(respuesta).build();
    }
}
