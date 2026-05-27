package co.edu.uco.ucoparking.datos.jpa;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.uco.ucoparking.entidad.SuministroEntidad;

/** Repositorio Spring Data JPA para Suministro. FKs: id_tipo_suministro, id_almacen, id_proveedor. */
public interface SuministroJpaRepository extends JpaRepository<SuministroEntidad, UUID> {
}
