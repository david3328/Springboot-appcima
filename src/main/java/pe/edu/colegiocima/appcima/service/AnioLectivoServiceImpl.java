package pe.edu.colegiocima.appcima.service;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Marker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.colegiocima.appcima.models.dto.AnioLectivoDTO;
import pe.edu.colegiocima.appcima.models.entity.AnioLectivo;
import pe.edu.colegiocima.appcima.models.repository.AnioLectivoRepository;

import java.util.List;
import java.util.logging.Level;

//@Log
@Slf4j
@Service
public class AnioLectivoServiceImpl implements AnioLectivoService{
    @Autowired
    private AnioLectivoRepository anioLectivoRepository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<AnioLectivo> findAll() {
        return anioLectivoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public AnioLectivo findById(Short id) {
        return anioLectivoRepository.findById(id).get();
    }

    @Override
    @Transactional(readOnly = true)
    public List<AnioLectivoDTO> findActive() {
        log.info("Service: Listar año lectivo");
        return anioLectivoRepository.busquedaActivo();
    }

    @Override
    public void deleteById(Short id) {

    }
}
