package co.edu.uco.ucoparking.datos.impl;

import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Repository;
import co.edu.uco.ucoparking.datos.TipoAlmacenDatos;
import co.edu.uco.ucoparking.datos.jpa.TipoAlmacenJpaRepository;
import co.edu.uco.ucoparking.entidad.TipoAlmacenEntidad;

/**
 * Implementación de TipoAlmacenDatos usando JPA / SQL Server.
 *
 * ANTES: usaba una List<TipoAlmacenEntidad> estática en memoria (datos volátiles).
 * AHORA: delega en TipoAlmacenJpaRepository → tabla "tipo_almacen" en SQL Server.
 *
 * FLUJO:
 *   TipoAlmacenCasoDeUsoImpl → TipoAlmacenDatos (esta clase)
 *       → TipoAlmacenJpaRepository → Hibernate → SQL Server
 */
@Repository
public class TipoAlmacenDatosImpl implements TipoAlmacenDatos {

    private final TipoAlmacenJpaRepository jpaRepository;

    public TipoAlmacenDatosImpl(final TipoAlmacenJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public void crear(final TipoAlmacenEntidad entidad) {
        jpaRepository.save(entidad);
    }

    @Override
    public List<TipoAlmacenEntidad> consultar(final TipoAlmacenEntidad filtro) {
        return jpaRepository.findAll();
    }

    @Override
    public void modificar(final TipoAlmacenEntidad entidad) {
        jpaRepository.save(entidad);
    }

    @Override
    public void eliminar(final UUID id) {
        jpaRepository.deleteById(id);
    }
}
