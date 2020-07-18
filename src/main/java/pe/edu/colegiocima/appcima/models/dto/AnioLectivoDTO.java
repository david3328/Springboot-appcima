package pe.edu.colegiocima.appcima.models.dto;

import io.swagger.annotations.ApiModel;
import lombok.Value;

@Value
@ApiModel(value = "AnioLectivo")
public class AnioLectivoDTO {
    private Short id;
    private String descripcion;
}
