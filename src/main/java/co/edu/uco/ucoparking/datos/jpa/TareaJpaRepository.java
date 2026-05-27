package co.edu.uco.ucoparking.datos.jpa;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.uco.ucoparking.entidad.TareaEntidad;

public interface TareaJpaRepository extends JpaRepository<TareaEntidad, UUID> {
}
