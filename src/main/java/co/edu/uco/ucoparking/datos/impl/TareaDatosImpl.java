package co.edu.uco.ucoparking.datos.impl;

import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import co.edu.uco.ucoparking.datos.TareaDatos;
import co.edu.uco.ucoparking.datos.jpa.EmpleadoJpaRepository;
import co.edu.uco.ucoparking.datos.jpa.FincaJpaRepository;
import co.edu.uco.ucoparking.datos.jpa.TareaJpaRepository;
import co.edu.uco.ucoparking.entidad.TareaEntidad;

@Repository
public class TareaDatosImpl implements TareaDatos {

    private final TareaJpaRepository jpaRepository;
    private final EmpleadoJpaRepository empleadoJpaRepository;
    private final FincaJpaRepository fincaJpaRepository;

    public TareaDatosImpl(
            final TareaJpaRepository jpaRepository,
            final EmpleadoJpaRepository empleadoJpaRepository,
            final FincaJpaRepository fincaJpaRepository) {
        this.jpaRepository = jpaRepository;
        this.empleadoJpaRepository = empleadoJpaRepository;
        this.fincaJpaRepository = fincaJpaRepository;
    }

    @Override
    @Transactional
    public void crear(final TareaEntidad entidad) {
        resolverFKs(entidad);
        jpaRepository.save(entidad);
    }

    @Override
    public List<TareaEntidad> consultar(final TareaEntidad filtro) {
        return jpaRepository.findAll();
    }

    @Override
    @Transactional
    public void modificar(final TareaEntidad entidad) {
        resolverFKs(entidad);
        jpaRepository.save(entidad);
    }

    @Override
    @Transactional
    public void eliminar(final UUID id) {
        jpaRepository.deleteById(id);
    }

    private void resolverFKs(final TareaEntidad entidad) {
        if (entidad.getEmpleado() != null && entidad.getEmpleado().getId() != null) {
            entidad.setEmpleado(empleadoJpaRepository.getReferenceById(entidad.getEmpleado().getId()));
        }
        if (entidad.getFinca() != null && entidad.getFinca().getId() != null) {
            entidad.setFinca(fincaJpaRepository.getReferenceById(entidad.getFinca().getId()));
        }
    }
}
