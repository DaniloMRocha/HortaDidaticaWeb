
package com.api.HortaDidaticaWeb.controller;

import com.api.HortaDidaticaWeb.data.CultivoEntity;
import com.api.HortaDidaticaWeb.data.HortaEntity; 
import com.api.HortaDidaticaWeb.data.HortaRepository;
import com.api.HortaDidaticaWeb.service.CultivoService;
import com.api.HortaDidaticaWeb.service.HortaService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid; 
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
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
public class HortaController { 
    @Autowired
    HortaService hortaService;
    
    @Autowired
    CultivoService cultivoService;

    @GetMapping("/horta")
    public String listarHortas(HttpSession session, Model model) {
               
        Integer administradorId = (Integer) session.getAttribute("administradorId");
        Integer usuarioId = (Integer) session.getAttribute("usuarioId");

        if (administradorId != null) {
            // Se um administrador estiver logado, recupere a lista de hortas por administrador
            List<HortaEntity> listarHortasPorAdministrador = hortaService.listarHortasPorAdministrador(administradorId);
            model.addAttribute("listarHortasPorAdministrador", listarHortasPorAdministrador);
            // Não exibir o formulário para administradores
            model.addAttribute("exibirFormulario", false); 

        } else {
            //Exibir formulário
            model.addAttribute("exibirFormulario", true);
        }

        if (usuarioId != null) {
            // Se um usuário estiver logado, recupere a lista de hortas por usuário
            Integer usuarioAdm = (Integer) session.getAttribute("usuarioAdm");
            String usuarioEscola = (String) session.getAttribute("usuarioEscola");
            List<HortaEntity> listarHortasPorUsuario = hortaService.listarHortasPorUsuario(usuarioAdm, usuarioEscola);
            model.addAttribute("listarHortasPorUsuario", listarHortasPorUsuario);
        }

        return "indexHorta";
    }
    
    @GetMapping("/deletarHorta/{id}") //http://localhost:8080/deletarHorta/n
    public String deletarUsuario(@PathVariable(value = "id") Integer id) { 
        hortaService.deletarHorta(id); 
        return "redirect:/horta"; 
    }
    
    @GetMapping("/inserirHortaForm") //http://localhost:8080/inserirHortaForm   //MÉTODO PARA MOSTRAR O FORMULÁRIO DE HORTA
    public String inserirHortaForm (Model model) { 
        HortaEntity horta = new HortaEntity(); 
        model.addAttribute("horta", horta); 
        return "inserirHortaForm"; 
    }

    @PostMapping("/salvarHorta") //http://localhost:8080/salvarHorta //MÉTODO PARA DE FATO SALVAR A HORTA
    public String salvarHorta(@Valid @ModelAttribute("horta") HortaEntity horta, BindingResult result, HttpSession session) {
        if (result.hasErrors()) {
            return "inserirHortaForm";
        }

        // Obtém o ID do administrador da sessão
        Integer administradorId = (Integer) session.getAttribute("administradorId");

        // Define o ID do administrador na horta
        horta.setAdministrador(administradorId);

        // Salva a horta
        if (horta.getId() == null) {
            hortaService.criarHorta(horta);
        } else {
            hortaService.atualizarHorta(horta.getId(), horta);
        }

        return "redirect:/horta";
    }

    @GetMapping("/atualizarHortaForm/{id}") //http://localhost:8080/atualizarHortaForm/n
    public String atualizarHortaForm(@PathVariable(value = "id") Integer id, Model model) { 
        HortaEntity horta = hortaService.getHortaId(id); 
        model.addAttribute("horta", horta); 
        return "atualizarHorta"; 
    }
                
}
