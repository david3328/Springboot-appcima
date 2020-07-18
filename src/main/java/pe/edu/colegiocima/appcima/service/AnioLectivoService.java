package pe.edu.colegiocima.appcima.service;

import pe.edu.colegiocima.appcima.models.dto.AnioLectivoDTO;
import pe.edu.colegiocima.appcima.models.entity.AnioLectivo;

import java.util.List;

public interface AnioLectivoService {
    public Iterable<AnioLectivo> findAll();
    public AnioLectivo findById(Short id);
    public List<AnioLectivoDTO> findActive();
}
