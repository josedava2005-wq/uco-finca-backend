package co.edu.uco.ucoparking.datos.impl;

import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import co.edu.uco.ucoparking.datos.DepartamentoDatos;
import co.edu.uco.ucoparking.datos.jpa.DepartamentoJpaRepository;
import co.edu.uco.ucoparking.datos.jpa.PaisJpaRepository;
import co.edu.uco.ucoparking.entidad.DepartamentoEntidad;

/**
 * Implementación de DepartamentoDatos usando JPA / SQL Server.
 *
 * FIX FK (crear/modificar):
 *   El DepartamentoEntidad recibido del assembler tiene PaisEntidad con solo
 *   el ID seteado (shell transitorio). Hibernate lanzaría TransientPropertyValueException
 *   al hacer persist() sobre ese shell.
 *
 *   Solución: usar paisJpaRepository.getReferenceById(id) que devuelve un proxy
 *   JPA gestionado. El @Transactional asegura que el proxy y el save() corran
 *   en la misma sesión de Hibernate.
 *
 * RELACIÓN:
 *   Departamento → País (EAGER)
 */
@Repository
public class DepartamentoDatosImpl implements DepartamentoDatos {

    private final DepartamentoJpaRepository jpaRepository;
    private final PaisJpaRepository paisJpaRepository;

    public DepartamentoDatosImpl(
            final DepartamentoJpaRepository jpaRepository,
            final PaisJpaRepository paisJpaRepository) {
        this.jpaRepository = jpaRepository;
        this.paisJpaRepository = paisJpaRepository;
    }

    @Override
    @Transactional
    public void crear(final DepartamentoEntidad entidad) {
        resolverFKs(entidad);
        jpaRepository.save(entidad);
    }

    @Override
    public List<DepartamentoEntidad> consultar(final DepartamentoEntidad filtro) {
        return jpaRepository.findAll();
    }

    @Override
    @Transactional
    public void modificar(final DepartamentoEntidad entidad) {
        resolverFKs(entidad);
        jpaRepository.save(entidad);
    }

    @Override
    @Transactional
    public void eliminar(final UUID id) {
        jpaRepository.deleteById(id);
    }

    // Reemplaza los shells transitorios de FK con proxies JPA gestionados.
    private void resolverFKs(final DepartamentoEntidad entidad) {
        if (entidad.getPais() != null && entidad.getPais().getId() != null) {
            entidad.setPais(paisJpaRepository.getReferenceById(entidad.getPais().getId()));
        }
    }
}
