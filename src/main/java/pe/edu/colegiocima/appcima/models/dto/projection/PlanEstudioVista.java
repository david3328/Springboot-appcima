package pe.edu.colegiocima.appcima.models.dto.projection;

import org.springframework.beans.factory.annotation.Value;

public interface PlanEstudioVista {
    public Short getId();
    @Value("#{target.anioLectivoDescripcion}")
    public String getAnioLectivo();
    @Value("#{target.gradoDescripcion}")
    public String getGrado();
    @Value("#{target.areaCurricularDescripcion}")
    public String getAreaCurricular();
    @Value("#{target.asignaturaDescripcion}")
    public String getAsignatura();
    public Short getHoras();
}
