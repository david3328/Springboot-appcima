package pe.edu.colegiocima.appcima.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.colegiocima.appcima.models.entity.AnioLectivo;

import java.util.List;

public interface AnioLectivoRepository extends JpaRepository<AnioLectivo,Short> {
    @Query("select a from  AnioLectivo  a where a.activo = true order by a.id")
    public List<AnioLectivo> buscarPorActivo();

    public List<AnioLectivo> findByActivoTrueOrderById();
}
