package pe.edu.colegiocima.appcima.models.repository;

import org.springframework.stereotype.Component;
import pe.edu.colegiocima.appcima.models.entity.*;

import java.util.Map;
import java.util.Objects;

@Component
public class PlanEstudioMapper {
    public PlanEstudio mapperRowBusquedaPersonalizada(Map<String,Object> values){
        PlanEstudio oMapper = new PlanEstudio();
        Short id = Objects.nonNull(values.get("id"))? (Short) values.get("id"):null;
        Short idAnioLectivo = Objects.nonNull(values.get("idannolectivo")) ? (Short) values.get("idannolectivo"):null;
        Short idGrado = Objects.nonNull(values.get("idgrado"))? (Short) values.get("idgrado"):null;
        String descripcionAnioLectivo = Objects.nonNull(values.get("annolectivo")) ? (String) values.get("annolectivo"):null;
        String descripcionGrado = Objects.nonNull(values.get("grado")) ? (String) values.get("grado"):null;
        String descripcionAreaCurricular = Objects.nonNull(values.get("areacurricular")) ? (String) values.get("areacurricular"):null;
        String descripcionAsignatura = Objects.nonNull(values.get("asignatura")) ? (String) values.get("asignatura"):null;
        Short horas = Objects.nonNull(values.get("horas")) ? (Short) values.get("horas"):null;
        Short idAreaAsignatura = Objects.nonNull(values.get("idareaasignatura")) ? (Short) values.get("idareaasignatura"):null;
        oMapper.setId(id);
        oMapper.setHoras(horas);
        Grado oGrado = new Grado();
        oGrado.setId(idGrado);
        oGrado.setDescripcion(descripcionGrado);
        oMapper.setGrado(oGrado);

        oMapper.setAnioLectivo(AnioLectivo.builder()
                .id(idAnioLectivo)
                .descripcion(descripcionAnioLectivo)
                .build());
        oMapper.setAreaAsignatura(AreaAsignatura.builder()
                .id(idAreaAsignatura)
                .areaCurricular(AreaCurricular.builder()
                        .descripcion(descripcionAreaCurricular)
                        .build())
                .asignatura(Asignatura.builder()
                        .descripcion(descripcionAsignatura)
                        .build())
                .build());
        return oMapper;
    }
}
