package pe.edu.cibertec.ProyectoFinalDAWI.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.edu.cibertec.ProyectoFinalDAWI.model.bd.Usuario;
import pe.edu.cibertec.ProyectoFinalDAWI.model.security.UsuarioSecurity;
import pe.edu.cibertec.ProyectoFinalDAWI.service.UsuarioService;

@AllArgsConstructor
@Controller
@RequestMapping("/auth")
public class LoginController {

    private UsuarioService usuarioService;

    @GetMapping("/login")
    public String login(HttpServletRequest request){
        return "auth/frmLogin";
    }

    @GetMapping("/registrar")
    public String registrar(){
        return "auth/frmRegistroUsuario";
    }

    @GetMapping("/login-success")
    public String loginSucces(){
        return "redirect:/auth/dashboard";
    }

    @PostMapping("/guardarUsuario")
    public String guardarUsuario(@ModelAttribute Usuario usuarioModel){
        usuarioService.saveUser(usuarioModel);
        return "auth/frmLogin";
    }

    @GetMapping("/dashboard")
    public String dashboard(HttpServletRequest request) {
        HttpSession session = request.getSession();
        // Obtén el objeto UserDetails del contexto de seguridad
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        // Convierte el UserDetails a tu clase Usuario
        UsuarioSecurity usuario = (UsuarioSecurity) userDetails;
        // Ahora puedes acceder a los atributos específicos de tu clase Usuario
        String nomusuario = usuario.getNomusuario();
        // Realiza cualquier otra operación que necesites con el objeto Usuario
        session.setAttribute("usuario", nomusuario);
        return "auth/home"; // Return the dashboard page
    }
}
