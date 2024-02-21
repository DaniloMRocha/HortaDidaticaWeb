
package com.api.HortaDidaticaWeb.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GeneralController {
    
    @GetMapping("/") //http://localhost:8080/
    public String mostrarInicial(HttpSession session, Model model) {
        Integer administradorId = (Integer) session.getAttribute("administradorId");
        model.addAttribute("administradorId", administradorId);
        Integer usuarioId = (Integer) session.getAttribute("usuarioId");
        model.addAttribute("usuarioId", usuarioId);
        return "index"; 
    }

}
