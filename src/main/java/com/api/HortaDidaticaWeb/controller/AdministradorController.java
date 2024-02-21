
package com.api.HortaDidaticaWeb.controller;

import com.api.HortaDidaticaWeb.data.AdministradorEntity; 
import com.api.HortaDidaticaWeb.service.AdministradorService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model; 
import org.springframework.validation.BindingResult; 
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.ModelAttribute; 
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdministradorController {
    @Autowired
    AdministradorService administradorService;
 
    @GetMapping("/inserirAdministradorForm") //http://localhost:8080/inserirAdministradorForm   //MÉTODO PARA MOSTRAR O FORMULÁRIO DE ADM
    public String inserirAdministradorForm (Model model) { 
        AdministradorEntity administrador= new AdministradorEntity(); 
        model.addAttribute("administrador", administrador); 
        return "inserirAdministradorForm"; 
    }

    @PostMapping("/salvarAdministrador") //http://localhost:8080/salvarAdministrador //MÉTODO PARA DE FATO SALVAR O ADM
    public String salvarAdministrador(@Valid @ModelAttribute("administrador") AdministradorEntity administrador, BindingResult result) { 
        if (result.hasErrors()) { 
            return "inserirAdministradorForm"; 
        } else { 
            administradorService.criarAdministrador(administrador); 
        }
    return "redirect:/"; 
    }
    
    @PostMapping("/login")
    public String loginAdministrador(@RequestParam String username, @RequestParam String senha, HttpSession session) {
    Integer administradorId = administradorService.autenticarAdministrador(username, senha);
    if (administradorId != null) {
        // Login bem-sucedido, redirecionr para index
        session.setAttribute("administradorId", administradorId);
        return "redirect:/";
    } else {
        // Autenticação falhou, redirecione de volta para a página de login com uma mensagem de erro
        session.removeAttribute("administradorId");
        return "redirect:/?error=1";
    } 
}

    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("administradorId");
        return "redirect:/";
    }
    
}
