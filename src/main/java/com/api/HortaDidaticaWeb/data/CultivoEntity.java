
package com.api.HortaDidaticaWeb.data;

import jakarta.persistence.Entity; 
import jakarta.persistence.GeneratedValue; 
import jakarta.persistence.GenerationType; 
import jakarta.persistence.Id; 
import jakarta.persistence.Table; 
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.sql.Date;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data 
@Entity 
@Table(name="cultivo") 
public class CultivoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotBlank(message = "O nome da planta cultivada é obrigatório!")
    @Size(min=2, max=70, message="Informe 2 a 70 caracteres para o campo planta")
    private String planta;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date plantio;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date previsto;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date colheita;
    @Size(max=70, message="O campo de observação não pode ter mais que 400 caracteres!")
    private String obs;
    @Size(max=1000, message="O campo acompanhamento não pode ter mais que 1000 caracteres!")
    private String acompanhamento;
    private Integer horta;
}
