
package com.api.HortaDidaticaWeb.data;

import jakarta.persistence.Entity; 
import jakarta.persistence.GeneratedValue; 
import jakarta.persistence.GenerationType; 
import jakarta.persistence.Id; 
import jakarta.persistence.Lob;
import jakarta.persistence.Table; 
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data 
@Entity 
@Table(name="planta") 
public class PlantaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotBlank(message = "O nome popular da planta é obrigatório!")
    @Size(min=2, max=70, message="Informe 2 a 70 caracteres para o campo planta")
    private String popular;
    @Size(max=70, message="Máximo de 70 caracteres!")
    private String genero;
    @Size(max=70, message="Máximo de 70 caracteres!")
    private String epiteto;
    @Size(max=70, message="Máximo de 70 caracteres!")
    private String familia;
    @Size(max=70, message="Máximo de 70 caracteres!")
    private String epoca; //Inverno, Primavera, Verão ou Outono
    private Integer tempo; //EM DIAS
    @Size(max=70, message="Máximo de 70 caracteres!")
    private String irrigacao; // Pouca, Média ou Muita
    @Size(max=70, message="Máximo de 70 caracteres!")
    private String iluminacao; // Sombra ou Sol
    @Size(max=70, message="Máximo de 1000 caracteres!")
    private String didatico;
    private Integer administrador;
    @Lob
    private byte[] tag;
    @Lob
    private byte[] foto;    
}
