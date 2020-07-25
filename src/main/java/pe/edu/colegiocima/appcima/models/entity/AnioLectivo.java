package pe.edu.colegiocima.appcima.models.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Entity
@Table(name = "annolectivo")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Todos los detalles del Año Lectivo")
public class AnioLectivo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Short id;
	
	@ApiModelProperty(notes="Breve descripcion en texto ilimitado")
	private String descripcion;
	
	@Column(name = "fechainicio")
	@Temporal(TemporalType.DATE)
	private Date fechaInicio;
	
	@Column(name = "fechafin")
	@Temporal(TemporalType.DATE)
	private Date fechaFin;
	
	
	private Boolean activo;
	private String periodo;
	
	@Column(name = "periodoactual")
	@Size(max=2)
	private String periodoActual;
	
	@Column(name = "idnivelcolegio" )
	private Short idNivelColegio;
	
	private String tardanza;
	
	private Boolean admision;
	
	@Column(name = "periodoboleta" )
	@NotNull
	private int periodoBoleta;
	//private Integer periodoBoleta;
	
	@Column(name = "horalllamada" )
	private String horalLlamada;
	
	/*@PrePersist
	public void prePersistencia() {
		this.periodoBoleta = 0;
	}*/
	
}
