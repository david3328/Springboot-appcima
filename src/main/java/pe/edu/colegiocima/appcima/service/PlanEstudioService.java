package pe.edu.colegiocima.appcima.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pe.edu.colegiocima.appcima.models.dto.projection.PlanEstudioVista;
import pe.edu.colegiocima.appcima.models.entity.PlanEstudio;

import java.util.List;
import java.util.Optional;

public interface PlanEstudioService {
    public Iterable<PlanEstudio> findAll();
    public Optional<PlanEstudio> findById(Short id);
    public PlanEstudio save(PlanEstudio planEstudio);
    public void deleteById(Short id);
    public Iterable<PlanEstudioVista> findCustom();
    public List<PlanEstudio> busquedaPersonalizada(Short idAnioLectivo, Short idGrado);
    public Page<PlanEstudio> busquedaPlanEstudio(Short idAnioLectivo, Short idGrado, Pageable pageable);
}
