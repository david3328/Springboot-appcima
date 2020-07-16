package pe.edu.colegiocima.appcima.models.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "annolectivo")

public class AnioLectivo {
	
	private Short id;
	private String descripcion;
	private Date fechaInicio;
	private Date fechaFin;
	private Boolean activo;
	private String periodo;
	private String periodoActual;
	private Short idNivelColegio;
	private String tardanza;
	private Boolean admision;
	private int periodoBoleta;
	private String horalLlamada;
	
}
