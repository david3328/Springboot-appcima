package pe.edu.colegiocima.appcima.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.colegiocima.appcima.models.entity.Asignatura;
import pe.edu.colegiocima.appcima.models.repository.AsignaturaRepository;

@Service
public class AsignaturaServiceImpl implements AsignaturaService{
    @Autowired
    private AsignaturaRepository repository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Asignatura> findAll() {
        return repository.findAll();
    }
}
