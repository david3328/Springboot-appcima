package pe.edu.colegiocima.appcima.models.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "persona")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persona {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "dni")
    private String dni;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "fechanacimiento")
    private Date fechanacimiento;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "telefonosms")
    private String telefonosms;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "email")
    private String email;

    @Column(name = "sexo")
    private Boolean sexo;

    @Column(name = "fecharegistro")
    private Date fecharegistro;

    @Column(name = "observacion")
    private String observacion;

    @Column(name = "login")
    private String login;

    @Column(name = "pass")
    private String pass;

    @Column(name = "fichaunica")
    private Boolean fichaunica;

    @Column(name = "certificado")
    private Boolean certificado;

    @Column(name = "continua")
    private Boolean continua;

    @Column(name = "codigobanco")
    private String codigobanco;

    @Column(name = "iddistrito")
    private Short idDistrito;

    @Column(name = "idcolegio")
    private Long idColegio;

    @Column(name = "idusuario")
    private Short idUsuario;

    @Column(name = "documento")
    private Boolean documento;

    @Column(name = "perfil")
    private String perfil;

    @Column(name = "idestadosbs")
    private Long idestadosbs;

    @Column(name = "monto")
    private Short monto;

    @Column(name = "idreligion")
    private Long idreligion;


}
