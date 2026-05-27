package co.edu.uco.ucoparking.datos.impl;

import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import co.edu.uco.ucoparking.datos.FincaDatos;
import co.edu.uco.ucoparking.datos.jpa.FincaJpaRepository;
import co.edu.uco.ucoparking.datos.jpa.LugarFincaJpaRepository;
import co.edu.uco.ucoparking.entidad.FincaEntidad;

/**
 * Implementación de FincaDatos usando JPA / SQL Server.
 *
 * FIX FK (crear/modificar):
 *   Usa LugarFincaJpaRepository.getReferenceById() para obtener un proxy
 *   JPA gestionado en lugar de un shell transitorio.
 *
 * RELACIÓN (todo EAGER):
 *   Finca → LugarFinca → Ciudad → Departamento → País
 */
@Repository
public class FincaDatosImpl implements FincaDatos {

    private final FincaJpaRepository jpaRepository;
    private final LugarFincaJpaRepository lugarFincaJpaRepository;

    public FincaDatosImpl(
            final FincaJpaRepository jpaRepository,
            final LugarFincaJpaRepository lugarFincaJpaRepository) {
        this.jpaRepository = jpaRepository;
        this.lugarFincaJpaRepository = lugarFincaJpaRepository;
    }

    @Override
    @Transactional
    public void crear(final FincaEntidad entidad) {
        resolverFKs(entidad);
        jpaRepository.save(entidad);
    }

    @Override
    public List<FincaEntidad> consultar(final FincaEntidad filtro) {
        return jpaRepository.findAll();
    }

    @Override
    @Transactional
    public void modificar(final FincaEntidad entidad) {
        resolverFKs(entidad);
        jpaRepository.save(entidad);
    }

    @Override
    @Transactional
    public void eliminar(final UUID id) {
        jpaRepository.deleteById(id);
    }

    private void resolverFKs(final FincaEntidad entidad) {
        if (entidad.getLugarFinca() != null && entidad.getLugarFinca().getId() != null) {
            entidad.setLugarFinca(
                    lugarFincaJpaRepository.getReferenceById(entidad.getLugarFinca().getId()));
        }
    }
}
