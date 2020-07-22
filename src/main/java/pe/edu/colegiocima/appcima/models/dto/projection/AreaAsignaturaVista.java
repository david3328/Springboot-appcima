package pe.edu.colegiocima.appcima.models.dto.projection;

/*
* DTO via proyección abierta para entidades relacionadas
* */

import org.springframework.beans.factory.annotation.Value;

public interface AreaAsignaturaVista {
    public Short getId();
    @Value("#{target.areaCurricularDescripcion} / #{target.asignaturaDescripcion}")
    public String getDescripcion();
    @Value("#{target.asignaturaDescripcion}")
    public String getAsignatura();
    @Value("#{target.areaCurricularDescripcion}")
    public String getAreaCurricular();
}
