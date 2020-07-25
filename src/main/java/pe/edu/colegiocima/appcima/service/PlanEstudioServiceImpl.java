package pe.edu.colegiocima.appcima.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.colegiocima.appcima.models.dto.projection.PlanEstudioVista;
import pe.edu.colegiocima.appcima.models.entity.PlanEstudio;
import pe.edu.colegiocima.appcima.models.repository.PlanEstudioMapper;
import pe.edu.colegiocima.appcima.models.repository.PlanEstudioRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PlanEstudioServiceImpl implements PlanEstudioService{
    @Autowired
    private PlanEstudioRepository planEstudioRepository;

    @Autowired
    private PlanEstudioMapper planEstudioMapper;

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

    @Override
    public List<PlanEstudio> busquedaPersonalizada(Short idAnioLectivo, Short idGrado) {
        //List<Map<String,Object>> lista = planEstudioRepository.busquedaPersonalizada(idAnioLectivo,idGrado);
        List<PlanEstudio> listaMapper = new ArrayList<>();

        planEstudioRepository.busquedaPersonalizada(idAnioLectivo,idGrado)
            .stream().map(el-> planEstudioMapper.mapperRowBusquedaPersonalizada(el)).forEachOrdered(o->listaMapper.add(o));

//        for (Map<String,Object> map: lista) {
//            PlanEstudio obj = planEstudioMapper.mapperRowBusquedaPersonalizada(map);
//            listaMapper.add(obj);
//        }
        return listaMapper;
    }
}
