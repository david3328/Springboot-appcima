package pe.edu.colegiocima.appcima.service;

import pe.edu.colegiocima.appcima.models.entity.Grado;

public interface GradoService {
    public Iterable<Grado> findAll();
    public void deleteById(Long id);
    public Grado findById(Long id);
    public Grado save(Grado grado);
    public Iterable<Grado> findByIdNivelColegioOrderByDescripcion(Integer idNivelColegio);
}
