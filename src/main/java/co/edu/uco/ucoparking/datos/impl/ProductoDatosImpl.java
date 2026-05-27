package co.edu.uco.ucoparking.datos.impl;

import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import co.edu.uco.ucoparking.datos.ProductoDatos;
import co.edu.uco.ucoparking.datos.jpa.FincaJpaRepository;
import co.edu.uco.ucoparking.datos.jpa.ProductoJpaRepository;
import co.edu.uco.ucoparking.entidad.ProductoEntidad;

/**
 * Implementación de ProductoDatos usando JPA / SQL Server.
 *
 * FIX FK (crear/modificar):
 *   Usa FincaJpaRepository.getReferenceById() para obtener un proxy JPA gestionado.
 *
 * RELACIÓN (todo EAGER):
 *   Producto → Finca → LugarFinca → Ciudad → Departamento → País
 */
@Repository
public class ProductoDatosImpl implements ProductoDatos {

    private final ProductoJpaRepository jpaRepository;
    private final FincaJpaRepository fincaJpaRepository;

    public ProductoDatosImpl(
            final ProductoJpaRepository jpaRepository,
            final FincaJpaRepository fincaJpaRepository) {
        this.jpaRepository = jpaRepository;
        this.fincaJpaRepository = fincaJpaRepository;
    }

    @Override
    @Transactional
    public void crear(final ProductoEntidad entidad) {
        resolverFKs(entidad);
        jpaRepository.save(entidad);
    }

    @Override
    public List<ProductoEntidad> consultar(final ProductoEntidad filtro) {
        return jpaRepository.findAll();
    }

    @Override
    @Transactional
    public void modificar(final ProductoEntidad entidad) {
        resolverFKs(entidad);
        jpaRepository.save(entidad);
    }

    @Override
    @Transactional
    public void eliminar(final UUID id) {
        jpaRepository.deleteById(id);
    }

    private void resolverFKs(final ProductoEntidad entidad) {
        if (entidad.getFinca() != null && entidad.getFinca().getId() != null) {
            entidad.setFinca(fincaJpaRepository.getReferenceById(entidad.getFinca().getId()));
        }
    }
}
