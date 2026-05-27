package co.edu.uco.ucoparking.datos.jpa;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.uco.ucoparking.entidad.AlimentacionEntidad;

/** Repositorio Spring Data JPA para Alimentacion. FKs: id_animal, id_empleado. */
public interface AlimentacionJpaRepository extends JpaRepository<AlimentacionEntidad, UUID> {
}
