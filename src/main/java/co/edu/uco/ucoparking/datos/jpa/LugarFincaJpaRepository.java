package co.edu.uco.ucoparking.datos.jpa;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.uco.ucoparking.entidad.LugarFincaEntidad;

/**
 * Repositorio Spring Data JPA para la entidad LugarFinca.
 *
 * Al extender JpaRepository<LugarFincaEntidad, UUID>, Spring genera automáticamente:
 *   - save(entidad)       → INSERT o UPDATE según si el ID ya existe
 *   - findAll()           → SELECT * FROM lugar_finca (con JOINs a ciudad, departamento, pais)
 *   - findById(id)        → SELECT * FROM lugar_finca WHERE id = ?
 *   - deleteById(id)      → DELETE FROM lugar_finca WHERE id = ?
 *   - existsById(id)      → SELECT COUNT(*) ...
 *
 * Como LugarFincaEntidad tiene @ManyToOne(fetch = EAGER) hacia CiudadEntidad,
 * y CiudadEntidad tiene @ManyToOne(fetch = EAGER) hacia DepartamentoEntidad,
 * y DepartamentoEntidad tiene @ManyToOne(fetch = EAGER) hacia PaisEntidad,
 * Hibernate generará automáticamente un SELECT con tres JOINs:
 *
 *   SELECT lf.*, c.*, d.*, p.*
 *   FROM lugar_finca lf
 *   LEFT JOIN ciudad      c  ON lf.id_ciudad      = c.id
 *   LEFT JOIN departamento d ON c.id_departamento  = d.id
 *   LEFT JOIN pais         p ON d.id_pais          = p.id
 *
 * Esta interfaz es un detalle de INFRAESTRUCTURA.
 * Solo debe ser conocida por LugarFincaDatosImpl, nadie más.
 */
public interface LugarFincaJpaRepository extends JpaRepository<LugarFincaEntidad, UUID> {
    // Spring Data JPA genera toda la implementación en tiempo de arranque.
    // No necesitamos escribir nada aquí por ahora.
}
