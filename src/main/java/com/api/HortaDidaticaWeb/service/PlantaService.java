
package com.api.HortaDidaticaWeb.service;

import com.api.HortaDidaticaWeb.data.PlantaEntity; 
import com.api.HortaDidaticaWeb.data.PlantaRepository; 
import com.api.HortaDidaticaWeb.exception.ResourceNotFoundException;
import java.util.ArrayList;
import org.springframework.transaction.annotation.Transactional;
import java.util.List; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 

@Service
public class PlantaService {

    @Autowired
    
    PlantaRepository plantaRepository;
    
    public PlantaEntity criarPlanta(PlantaEntity planta) { //CRIAR NOVO USUÁRIO
        
        planta.setId(null); 
        plantaRepository.save(planta); 

        return planta; 
    }
    
    public PlantaEntity getPlantaId(Integer plantaId) { //RECUPERAR USUÁRIO POR ID

        return plantaRepository.findById(plantaId).orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado " + plantaId));

    } 
        
    public List<PlantaEntity> listarTodasPlantas() { //LISTA TODOS

        return plantaRepository.findAll(); 

    }
}
  
