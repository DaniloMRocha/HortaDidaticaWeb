
package com.api.HortaDidaticaWeb.data;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository;

public interface HortaRepository extends JpaRepository<HortaEntity, Integer>{
    List<HortaEntity> findByAdministrador(int administrador);
    List<HortaEntity> findByEscola(String usuarioEscola);
}
