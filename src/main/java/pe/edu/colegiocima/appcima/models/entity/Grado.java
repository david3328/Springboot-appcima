package pe.edu.colegiocima.appcima.models.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="grado")
public class Grado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 8)
    private String descripcion;

    @Column(name = "idnivelcolegio")
    private Integer idNivelColegio;

    @Column(name = "idgrado_ant")
    private Integer idGradoAnterior;

    @NotNull(message = "Debe existir la edad y mayor a cero")
    private int edad;

    @Column(name = "circuloestudio")
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
