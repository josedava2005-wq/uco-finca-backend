package co.edu.uco.ucoparking.datos.jpa;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.uco.ucoparking.entidad.PaisEntidad;

/**
 * Repositorio Spring Data JPA para la entidad Pais.
 *
 * Al extender JpaRepository<PaisEntidad, UUID>, Spring genera automáticamente:
 *   - save(entidad)       → INSERT o UPDATE según si el ID ya existe
 *   - findAll()           → SELECT * FROM pais
 *   - findById(id)        → SELECT * FROM pais WHERE id = ?
 *   - deleteById(id)      → DELETE FROM pais WHERE id = ?
 *   - existsById(id)      → SELECT COUNT(*) ...
 *   - y muchos más
 *
 * Esta interfaz es un detalle de INFRAESTRUCTURA.
 * Solo debe ser conocida por PaisDatosImpl, nadie más.
 */
public interface PaisJpaRepository extends JpaRepository<PaisEntidad, UUID> {
    // Spring Data JPA genera toda la implementación en tiempo de arranque.
    // No necesitamos escribir nada aquí por ahora.
}
