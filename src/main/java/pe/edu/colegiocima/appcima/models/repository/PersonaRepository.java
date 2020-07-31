package pe.edu.colegiocima.appcima.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.colegiocima.appcima.models.entity.Persona;

public interface PersonaRepository extends JpaRepository<Persona,Long> {
    public Persona findByLogin(String login);
}
