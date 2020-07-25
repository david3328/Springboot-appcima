package pe.edu.colegiocima.appcima.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.colegiocima.appcima.models.dto.projection.PlanEstudioVista;
import pe.edu.colegiocima.appcima.models.entity.PlanEstudio;
import pe.edu.colegiocima.appcima.models.repository.PlanEstudioRepository;

@Service
public class PlanEstudioServiceImpl implements PlanEstudioService{
    @Autowired
    private PlanEstudioRepository planEstudioRepository;

    @Override
    public Iterable<PlanEstudio> findAll() {
        return planEstudioRepository.findAll();
    }

    @Override
    public PlanEstudio findById(Short id) {
        return planEstudioRepository.findById(id).get();
    }

    @Override
    public PlanEstudio save(PlanEstudio planEstudio) {
        return planEstudioRepository.save(planEstudio);
    }

    @Override
    public void deleteById(Short id) {
        planEstudioRepository.deleteById(id);
    }

    @Override
    public Iterable<PlanEstudioVista> findCustom() {
        return planEstudioRepository.findCustomPlanEstudio();
    }
}
