package co.edu.uco.ucoparking.datos.jpa;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.uco.ucoparking.entidad.TipoAlmacenEntidad;

/**
 * Repositorio Spring Data JPA para la entidad TipoAlmacen.
 *
 * Spring genera automáticamente:
 *   save(entidad)       → INSERT o UPDATE
 *   findAll()           → SELECT * FROM tipo_almacen
 *   findById(id)        → SELECT * FROM tipo_almacen WHERE id = ?
 *   deleteById(id)      → DELETE FROM tipo_almacen WHERE id = ?
 *
 * Solo conocida por TipoAlmacenDatosImpl.
 */
public interface TipoAlmacenJpaRepository extends JpaRepository<TipoAlmacenEntidad, UUID> {
}
