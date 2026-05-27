package co.edu.uco.ucoparking.datos.jpa;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.uco.ucoparking.entidad.EstadoAnimalEntidad;

/** Repositorio Spring Data JPA para EstadoAnimal. FK: id_animal. */
public interface EstadoAnimalJpaRepository extends JpaRepository<EstadoAnimalEntidad, UUID> {
}
