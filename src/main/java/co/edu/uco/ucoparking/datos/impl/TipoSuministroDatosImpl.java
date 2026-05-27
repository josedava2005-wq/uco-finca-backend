package co.edu.uco.ucoparking.datos.impl;

import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Repository;
import co.edu.uco.ucoparking.datos.TipoSuministroDatos;
import co.edu.uco.ucoparking.datos.jpa.TipoSuministroJpaRepository;
import co.edu.uco.ucoparking.entidad.TipoSuministroEntidad;

/**
 * Implementación de TipoSuministroDatos usando JPA / SQL Server.
 *
 * ANTES: usaba una List<TipoSuministroEntidad> estática en memoria (datos volátiles).
 * AHORA: delega en TipoSuministroJpaRepository → tabla "tipo_suministro" en SQL Server.
 *
 * FLUJO:
 *   TipoSuministroCasoDeUsoImpl → TipoSuministroDatos (esta clase)
 *       → TipoSuministroJpaRepository → Hibernate → SQL Server
 */
@Repository
public class TipoSuministroDatosImpl implements TipoSuministroDatos {

    private final TipoSuministroJpaRepository jpaRepository;

    public TipoSuministroDatosImpl(final TipoSuministroJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public void crear(final TipoSuministroEntidad entidad) {
        jpaRepository.save(entidad);
    }

    @Override
    public List<TipoSuministroEntidad> consultar(final TipoSuministroEntidad filtro) {
        return jpaRepository.findAll();
    }

    @Override
    public void modificar(final TipoSuministroEntidad entidad) {
        jpaRepository.save(entidad);
    }

    @Override
    public void eliminar(final UUID id) {
        jpaRepository.deleteById(id);
    }
}
