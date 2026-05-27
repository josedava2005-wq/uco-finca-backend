package co.edu.uco.ucoparking.datos.impl;

import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import co.edu.uco.ucoparking.datos.CiudadDatos;
import co.edu.uco.ucoparking.datos.jpa.CiudadJpaRepository;
import co.edu.uco.ucoparking.datos.jpa.DepartamentoJpaRepository;
import co.edu.uco.ucoparking.entidad.CiudadEntidad;

/**
 * Implementación de CiudadDatos usando JPA / SQL Server.
 *
 * FIX FK (crear/modificar):
 *   Usa DepartamentoJpaRepository.getReferenceById() para obtener un proxy
 *   JPA gestionado en lugar de un shell transitorio.
 *   @Transactional asegura que proxy y save() corran en la misma sesión.
 *
 * RELACIÓN:
 *   Ciudad → Departamento (EAGER) → País (EAGER)
 */
@Repository
public class CiudadDatosImpl implements CiudadDatos {

    private final CiudadJpaRepository jpaRepository;
    private final DepartamentoJpaRepository departamentoJpaRepository;

    public CiudadDatosImpl(
            final CiudadJpaRepository jpaRepository,
            final DepartamentoJpaRepository departamentoJpaRepository) {
        this.jpaRepository = jpaRepository;
        this.departamentoJpaRepository = departamentoJpaRepository;
    }

    @Override
    @Transactional
    public void crear(final CiudadEntidad entidad) {
        resolverFKs(entidad);
        jpaRepository.save(entidad);
    }

    @Override
    public List<CiudadEntidad> consultar(final CiudadEntidad filtro) {
        return jpaRepository.findAll();
    }

    @Override
    @Transactional
    public void modificar(final CiudadEntidad entidad) {
        resolverFKs(entidad);
        jpaRepository.save(entidad);
    }

    @Override
    @Transactional
    public void eliminar(final UUID id) {
        jpaRepository.deleteById(id);
    }

    private void resolverFKs(final CiudadEntidad entidad) {
        if (entidad.getDepartamento() != null && entidad.getDepartamento().getId() != null) {
            entidad.setDepartamento(
                    departamentoJpaRepository.getReferenceById(entidad.getDepartamento().getId()));
        }
    }
}
