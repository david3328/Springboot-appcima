package pe.edu.colegiocima.appcima.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.colegiocima.appcima.models.entity.Asignatura;

public interface AsignaturaRepository extends JpaRepository<Asignatura,Short> {
}
