
package com.api.HortaDidaticaWeb.controller;

import com.api.HortaDidaticaWeb.data.CultivoEntity; 
import com.api.HortaDidaticaWeb.data.CultivoRepository;
import com.api.HortaDidaticaWeb.service.CultivoService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid; 
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CultivoController {
    @Autowired
    CultivoService cultivoService;
    
    @Autowired
    HttpSession httpSession;
    
    @GetMapping("/cultivo")
    public String redirecionarParaIndexCultivo(@RequestParam(name = "hortaId") Integer hortaId, 
                                               @RequestParam(name = "hortaNome") String hortaNome, 
                                               Model model, 
                                               RedirectAttributes redirectAttributes) {
        model.addAttribute("hortaId", hortaId);
        model.addAttribute("hortaNome", hortaNome);
            
        // Verifica se um hortaId foi fornecido e lista apenas os cultivos relacionados a essa horta
        List<CultivoEntity> cultivos;
        if (hortaId != null) {
            cultivos = cultivoService.listarCultivosPorHorta(hortaId);
        } else {
            // Se nenhum hortaId foi fornecido, atribui uma lista vazia
            cultivos = Collections.emptyList();
            }
        model.addAttribute("listarTodosCultivos", cultivos);
            
        CultivoEntity cultivo = new CultivoEntity(); 
        model.addAttribute("cultivo", cultivo);
        
        if (hortaId != null) {
            redirectAttributes.addFlashAttribute("hortaId", hortaId);
            redirectAttributes.addFlashAttribute("hortaNome", hortaNome);
        }
        return "indexCultivo";
        } 

    @PostMapping("/salvarCultivo") //http://localhost:8080/salvarCultivo
    public String salvarCultivo(@Valid @ModelAttribute("cultivo") CultivoEntity cultivo, 
                                 BindingResult result,
                                 @RequestParam(name = "hortaId") Integer hortaId,
                                 @RequestParam(name = "hortaNome") String hortaNome,
                                 Model model,
                                 RedirectAttributes redirectAttributes) {

        
        cultivo.setHorta(hortaId);
        if (cultivo.getId() == null) {
            cultivoService.criarCultivo(cultivo);
        } else {
            cultivoService.atualizarCultivo(cultivo.getId(), cultivo);
        }

        redirectAttributes.addAttribute("hortaId", hortaId);
        redirectAttributes.addAttribute("hortaNome", hortaNome);

        return "redirect:/cultivo";
        
        }
      
    @GetMapping("/deletarCultivo/{id}") //http://localhost:8080/deletarCultivo/n
    public String deletarCultivo(@PathVariable(value = "id") Integer id,
                                 @RequestParam(name = "hortaId") Integer hortaId,
                                 @RequestParam(name = "hortaNome") String hortaNome,
                                 Model model,
                                 RedirectAttributes redirectAttributes) { 

        
        cultivoService.deletarCultivo(id);
        
        model.addAttribute("hortaId", hortaId);
        model.addAttribute("hortaNome", hortaNome);
        
        redirectAttributes.addAttribute("hortaId", hortaId);
        redirectAttributes.addAttribute("hortaNome", hortaNome);
        
        
        return "redirect:/cultivo";
        //return "redirect:/cultivo?hortaId=" + hortaId + "&hortaNome=" + hortaNome;
    } 
    
    @GetMapping("/acompanharCultivo/{id}") //http://localhost:8080/acompanharCultivoForm/n
    public String acompanharCultivo(@PathVariable(value = "id") Integer id, Model model,
                                    @RequestParam(name = "hortaId") Integer hortaId,
                                    @RequestParam(name = "hortaNome") String hortaNome,
                                    RedirectAttributes redirectAttributes) { 
        
        model.addAttribute("hortaId", hortaId);
        model.addAttribute("hortaNome", hortaNome);
        
        CultivoEntity cultivo = cultivoService.getCultivoId(id); 
        model.addAttribute("cultivo", cultivo);
        
        redirectAttributes.addFlashAttribute("hortaId", hortaId);
        redirectAttributes.addFlashAttribute("hortaNome", hortaNome);
        
        return "acompanharCultivo";
    }
}
