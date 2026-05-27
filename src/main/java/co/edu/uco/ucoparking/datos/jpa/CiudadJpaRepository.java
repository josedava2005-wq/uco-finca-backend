package co.edu.uco.ucoparking.datos.jpa;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.uco.ucoparking.entidad.CiudadEntidad;

/**
 * Repositorio Spring Data JPA para la entidad Ciudad.
 *
 * Al extender JpaRepository<CiudadEntidad, UUID>, Spring genera automáticamente:
 *   - save(entidad)       → INSERT o UPDATE según si el ID ya existe
 *   - findAll()           → SELECT * FROM ciudad (con JOIN a departamento y pais)
 *   - findById(id)        → SELECT * FROM ciudad WHERE id = ?
 *   - deleteById(id)      → DELETE FROM ciudad WHERE id = ?
 *   - existsById(id)      → SELECT COUNT(*) ...
 *
 * Como CiudadEntidad tiene @ManyToOne(fetch = EAGER) hacia DepartamentoEntidad,
 * y DepartamentoEntidad tiene @ManyToOne(fetch = EAGER) hacia PaisEntidad,
 * Hibernate generará automáticamente un SELECT con dos JOINs:
 *
 *   SELECT c.*, d.*, p.*
 *   FROM ciudad c
 *   LEFT JOIN departamento d ON c.id_departamento = d.id
 *   LEFT JOIN pais p         ON d.id_pais         = p.id
 *
 * Esta interfaz es un detalle de INFRAESTRUCTURA.
 * Solo debe ser conocida por CiudadDatosImpl, nadie más.
 */
public interface CiudadJpaRepository extends JpaRepository<CiudadEntidad, UUID> {
    // Spring Data JPA genera toda la implementación en tiempo de arranque.
    // No necesitamos escribir nada aquí por ahora.
}
