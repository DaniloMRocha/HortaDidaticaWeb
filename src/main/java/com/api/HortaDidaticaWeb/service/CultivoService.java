
package com.api.HortaDidaticaWeb.service;

import com.api.HortaDidaticaWeb.data.CultivoEntity; 
import com.api.HortaDidaticaWeb.data.CultivoRepository; 
import com.api.HortaDidaticaWeb.exception.ResourceNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 

@Service
public class CultivoService {
    
    @Autowired
    
    CultivoRepository cultivoRepository;
    
    public CultivoEntity criarCultivo(CultivoEntity cultivo) { //CRIAR NOVO CULTIVO
        
        cultivo.setId(null); 
        cultivoRepository.save(cultivo); 

        return cultivo; 
    }
    
    public CultivoEntity getCultivoId(Integer cultivoId) { //RECUPERAR CULTIVO POR ID

        return cultivoRepository.findById(cultivoId).orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado " + cultivoId));

    } 
    
    public CultivoEntity atualizarCultivo(Integer cultivoId, CultivoEntity cultivoRequest) { //ATUALIZA O CULTIVO

        CultivoEntity cultivo = getCultivoId(cultivoId); 

        cultivo.setPlanta(cultivoRequest.getPlanta()); 

        cultivo.setPlantio(cultivoRequest.getPlantio());
        
        cultivo.setPrevisto(cultivoRequest.getPrevisto());
        
        cultivo.setColheita(cultivoRequest.getColheita());
        
        cultivo.setObs(cultivoRequest.getObs()); 

        cultivo.setAcompanhamento(cultivoRequest.getAcompanhamento()); 

        cultivoRepository.save(cultivo); 

        return cultivo; 

    }
    
    public List<CultivoEntity> listarCultivosPorHorta(Integer hortaId) {
        
        return cultivoRepository.findByHorta(hortaId);
        
    }
    
    public List<CultivoEntity> listarTodosCultivos() { //LISTA TODOS OS USUÁRIOS

        return cultivoRepository.findAll(); 

    }
    
    public void deletarCultivo(Integer cultivoId) { 

        CultivoEntity cultivo = getCultivoId(cultivoId); 

        cultivoRepository.deleteById(cultivo.getId()); 

    }
    
}
