package pe.edu.colegiocima.appcima.service;

import pe.edu.colegiocima.appcima.models.dto.projection.AreaAsignaturaVista;
import pe.edu.colegiocima.appcima.models.entity.AreaAsignatura;

public interface AreaAsignaturaService {
    public Iterable<AreaAsignatura> findAll();
    public Iterable<AreaAsignaturaVista> findCustomAreaAsignatura();
}
