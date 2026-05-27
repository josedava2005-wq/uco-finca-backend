package co.edu.uco.ucoparking.datos.jpa;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.uco.ucoparking.entidad.DepartamentoEntidad;

/**
 * Repositorio Spring Data JPA para la entidad Departamento.
 *
 * Al extender JpaRepository<DepartamentoEntidad, UUID>, Spring genera automáticamente:
 *   - save(entidad)       → INSERT o UPDATE según si el ID ya existe
 *   - findAll()           → SELECT * FROM departamento
 *   - findById(id)        → SELECT * FROM departamento WHERE id = ?
 *   - deleteById(id)      → DELETE FROM departamento WHERE id = ?
 *   - existsById(id)      → SELECT COUNT(*) ...
 *
 * Esta interfaz es un detalle de INFRAESTRUCTURA.
 * Solo debe ser conocida por DepartamentoDatosImpl, nadie más.
 */
public interface DepartamentoJpaRepository extends JpaRepository<DepartamentoEntidad, UUID> {
    // Spring Data JPA genera toda la implementación en tiempo de arranque.
    // No necesitamos escribir nada aquí por ahora.
}
