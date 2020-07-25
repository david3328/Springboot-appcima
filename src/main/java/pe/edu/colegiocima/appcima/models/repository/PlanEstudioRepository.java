package pe.edu.colegiocima.appcima.models.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import pe.edu.colegiocima.appcima.models.dto.projection.PlanEstudioVista;
import pe.edu.colegiocima.appcima.models.entity.Grado;
import pe.edu.colegiocima.appcima.models.entity.PlanEstudio;

import java.util.List;
import java.util.Map;

public interface PlanEstudioRepository  extends PagingAndSortingRepository<PlanEstudio,Short> {
    @Query("select " +
            "pe.id, " +
            "a.descripcion as anioLectivoDescripcion, " +
            "g.descripcion as gradoDescripcion, " +
            "a3.descripcion as areaCurricularDescripcion, " +
            "a4.descripcion as asignaturaDescripcion, " +
            "pe.horas " +
            "from PlanEstudio pe " +
            "inner join pe.anioLectivo a " +
            "inner join pe.grado g " +
            "inner join pe.areaAsignatura a2 " +
            "inner join a2.areaCurricular a3 " +
            "inner join a2.asignatura a4")
    public List<PlanEstudioVista> findCustomPlanEstudio();
    public Page<PlanEstudio> findAll(Pageable pageable);

    @Query(value = "select * from v_listaplanestudio where idannolectivo = ?1 and idgrado = ?2", nativeQuery = true)
    public List<Map<String,Object>> busquedaPersonalizada(Short idAnioLectivo, Short idGrado);
}
