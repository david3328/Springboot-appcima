package pe.edu.colegiocima.appcima.service;

import pe.edu.colegiocima.appcima.models.dto.projection.PlanEstudioVista;
import pe.edu.colegiocima.appcima.models.entity.PlanEstudio;

import java.util.List;

public interface PlanEstudioService {
    public Iterable<PlanEstudio> findAll();
    public PlanEstudio findById(Short id);
    public PlanEstudio save(PlanEstudio planEstudio);
    public void deleteById(Short id);
    public Iterable<PlanEstudioVista> findCustom();
    public List<PlanEstudio> busquedaPersonalizada(Short idAnioLectivo, Short idGrado);
}
