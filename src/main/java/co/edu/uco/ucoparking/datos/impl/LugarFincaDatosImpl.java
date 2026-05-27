package co.edu.uco.ucoparking.datos.impl;

import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import co.edu.uco.ucoparking.datos.LugarFincaDatos;
import co.edu.uco.ucoparking.datos.jpa.CiudadJpaRepository;
import co.edu.uco.ucoparking.datos.jpa.LugarFincaJpaRepository;
import co.edu.uco.ucoparking.entidad.LugarFincaEntidad;

/**
 * Implementación de LugarFincaDatos usando JPA / SQL Server.
 *
 * FIX FK (crear/modificar):
 *   Usa CiudadJpaRepository.getReferenceById() para obtener un proxy
 *   JPA gestionado en lugar de un shell transitorio.
 *
 * RELACIÓN:
 *   LugarFinca → Ciudad (EAGER) → Departamento (EAGER) → País (EAGER)
 */
@Repository
public class LugarFincaDatosImpl implements LugarFincaDatos {

    private final LugarFincaJpaRepository jpaRepository;
    private final CiudadJpaRepository ciudadJpaRepository;

    public LugarFincaDatosImpl(
            final LugarFincaJpaRepository jpaRepository,
            final CiudadJpaRepository ciudadJpaRepository) {
        this.jpaRepository = jpaRepository;
        this.ciudadJpaRepository = ciudadJpaRepository;
    }

    @Override
    @Transactional
    public void crear(final LugarFincaEntidad entidad) {
        resolverFKs(entidad);
        jpaRepository.save(entidad);
    }

    @Override
    public List<LugarFincaEntidad> consultar(final LugarFincaEntidad filtro) {
        return jpaRepository.findAll();
    }

    @Override
    @Transactional
    public void modificar(final LugarFincaEntidad entidad) {
        resolverFKs(entidad);
        jpaRepository.save(entidad);
    }

    @Override
    @Transactional
    public void eliminar(final UUID id) {
        jpaRepository.deleteById(id);
    }

    private void resolverFKs(final LugarFincaEntidad entidad) {
        if (entidad.getCiudad() != null && entidad.getCiudad().getId() != null) {
            entidad.setCiudad(ciudadJpaRepository.getReferenceById(entidad.getCiudad().getId()));
        }
    }
}
