package co.edu.uco.ucoparking.datos.jpa;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.uco.ucoparking.entidad.RecoleccionEntidad;

/** Repositorio Spring Data JPA para Recoleccion. FKs: id_producto, id_animal, id_empleado. */
public interface RecoleccionJpaRepository extends JpaRepository<RecoleccionEntidad, UUID> {
}
