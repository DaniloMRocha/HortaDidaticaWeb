package com.api.HortaDidaticaWeb.data;

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository;

public interface AdministradorRepository extends JpaRepository<AdministradorEntity, Integer>{
    AdministradorEntity findByUsernameAndSenha(String username, String senha);    
}
