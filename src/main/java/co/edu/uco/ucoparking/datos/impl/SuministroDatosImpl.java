package co.edu.uco.ucoparking.datos.impl;

import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import co.edu.uco.ucoparking.datos.SuministroDatos;
import co.edu.uco.ucoparking.datos.jpa.AlmacenJpaRepository;
import co.edu.uco.ucoparking.datos.jpa.ProveedorJpaRepository;
import co.edu.uco.ucoparking.datos.jpa.SuministroJpaRepository;
import co.edu.uco.ucoparking.datos.jpa.TipoSuministroJpaRepository;
import co.edu.uco.ucoparking.entidad.SuministroEntidad;

@Repository
public class SuministroDatosImpl implements SuministroDatos {

    private final SuministroJpaRepository jpaRepository;
    private final TipoSuministroJpaRepository tipoSuministroJpaRepository;
    private final AlmacenJpaRepository almacenJpaRepository;
    private final ProveedorJpaRepository proveedorJpaRepository;

    public SuministroDatosImpl(
            final SuministroJpaRepository jpaRepository,
            final TipoSuministroJpaRepository tipoSuministroJpaRepository,
            final AlmacenJpaRepository almacenJpaRepository,
            final ProveedorJpaRepository proveedorJpaRepository) {
        this.jpaRepository = jpaRepository;
        this.tipoSuministroJpaRepository = tipoSuministroJpaRepository;
        this.almacenJpaRepository = almacenJpaRepository;
        this.proveedorJpaRepository = proveedorJpaRepository;
    }

    @Override
    @Transactional
    public void crear(final SuministroEntidad entidad) {
        resolverFKs(entidad);
        jpaRepository.save(entidad);
    }

    @Override
    public List<SuministroEntidad> consultar(final SuministroEntidad filtro) {
        return jpaRepository.findAll();
    }

    @Override
    @Transactional
    public void modificar(final SuministroEntidad entidad) {
        resolverFKs(entidad);
        jpaRepository.save(entidad);
    }

    @Override
    @Transactional
    public void eliminar(final UUID id) {
        jpaRepository.deleteById(id);
    }

    private void resolverFKs(final SuministroEntidad entidad) {
        if (entidad.getTipoSuministro() != null && entidad.getTipoSuministro().getId() != null) {
            entidad.setTipoSuministro(tipoSuministroJpaRepository.getReferenceById(entidad.getTipoSuministro().getId()));
        }
        if (entidad.getAlmacen() != null && entidad.getAlmacen().getId() != null) {
            entidad.setAlmacen(almacenJpaRepository.getReferenceById(entidad.getAlmacen().getId()));
        }
        if (entidad.getProveedor() != null && entidad.getProveedor().getId() != null) {
            entidad.setProveedor(proveedorJpaRepository.getReferenceById(entidad.getProveedor().getId()));
        }
    }
}
