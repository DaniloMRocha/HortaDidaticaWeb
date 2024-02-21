
package com.api.HortaDidaticaWeb.service;

import com.api.HortaDidaticaWeb.data.UsuarioEntity; 
import com.api.HortaDidaticaWeb.data.UsuarioRepository; 
import com.api.HortaDidaticaWeb.exception.ResourceNotFoundException;
import java.util.List; 
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 

@Service
public class UsuarioService {

    @Autowired
    
    UsuarioRepository usuarioRepository;
    
    public UsuarioEntity criarUsuario(UsuarioEntity usuario) { //CRIAR NOVO USUÁRIO
        
        usuario.setId(null); 
        usuarioRepository.save(usuario); 

        return usuario; 
    }
    
    public UsuarioEntity getUsuarioId(Integer usuarioId) { //RECUPERAR USUÁRIO POR ID

        return usuarioRepository.findById(usuarioId).orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado " + usuarioId));

    } 
    
    public UsuarioEntity atualizarUsuario(Integer usuarioId, UsuarioEntity usuarioRequest) { //ATUALIZA O USUÁRIO

        UsuarioEntity usuario = getUsuarioId(usuarioId); 

        usuario.setNome(usuarioRequest.getNome()); 

        usuario.setFuncao(usuarioRequest.getFuncao());
        
        usuario.setEscola(usuarioRequest.getEscola());
        
        usuario.setGrupo(usuarioRequest.getGrupo());
        
        usuario.setUsername(usuarioRequest.getUsername()); 

        usuario.setSenha(usuarioRequest.getSenha()); 

        usuarioRepository.save(usuario); 

        return usuario; 

    }
    
    public List<UsuarioEntity> listarTodosUsuarios() { //LISTA TODOS OS USUÁRIOS

        return usuarioRepository.findAll(); 

    }
    
    public void deletarUsuario(Integer usuarioId) { 

        UsuarioEntity usuario = getUsuarioId(usuarioId); 

        usuarioRepository.deleteById(usuario.getId()); 

    }
    
    public UsuarioEntity autenticarUsuario(String username, String senha) {
        
        return usuarioRepository.findByUsernameAndSenha(username, senha);
        
    }
}
