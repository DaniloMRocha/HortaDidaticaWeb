
package com.api.HortaDidaticaWeb.controller;

import com.api.HortaDidaticaWeb.data.PlantaEntity; 
import com.api.HortaDidaticaWeb.data.PlantaRepository;
import com.api.HortaDidaticaWeb.service.PlantaService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid; 
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model; 
import org.springframework.validation.BindingResult; 
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.ModelAttribute; 
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;

@Controller
public class PlantaController {
@Autowired
    PlantaService plantaService;
    
    @Autowired
    HttpSession httpSession;
    
    @GetMapping("/planta") // http://localhost:8080/planta
    public String viewPlantaPage(Model model) {
        List<PlantaEntity> listaPlantas = plantaService.listarTodasPlantas();
        model.addAttribute("listaPlantas", listaPlantas);
        return "indexPlanta";
    }
    
    
    
    @GetMapping("/inserirPlantaForm") //http://localhost:8080/inserirPlanta
    public String inserirPlantaForm (Model model) { 
        PlantaEntity planta = new PlantaEntity(); 
        model.addAttribute("planta", planta); 
        return "inserirPlantaForm"; 
    }

    @PostMapping("/salvarPlantaGeral") // http://localhost:8080/salvarPlanta
    public String salvarPlanta(@Valid @ModelAttribute("planta") PlantaEntity planta, BindingResult result) {
        if (result.hasErrors()) {
            return "inserirPlantaForm";
        }
        Integer administradorId = (Integer) httpSession.getAttribute("administradorId");
        planta.setAdministrador(administradorId);
        if (planta.getId() == null) {
            plantaService.criarPlanta(planta);
        }
        
        return "redirect:/planta";
    }

    @GetMapping("/atualizarPlantaForm/{id}") //http://localhost:8080/atualizarPlantaForm/n
    public String atualizarPlantaForm(@PathVariable(value = "id") Integer id, Model model) { 
        PlantaEntity planta = plantaService.getPlantaId(id); 
        model.addAttribute("planta", planta); 
        return "atualizarPlanta"; 
    }
    
    @GetMapping("/infoPlanta/{id}")
        public String infoCultivo(@PathVariable(value = "id") Integer id, Model model) { 
        PlantaEntity planta = plantaService.getPlantaId(id); 
        model.addAttribute("planta", planta); 
        return "infoPlanta"; 
    }

}
