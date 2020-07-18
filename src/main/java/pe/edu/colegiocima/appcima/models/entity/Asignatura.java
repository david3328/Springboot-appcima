package pe.edu.colegiocima.appcima.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "asignatura")
@ApiModel(description = "Todos los detalles de la Asignatura")
public class Asignatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;
    @Size(max = 80)
    @NotNull
    @NotEmpty
    private String descripcion;
    @Size(max = 15)
    private String abreviatura;
    @Size(max = 15)
    private String horario;

    @JsonIgnoreProperties(value = {"asignatura"}, allowSetters = true)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "asignatura", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AreaAsignatura> areaAsignaturas;
}
