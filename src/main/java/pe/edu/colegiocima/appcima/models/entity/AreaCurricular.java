package pe.edu.colegiocima.appcima.models.entity;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "areacurricular")
@ApiModel(description = "Todos los detalles del Área Curricular")
public class AreaCurricular {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;
    private String descripcion;
    private Short orden;
}
