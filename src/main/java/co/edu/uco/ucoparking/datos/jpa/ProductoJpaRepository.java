package co.edu.uco.ucoparking.datos.jpa;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.uco.ucoparking.entidad.ProductoEntidad;

/**
 * Repositorio Spring Data JPA para la entidad Producto.
 *
 * Hibernate generará al consultar:
 *
 *   SELECT pr.*, f.*, lf.*, c.*, d.*, p.*
 *   FROM producto pr
 *   LEFT JOIN finca        f  ON pr.id_finca         = f.id
 *   LEFT JOIN lugar_finca  lf ON f.id_lugar_finca    = lf.id
 *   LEFT JOIN ciudad       c  ON lf.id_ciudad        = c.id
 *   LEFT JOIN departamento d  ON c.id_departamento   = d.id
 *   LEFT JOIN pais         p  ON d.id_pais           = p.id
 *
 * Solo debe ser conocida por ProductoDatosImpl.
 */
public interface ProductoJpaRepository extends JpaRepository<ProductoEntidad, UUID> {
}
