package co.edu.uco.ucoparking.datos.impl;

import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import co.edu.uco.ucoparking.datos.EmpleadoDatos;
import co.edu.uco.ucoparking.datos.jpa.EmpleadoJpaRepository;
import co.edu.uco.ucoparking.datos.jpa.FincaJpaRepository;
import co.edu.uco.ucoparking.entidad.EmpleadoEntidad;

/**
 * Implementación de EmpleadoDatos usando JPA / SQL Server.
 *
 * FIX FK (crear/modificar):
 *   Usa FincaJpaRepository.getReferenceById() para obtener un proxy JPA gestionado.
 *
 * RELACIÓN (todo EAGER):
 *   Empleado → Finca → LugarFinca → Ciudad → Departamento → País
 */
@Repository
public class EmpleadoDatosImpl implements EmpleadoDatos {

    private final EmpleadoJpaRepository jpaRepository;
    private final FincaJpaRepository fincaJpaRepository;

    public EmpleadoDatosImpl(
            final EmpleadoJpaRepository jpaRepository,
            final FincaJpaRepository fincaJpaRepository) {
        this.jpaRepository = jpaRepository;
        this.fincaJpaRepository = fincaJpaRepository;
    }

    @Override
    @Transactional
    public void crear(final EmpleadoEntidad entidad) {
        resolverFKs(entidad);
        jpaRepository.save(entidad);
    }

    @Override
    public List<EmpleadoEntidad> consultar(final EmpleadoEntidad filtro) {
        return jpaRepository.findAll();
    }

    @Override
    @Transactional
    public void modificar(final EmpleadoEntidad entidad) {
        resolverFKs(entidad);
        jpaRepository.save(entidad);
    }

    @Override
    @Transactional
    public void eliminar(final UUID id) {
        jpaRepository.deleteById(id);
    }

    private void resolverFKs(final EmpleadoEntidad entidad) {
        if (entidad.getFinca() != null && entidad.getFinca().getId() != null) {
            entidad.setFinca(fincaJpaRepository.getReferenceById(entidad.getFinca().getId()));
        }
    }
}
