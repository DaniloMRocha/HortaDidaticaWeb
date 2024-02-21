
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
@Table(name="administrador")
public class AdministradorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotBlank(message = "Forneça seu nome de usuário")
    @Size(min=2, max=70, message="Informe 2 a 70 caracteres para o campo escola")
    private String username;
    @NotBlank(message = "A senha é obrigatória")
    @Size(min=2, max=70, message="Informe 2 a 70 caracteres para o campo senha")
    private String senha;  
}
