package pe.edu.colegiocima.appcima.models.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="grado")
@ApiModel(description = "Todos los detalles de Grado Academico")
public class Grado{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 8)
    @ApiModelProperty(name = "Breve descripcion de grado con un máximo de 8 caracteres", notes = "Breve descripcion de grado con un máximo de 8 caracteres")
    private String descripcion;

    @Column(name = "idnivelcolegio")
    @ApiModelProperty(name = "Referencia del Nivel Colegio", notes = "Referencia del Nivel Colegio")
    private Integer idNivelColegio;

    @Column(name = "idgrado_ant")
    @ApiModelProperty(name = "Referencia del Grado Anterior", notes = "Referencia del Grado Anterior")
    private Integer idGradoAnterior;

    @NotNull(message = "Debe existir la edad y mayor a cero")
    @ApiModelProperty(name = "Edad establecido obligatoria", required = true, notes="Edad establecido obligatoria")
    private int edad;

    @Column(name = "circuloestudio")
    @NotNull(message = "Debe existir un valor para círculo de estudio")
    @ApiModelProperty(name = "Activado: cursos de un grupo de alumnos", required = true, notes = "Activado: cursos de un grupo de alumnos")
    private boolean circuloEstudio;

    public Grado() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getIdNivelColegio() {
        return idNivelColegio;
    }

    public void setIdNivelColegio(Integer idNivelColegio) {
        this.idNivelColegio = idNivelColegio;
    }

    public Integer getIdGradoAnterior() {
        return idGradoAnterior;
    }

    public void setIdGradoAnterior(Integer idGradoAnterior) {
        this.idGradoAnterior = idGradoAnterior;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isCirculoEstudio() {
        return circuloEstudio;
    }

    public void setCirculoEstudio(boolean circuloEstudio) {
        this.circuloEstudio = circuloEstudio;
    }
}
