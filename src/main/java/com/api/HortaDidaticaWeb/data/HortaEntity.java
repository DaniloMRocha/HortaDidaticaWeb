
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
@Table(name="horta")
public class HortaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotBlank(message = "O nome da horta deve ser preenchido")
    @Size(min=2, max=70, message="Informe 2 a 70 caracteres para o campo nome da horta")
    private String nome;
    @NotBlank(message = "Forneça a escola ou local aonde a horta se encontra")
    @Size(min=2, max=200, message="Informe 2 a 70 caracteres para o campo local da horta")
    private String escola;
    private int administrador; 
}
