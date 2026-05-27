package co.edu.uco.ucoparking.datos.impl;

import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import co.edu.uco.ucoparking.datos.ClienteDatos;
import co.edu.uco.ucoparking.datos.jpa.CiudadJpaRepository;
import co.edu.uco.ucoparking.datos.jpa.ClienteJpaRepository;
import co.edu.uco.ucoparking.entidad.ClienteEntidad;

/**
 * Implementación de ClienteDatos usando JPA / SQL Server.
 *
 * FIX FK (crear/modificar):
 *   Usa CiudadJpaRepository.getReferenceById() para obtener un proxy
 *   JPA gestionado en lugar de un shell transitorio.
 *
 * RELACIÓN:
 *   Cliente → Ciudad (EAGER) → Departamento (EAGER) → País (EAGER)
 */
@Repository
public class ClienteDatosImpl implements ClienteDatos {

    private final ClienteJpaRepository jpaRepository;
    private final CiudadJpaRepository ciudadJpaRepository;

    public ClienteDatosImpl(
            final ClienteJpaRepository jpaRepository,
            final CiudadJpaRepository ciudadJpaRepository) {
        this.jpaRepository = jpaRepository;
        this.ciudadJpaRepository = ciudadJpaRepository;
    }

    @Override
    @Transactional
    public void crear(final ClienteEntidad entidad) {
        resolverFKs(entidad);
        jpaRepository.save(entidad);
    }

    @Override
    public List<ClienteEntidad> consultar(final ClienteEntidad filtro) {
        return jpaRepository.findAll();
    }

    @Override
    @Transactional
    public void modificar(final ClienteEntidad entidad) {
        resolverFKs(entidad);
        jpaRepository.save(entidad);
    }

    @Override
    @Transactional
    public void eliminar(final UUID id) {
        jpaRepository.deleteById(id);
    }

    private void resolverFKs(final ClienteEntidad entidad) {
        if (entidad.getCiudad() != null && entidad.getCiudad().getId() != null) {
            entidad.setCiudad(ciudadJpaRepository.getReferenceById(entidad.getCiudad().getId()));
        }
    }
}
