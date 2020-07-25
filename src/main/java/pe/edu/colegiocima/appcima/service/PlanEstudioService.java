package pe.edu.colegiocima.appcima.service;

import pe.edu.colegiocima.appcima.models.dto.projection.PlanEstudioVista;
import pe.edu.colegiocima.appcima.models.entity.PlanEstudio;

public interface PlanEstudioService {
    public Iterable<PlanEstudio> findAll();
    public PlanEstudio findById(Short id);
    public PlanEstudio save(PlanEstudio planEstudio);
    public void deleteById(Short id);
    public Iterable<PlanEstudioVista> findCustom();
}
