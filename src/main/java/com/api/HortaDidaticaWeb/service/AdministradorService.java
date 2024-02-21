/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.HortaDidaticaWeb.service;

import com.api.HortaDidaticaWeb.data.AdministradorEntity; 
import com.api.HortaDidaticaWeb.data.AdministradorRepository; 
import com.api.HortaDidaticaWeb.exception.ResourceNotFoundException;
import java.util.List; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 

@Service
public class AdministradorService {
    @Autowired
    
    AdministradorRepository administradorRepository;
    
    public AdministradorEntity criarAdministrador(AdministradorEntity adm) { //CRIAR NOVO ADM
        
        adm.setId(null); 
        administradorRepository.save(adm); 

        return adm; 
    }
    
    public AdministradorEntity getAdministradorId(Integer usuarioId) { //RECUPERAR ADM POR ID

        return administradorRepository.findById(usuarioId).orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado " + usuarioId));

    } 
    
    public Integer autenticarAdministrador(String username, String senha) {
        
        AdministradorEntity administrador = administradorRepository.findByUsernameAndSenha(username, senha);

        if (administrador != null) {
            return administrador.getId();
        } else {
            return null; // Retorna null se a autenticação falhar
        }
    }
}
