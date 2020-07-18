package pe.edu.colegiocima.appcima.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.colegiocima.appcima.models.entity.AreaAsignatura;
import pe.edu.colegiocima.appcima.models.repository.AreaAsignaturaRepository;

@Service
public class AreaAsignaturaServiceImpl  implements AreaAsignaturaService{
    @Autowired
    private AreaAsignaturaRepository repository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<AreaAsignatura> findAll() {
        return repository.findAll();
    }
}
