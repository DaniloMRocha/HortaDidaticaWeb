
package com.api.HortaDidaticaWeb.data;

import jakarta.persistence.Entity; 
import jakarta.persistence.GeneratedValue; 
import jakarta.persistence.GenerationType; 
import jakarta.persistence.Id; 
import jakarta.persistence.Table; 
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data 
@Entity 
@Table(name="usuario") 
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotBlank(message = "O nome do usuário é obrigatório")
    @Size(min=2, max=70, message="Informe 2 a 70 caracteres para o campo título")
    private String nome;
    @NotBlank(message = "A função do usuário (professor, estudante ou técnico) deve ser preenchida")
    @Size(min=2, max=200, message="Informe 2 a 70 caracteres para o campo função")
    private String funcao;
    @NotBlank(message = "Forneça a sua escola")
    @Size(min=2, max=70, message="Informe 2 a 70 caracteres para o campo escola")
    private String escola;
    private String grupo;
    @NotBlank(message = "Forneça um nome para login")
    @Size(min=2, max=70, message="Informe 2 a 70 caracteres para o campo usuário")
    private String username;
    @NotBlank(message = "A senha é obrigatória")
    @Size(min=2, max=70, message="Informe 2 a 70 caracteres para o campo senha")
    private String senha;
    private Integer administrador;
}
