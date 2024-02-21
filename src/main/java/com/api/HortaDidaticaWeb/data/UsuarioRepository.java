
package com.api.HortaDidaticaWeb.data;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer>{
    Optional<UsuarioEntity> findByUsername(String username);
    UsuarioEntity findByUsernameAndSenha(String username, String senha);
}
