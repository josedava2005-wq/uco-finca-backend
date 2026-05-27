package co.edu.uco.ucoparking.datos.impl;

import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import co.edu.uco.ucoparking.datos.AnimalDatos;
import co.edu.uco.ucoparking.datos.jpa.AnimalJpaRepository;
import co.edu.uco.ucoparking.datos.jpa.FincaJpaRepository;
import co.edu.uco.ucoparking.entidad.AnimalEntidad;

/**
 * Implementación de AnimalDatos usando JPA / SQL Server.
 *
 * FIX FK (crear/modificar):
 *   Usa FincaJpaRepository.getReferenceById() para obtener un proxy JPA gestionado.
 *
 * RELACIÓN (todo EAGER):
 *   Animal → Finca → LugarFinca → Ciudad → Departamento → País
 */
@Repository
public class AnimalDatosImpl implements AnimalDatos {

    private final AnimalJpaRepository jpaRepository;
    private final FincaJpaRepository fincaJpaRepository;

    public AnimalDatosImpl(
            final AnimalJpaRepository jpaRepository,
            final FincaJpaRepository fincaJpaRepository) {
        this.jpaRepository = jpaRepository;
        this.fincaJpaRepository = fincaJpaRepository;
    }

    @Override
    @Transactional
    public void crear(final AnimalEntidad entidad) {
        resolverFKs(entidad);
        jpaRepository.save(entidad);
    }

    @Override
    public List<AnimalEntidad> consultar(final AnimalEntidad filtro) {
        return jpaRepository.findAll();
    }

    @Override
    @Transactional
    public void modificar(final AnimalEntidad entidad) {
        resolverFKs(entidad);
        jpaRepository.save(entidad);
    }

    @Override
    @Transactional
    public void eliminar(final UUID id) {
        jpaRepository.deleteById(id);
    }

    private void resolverFKs(final AnimalEntidad entidad) {
        if (entidad.getFinca() != null && entidad.getFinca().getId() != null) {
            entidad.setFinca(fincaJpaRepository.getReferenceById(entidad.getFinca().getId()));
        }
    }
}
