package pe.edu.colegiocima.appcima.models.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.colegiocima.appcima.models.dto.projection.AreaAsignaturaCustom;
import pe.edu.colegiocima.appcima.models.dto.projection.AreaAsignaturaVista;
import pe.edu.colegiocima.appcima.models.entity.AreaAsignatura;

import java.util.List;

public interface AreaAsignaturaRepository extends JpaRepository<AreaAsignatura,Short> {
    @Query("select "
            + "a.id as id, "
            + "b.descripcion as areaCurricularDescripcion, "
    + "c.descripcion as asignaturaDescripcion "
    + "from AreaAsignatura a "
    + "inner join a.areaCurricular b "
    + "inner join a.asignatura  c "
    + "order by b.descripcion")
    public List<AreaAsignaturaVista> findCustomAreaCurricular();
    public List<AreaAsignaturaCustom> findByOrderByAreaCurricularDescripcion();
}
