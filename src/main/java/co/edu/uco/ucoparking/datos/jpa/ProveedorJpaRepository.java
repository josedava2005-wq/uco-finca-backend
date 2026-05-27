package co.edu.uco.ucoparking.datos.jpa;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.uco.ucoparking.entidad.ProveedorEntidad;

/** Repositorio Spring Data JPA para Proveedor. Sin FK externas — sin JOINs adicionales. */
public interface ProveedorJpaRepository extends JpaRepository<ProveedorEntidad, UUID> {
}
