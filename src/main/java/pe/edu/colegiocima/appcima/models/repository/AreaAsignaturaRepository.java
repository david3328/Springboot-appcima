package pe.edu.colegiocima.appcima.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.colegiocima.appcima.models.dto.projection.AreaAsignaturaCustom;
import pe.edu.colegiocima.appcima.models.entity.AreaAsignatura;

import java.util.List;

public interface AreaAsignaturaRepository extends JpaRepository<AreaAsignatura,Short> {
    public List<AreaAsignaturaCustom> findByOrderByAreaCurricularDescripcion();
}
