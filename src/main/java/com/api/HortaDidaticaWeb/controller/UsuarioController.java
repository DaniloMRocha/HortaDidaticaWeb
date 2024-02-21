
package com.api.HortaDidaticaWeb.controller;

import com.api.HortaDidaticaWeb.data.UsuarioEntity; 
import com.api.HortaDidaticaWeb.data.UsuarioRepository;
import com.api.HortaDidaticaWeb.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid; 
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
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;
    
    @Autowired
    HttpSession httpSession;
    
    @GetMapping("/usuario") //http://localhost:8080/usuario
    public String viewUsuarioPage(HttpSession session, Model model) { 
        Integer administradorId = (Integer) session.getAttribute("administradorId");
        model.addAttribute("administradorId", administradorId);
        model.addAttribute("listarTodosUsuarios", usuarioService.listarTodosUsuarios()); 
    return "indexUsuario"; 
    } 
    
    @GetMapping("/deletarUsuario/{id}") //http://localhost:8080/deletarUsuario/n
    public String deletarUsuario(@PathVariable(value = "id") Integer id) { 
        usuarioService.deletarUsuario(id); 
        return "redirect:/usuario"; 
    }    
    
    @GetMapping("/inserirUsuarioForm") //http://localhost:8080/inserirUsuario   //MÉTODO PARA MOSTRAR O FORMULÁRIO DE USUARIO
    public String inserirUsuarioForm (Model model) { 
        UsuarioEntity usuario = new UsuarioEntity(); 
        model.addAttribute("usuario", usuario); 
        return "inserirUsuarioForm"; 
    }

    @PostMapping("/salvarUsuario") // http://localhost:8080/salvarUsuario //MÉTODO PARA DE FATO SALVAR O USUARIO
    public String salvarUsuario(@Valid @ModelAttribute("usuario") UsuarioEntity usuario, BindingResult result) {
        if (result.hasErrors()) {
            return "inserirUsuarioForm";
        }
        Integer administradorId = (Integer) httpSession.getAttribute("administradorId");
        usuario.setAdministrador(administradorId);
        if (usuario.getId() == null) {
            usuarioService.criarUsuario(usuario);
        } else {
            usuarioService.atualizarUsuario(usuario.getId(), usuario);
        }
        return "redirect:/usuario";
    }

    @GetMapping("/atualizarUsuarioForm/{id}") //http://localhost:8080/atualizarUsuarioForm/n
    public String atualizarUsuarioForm(@PathVariable(value = "id") Integer id, Model model) { 
        UsuarioEntity usuario = usuarioService.getUsuarioId(id); 
        model.addAttribute("usuario", usuario); 
        return "atualizarUsuario"; 
    }
    
    @PostMapping("/loginUsuario")
    public String loginUsuario(@RequestParam String username, @RequestParam String senha, HttpSession session) {
        UsuarioEntity usuario = usuarioService.autenticarUsuario(username, senha);
        if (usuario != null) {
            // Login bem-sucedido, armazenar informações do usuário na sessão
            session.setAttribute("usuarioId", usuario.getId());
            session.setAttribute("usuarioNome", usuario.getNome());
            session.setAttribute("usuarioEscola", usuario.getEscola());
            session.setAttribute("usuarioAdm", usuario.getAdministrador());
            return "redirect:/horta";
        } else {
            // Autenticação falhou, redirecionar de volta para a página de login com uma mensagem de erro
            session.removeAttribute("usuarioId");
            session.removeAttribute("usuarioNome");
            session.removeAttribute("usuarioEscola");
            session.removeAttribute("usuarioAdm");
            return "redirect:/horta";
        }
    }
    
    @PostMapping("/logoutUsuario")
    public String logout(HttpSession session) {
        session.removeAttribute("usuarioId");
        session.removeAttribute("usuarioNome");
        session.removeAttribute("usuarioEscola");
        session.removeAttribute("usuarioAdm");
        return "redirect:/";
    }
    
}
