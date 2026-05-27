package co.edu.uco.ucoparking.datos.impl;

import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import co.edu.uco.ucoparking.datos.AlmacenDatos;
import co.edu.uco.ucoparking.datos.jpa.AlmacenJpaRepository;
import co.edu.uco.ucoparking.datos.jpa.FincaJpaRepository;
import co.edu.uco.ucoparking.datos.jpa.TipoAlmacenJpaRepository;
import co.edu.uco.ucoparking.entidad.AlmacenEntidad;

/**
 * Implementación de AlmacenDatos usando JPA / SQL Server.
 *
 * FIX FK (crear/modificar):
 *   Almacén tiene DOS relaciones FK:
 *   - id_finca        → FincaJpaRepository.getReferenceById()
 *   - id_tipo_almacen → TipoAlmacenJpaRepository.getReferenceById()
 *   Ambas se resuelven en el mismo @Transactional.
 *
 * RELACIONES (todo EAGER):
 *   Almacen → TipoAlmacen
 *   Almacen → Finca → LugarFinca → Ciudad → Departamento → País
 */
@Repository
public class AlmacenDatosImpl implements AlmacenDatos {

    private final AlmacenJpaRepository jpaRepository;
    private final FincaJpaRepository fincaJpaRepository;
    private final TipoAlmacenJpaRepository tipoAlmacenJpaRepository;

    public AlmacenDatosImpl(
            final AlmacenJpaRepository jpaRepository,
            final FincaJpaRepository fincaJpaRepository,
            final TipoAlmacenJpaRepository tipoAlmacenJpaRepository) {
        this.jpaRepository = jpaRepository;
        this.fincaJpaRepository = fincaJpaRepository;
        this.tipoAlmacenJpaRepository = tipoAlmacenJpaRepository;
    }

    @Override
    @Transactional
    public void crear(final AlmacenEntidad entidad) {
        resolverFKs(entidad);
        jpaRepository.save(entidad);
    }

    @Override
    public List<AlmacenEntidad> consultar(final AlmacenEntidad filtro) {
        return jpaRepository.findAll();
    }

    @Override
    @Transactional
    public void modificar(final AlmacenEntidad entidad) {
        resolverFKs(entidad);
        jpaRepository.save(entidad);
    }

    @Override
    @Transactional
    public void eliminar(final UUID id) {
        jpaRepository.deleteById(id);
    }

    private void resolverFKs(final AlmacenEntidad entidad) {
        if (entidad.getFinca() != null && entidad.getFinca().getId() != null) {
            entidad.setFinca(fincaJpaRepository.getReferenceById(entidad.getFinca().getId()));
        }
        if (entidad.getTipoAlmacen() != null && entidad.getTipoAlmacen().getId() != null) {
            entidad.setTipoAlmacen(
                    tipoAlmacenJpaRepository.getReferenceById(entidad.getTipoAlmacen().getId()));
        }
    }
}
