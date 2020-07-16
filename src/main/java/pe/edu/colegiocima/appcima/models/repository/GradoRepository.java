package pe.edu.colegiocima.appcima.models.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import pe.edu.colegiocima.appcima.models.entity.Grado;

public interface GradoRepository extends CrudRepository<Grado,Long> {
	
	public Grado findByDescripcionAndIdNivelColegio(String descripcion, Integer id);
	
	public Iterable<Grado> findByIdNivelColegioOrderByDescripcion(Integer idNivelColegio);
	
	@Query("select g from Grado g where g.idNivelColegio = ?1 order by g.descripcion")
	public Iterable<Grado> findCustom(Integer id);
	
	@Procedure(procedureName = "f_insertagrado")
	public Short insertar(String vdescripcion, Short vidnivelcolegio, Short vidgrad_ant, Integer vedad, Boolean vactivo);
	
	@Query(value = "select * from f_insertagrado(?1,?2,?3,?4,?5)",nativeQuery=true)
	public Short queryInsertarDML(String vdescripcion, Short vidnivelcolegio, Short vidgrad_ant, Integer vedad, Boolean vactivo);
}