package pe.edu.colegiocima.appcima.service;

import com.google.common.base.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pe.edu.colegiocima.appcima.models.dto.projection.PlanEstudioVista;
import pe.edu.colegiocima.appcima.models.entity.PlanEstudio;
import pe.edu.colegiocima.appcima.models.repository.PlanEstudioMapper;
import pe.edu.colegiocima.appcima.models.repository.PlanEstudioRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
    public Optional<PlanEstudio> findById(Short id) {
        return planEstudioRepository.findById(id);
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

    @Override
    public Page<PlanEstudio> busquedaPlanEstudio(Short idAnioLectivo, Short idGrado, Pageable pageable) {
       // Page lista = planEstudioRepository.busquedaPersonalizada(idAnioLectivo,idGrado,pageable);
//        Page<PlanEstudio> pagina = new Page();
//        lista.map(e->)
//
//        Page<ObjectEntity> entities = objectEntityRepository.findAll(pageable);
//        Page<ObjectDto> dtoPage = entities.map(new Converter<ObjectEntity, ObjectDto>() {
//            @Override
//            public ObjectDto convert(ObjectEntity entity) {
//                ObjectDto dto = new ObjectDto();
//                // Conversion logic
//
//                return dto;
//            }
//        });
        Page<Map<String,Object>> entities = planEstudioRepository.busquedaPersonalizada(idAnioLectivo,idGrado,pageable); // viene de la paginacion
        Page<PlanEstudio> dtoPage = entities.map( e -> {
            PlanEstudio obj = planEstudioMapper.mapperRowBusquedaPersonalizada(e);
//            listaMapper.add(obj);
            return obj;
        });
//        planEstudioRepository.busquedaPersonalizada(idAnioLectivo,idGrado,pageable);
//
//        Page<Map<String,Object>> lista = planEstudioRepository.busquedaPersonalizada(idAnioLectivo,idGrado,pageable);
//        Page<ObjectDto> dtoPage = lista.map(new Converter<Map<String,Object>, ObjectDto>() {
//            @Override
//            public ObjectDto convert(ObjectEntity entity) {
//                ObjectDto dto = new ObjectDto();
//                // Conversion logic
//
//                return dto;
//            }
//        });
        //Page<PlanEstudio> page = new PageImpl<>(listaMapper);
//        planEstudioRepository.busquedaPersonalizada(idAnioLectivo,idGrado)
//                .stream().map(el-> planEstudioMapper.mapperRowBusquedaPersonalizada(el)).forEachOrdered(o->listaMapper.add(o));
        return dtoPage;
    }
}
