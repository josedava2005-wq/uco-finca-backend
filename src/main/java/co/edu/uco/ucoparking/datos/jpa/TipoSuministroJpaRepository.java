package co.edu.uco.ucoparking.datos.jpa;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.uco.ucoparking.entidad.TipoSuministroEntidad;

/**
 * Repositorio Spring Data JPA para la entidad TipoSuministro.
 *
 * Spring genera automáticamente:
 *   save(entidad)       → INSERT o UPDATE
 *   findAll()           → SELECT * FROM tipo_suministro
 *   findById(id)        → SELECT * FROM tipo_suministro WHERE id = ?
 *   deleteById(id)      → DELETE FROM tipo_suministro WHERE id = ?
 *
 * Solo conocida por TipoSuministroDatosImpl.
 */
public interface TipoSuministroJpaRepository extends JpaRepository<TipoSuministroEntidad, UUID> {
}
