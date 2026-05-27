package co.edu.uco.ucoparking.datos.jpa;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.uco.ucoparking.entidad.AlmacenEntidad;

/**
 * Repositorio Spring Data JPA para la entidad Almacen.
 *
 * Hibernate generará al consultar (dos ramas EAGER en paralelo):
 *
 *   SELECT al.*, ta.*, f.*, lf.*, c.*, d.*, p.*
 *   FROM almacen al
 *   LEFT JOIN tipo_almacen  ta ON al.id_tipo_almacen  = ta.id
 *   LEFT JOIN finca         f  ON al.id_finca          = f.id
 *   LEFT JOIN lugar_finca   lf ON f.id_lugar_finca     = lf.id
 *   LEFT JOIN ciudad        c  ON lf.id_ciudad         = c.id
 *   LEFT JOIN departamento  d  ON c.id_departamento    = d.id
 *   LEFT JOIN pais          p  ON d.id_pais            = p.id
 *
 * Solo debe ser conocida por AlmacenDatosImpl.
 */
public interface AlmacenJpaRepository extends JpaRepository<AlmacenEntidad, UUID> {
}
