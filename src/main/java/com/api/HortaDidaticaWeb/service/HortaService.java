
package com.api.HortaDidaticaWeb.service;

import com.api.HortaDidaticaWeb.data.HortaEntity; 
import com.api.HortaDidaticaWeb.data.HortaRepository; 
import com.api.HortaDidaticaWeb.exception.ResourceNotFoundException;
import java.util.ArrayList;
import java.util.List; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 

@Service
public class HortaService {

    @Autowired
    
    HortaRepository hortaRepository;   
    
    public HortaEntity criarHorta(HortaEntity horta) { //CRIAR NOVA HORTA
        
        horta.setId(null); 
        hortaRepository.save(horta); 

        return horta; 
    }
        
     public HortaEntity getHortaId(Integer hortaId) { //RECUPERAR HORTA POR ID DA HORTA

        return hortaRepository.findById(hortaId).orElseThrow(() -> new ResourceNotFoundException("Horta não encontrado " + hortaId));

    }
     
    public HortaEntity atualizarHorta(Integer hortaId, HortaEntity hortaRequest) { //ATUALIZA A HORTA

        HortaEntity horta = getHortaId(hortaId); 

        horta.setNome(hortaRequest.getNome()); 

        horta.setEscola(hortaRequest.getEscola());
        
        hortaRepository.save(horta); 

        return horta; 

    }

    public List<HortaEntity> listarTodasHortas() { //LISTA TODAS AS HORTAS

        return hortaRepository.findAll(); 

    }
    
    public List<HortaEntity> listarHortasPorAdministrador(int idAdministrador) { //LISTA TODAS AS HORTAS POR ADM
        
        return hortaRepository.findByAdministrador(idAdministrador);
    
    }
    
    public List<HortaEntity> listarHortasPorUsuario(int usuarioAdm, String usuarioEscola) {
        // Passo 1: Buscar todas as hortas da escola do usuário
        List<HortaEntity> hortasPorEscola = hortaRepository.findByEscola(usuarioEscola);

        // Passo 2: Filtrar as hortas pelo administrador
        List<HortaEntity> hortasPorUsuario = new ArrayList<>();
        for (HortaEntity horta : hortasPorEscola) {
            if (horta.getAdministrador() == usuarioAdm) {
                hortasPorUsuario.add(horta);
            }
        }

        return hortasPorUsuario;
    }
    
    public void deletarHorta(Integer hortaId) { 

        HortaEntity horta = getHortaId(hortaId); 

        hortaRepository.deleteById(horta.getId()); 

    }
    
    
}
