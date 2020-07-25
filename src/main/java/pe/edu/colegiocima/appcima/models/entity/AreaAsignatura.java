package pe.edu.colegiocima.appcima.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "areaasignatura")
@ApiModel(description = "Todos los detalles de Area Asignatura")
public class AreaAsignatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;

    @JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer"})
    @ManyToOne(fetch =FetchType.LAZY)
    @JoinColumn(name = "idareacurricular")
    private AreaCurricular areaCurricular;

    @JsonIgnoreProperties(value = {"areaAsignaturas","handler","hibernateLazyInitializer"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idasignatura")
    private Asignatura asignatura;
}
