
package com.api.HortaDidaticaWeb.data;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository;

public interface PlantaRepository extends JpaRepository<PlantaEntity, Integer>{
    
    List<PlantaEntity> findByPopularContainingIgnoreCaseOrGeneroContainingIgnoreCaseOrFamiliaContainingIgnoreCaseOrEpocaContainingIgnoreCaseOrIrrigacaoContainingIgnoreCaseOrIluminacaoContainingIgnoreCase(
            String popular, String genero, String familia,
            String epoca, String irrigacao, String iluminacao);
    
}
