package co.edu.uco.ucoparking.datos.impl;

import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Repository;
import co.edu.uco.ucoparking.datos.ProveedorDatos;
import co.edu.uco.ucoparking.datos.jpa.ProveedorJpaRepository;
import co.edu.uco.ucoparking.entidad.ProveedorEntidad;

/**
 * Implementación de ProveedorDatos usando JPA / SQL Server.
 * Sin FK externas → no requiere resolución de referencias ni @Transactional especial.
 */
@Repository
public class ProveedorDatosImpl implements ProveedorDatos {

    private final ProveedorJpaRepository jpaRepository;

    public ProveedorDatosImpl(final ProveedorJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public void crear(final ProveedorEntidad entidad) {
        jpaRepository.save(entidad);
    }

    @Override
    public List<ProveedorEntidad> consultar(final ProveedorEntidad filtro) {
        return jpaRepository.findAll();
    }

    @Override
    public void modificar(final ProveedorEntidad entidad) {
        jpaRepository.save(entidad);
    }

    @Override
    public void eliminar(final UUID id) {
        jpaRepository.deleteById(id);
    }
}
