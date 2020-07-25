package pe.edu.colegiocima.appcima.models.dao;

import pe.edu.colegiocima.appcima.models.entity.PlanEstudio;

import java.util.List;

public interface PlanEstudioDAO {
    public List<PlanEstudio> busquedaPersonalizada(Short idAnioLectivo, Short idGrado) throws Exception;
}
