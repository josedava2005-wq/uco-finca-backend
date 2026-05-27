package co.edu.uco.ucoparking.datos.jpa;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.uco.ucoparking.entidad.FincaEntidad;

/**
 * Repositorio Spring Data JPA para la entidad Finca.
 *
 * Al extender JpaRepository<FincaEntidad, UUID>, Spring genera automáticamente:
 *   - save(entidad)       → INSERT o UPDATE según si el ID ya existe
 *   - findAll()           → SELECT * FROM finca (con JOINs a toda la cadena)
 *   - findById(id)        → SELECT * FROM finca WHERE id = ?
 *   - deleteById(id)      → DELETE FROM finca WHERE id = ?
 *   - existsById(id)      → SELECT COUNT(*) ...
 *
 * Debido a la cadena EAGER completa, Hibernate generará:
 *
 *   SELECT f.*, lf.*, c.*, d.*, p.*
 *   FROM finca f
 *   LEFT JOIN lugar_finca  lf ON f.id_lugar_finca    = lf.id
 *   LEFT JOIN ciudad       c  ON lf.id_ciudad         = c.id
 *   LEFT JOIN departamento d  ON c.id_departamento    = d.id
 *   LEFT JOIN pais         p  ON d.id_pais            = p.id
 *
 * Esta interfaz es un detalle de INFRAESTRUCTURA.
 * Solo debe ser conocida por FincaDatosImpl, nadie más.
 */
public interface FincaJpaRepository extends JpaRepository<FincaEntidad, UUID> {
    // Spring Data JPA genera toda la implementación en tiempo de arranque.
    // No necesitamos escribir nada aquí por ahora.
}
