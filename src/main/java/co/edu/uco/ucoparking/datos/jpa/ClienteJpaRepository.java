package co.edu.uco.ucoparking.datos.jpa;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.uco.ucoparking.entidad.ClienteEntidad;

/**
 * Repositorio Spring Data JPA para la entidad Cliente.
 *
 * Al extender JpaRepository<ClienteEntidad, UUID>, Spring genera automáticamente:
 *   - save(entidad)       → INSERT o UPDATE según si el ID ya existe
 *   - findAll()           → SELECT * FROM cliente (con JOINs a ciudad, departamento, pais)
 *   - findById(id)        → SELECT * FROM cliente WHERE id = ?
 *   - deleteById(id)      → DELETE FROM cliente WHERE id = ?
 *   - existsById(id)      → SELECT COUNT(*) ...
 *
 * Como ClienteEntidad tiene @ManyToOne(fetch = EAGER) hacia CiudadEntidad,
 * y CiudadEntidad tiene @ManyToOne(fetch = EAGER) hacia DepartamentoEntidad,
 * y DepartamentoEntidad tiene @ManyToOne(fetch = EAGER) hacia PaisEntidad,
 * Hibernate generará automáticamente un SELECT con tres JOINs:
 *
 *   SELECT cl.*, c.*, d.*, p.*
 *   FROM cliente cl
 *   LEFT JOIN ciudad      c  ON cl.id_ciudad      = c.id
 *   LEFT JOIN departamento d ON c.id_departamento  = d.id
 *   LEFT JOIN pais         p ON d.id_pais          = p.id
 *
 * Esta interfaz es un detalle de INFRAESTRUCTURA.
 * Solo debe ser conocida por ClienteDatosImpl, nadie más.
 */
public interface ClienteJpaRepository extends JpaRepository<ClienteEntidad, UUID> {
    // Spring Data JPA genera toda la implementación en tiempo de arranque.
    // No necesitamos escribir nada aquí por ahora.
}
