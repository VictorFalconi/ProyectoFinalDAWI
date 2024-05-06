package pe.edu.cibertec.ProyectoFinalDAWI.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.ProyectoFinalDAWI.model.bd.Cliente;
import pe.edu.cibertec.ProyectoFinalDAWI.model.dto.request.ClienteRequest;
import pe.edu.cibertec.ProyectoFinalDAWI.model.dto.response.Response;
import pe.edu.cibertec.ProyectoFinalDAWI.service.IClienteService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/cliente")
public class ClienteController {
    private IClienteService iClienteService;

    @GetMapping("")
    public String formcliente(Model model) {
        model.addAttribute("listaClientes", iClienteService.listarClientes());
        return "formcliente";
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Cliente> listarClientes() {
        return iClienteService.listarClientes();
    }

    @PostMapping("/registrar")
    @ResponseBody
    public Response registrarCliente(@RequestBody ClienteRequest clienteRequest) {
        String mensaje = "Cliente registrado correctamente";
        boolean respuesta = true;
        try{
            Cliente cliente = new Cliente();
            if(clienteRequest.getIdcliente() > 0) {
                cliente.setIdcliente(clienteRequest.getIdcliente());
            }
            cliente.setNombrecliente(clienteRequest.getNombrecliente());
            cliente.setApellidocliente(clienteRequest.getApellidocliente());
            iClienteService.registrarCliente(cliente);
        }
        catch(Exception ex) {
            mensaje = ex.getMessage();
            respuesta = false;
        }
        return Response.builder().mensaje(mensaje).respuesta(respuesta).build();
    }
}
