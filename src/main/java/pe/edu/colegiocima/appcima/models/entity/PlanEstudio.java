package pe.edu.colegiocima.appcima.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "planestudio")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel()
public class PlanEstudio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;

    @Column(name="fechacreacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;


    private Short horas;

    @JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idannolectivo")
    private AnioLectivo anioLectivo;

    @JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idgrado")
    private Grado grado;

    @JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idareaasignatura")
    private AreaAsignatura areaAsignatura;

    @PrePersist
    public void prePersist(){
        this.fechaCreacion = new Date();
    }
}
