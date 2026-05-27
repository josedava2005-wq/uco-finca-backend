package co.edu.uco.ucoparking.datos.impl;

import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import co.edu.uco.ucoparking.datos.RecoleccionDatos;
import co.edu.uco.ucoparking.datos.jpa.AnimalJpaRepository;
import co.edu.uco.ucoparking.datos.jpa.EmpleadoJpaRepository;
import co.edu.uco.ucoparking.datos.jpa.ProductoJpaRepository;
import co.edu.uco.ucoparking.datos.jpa.RecoleccionJpaRepository;
import co.edu.uco.ucoparking.entidad.RecoleccionEntidad;

@Repository
public class RecoleccionDatosImpl implements RecoleccionDatos {

    private final RecoleccionJpaRepository jpaRepository;
    private final ProductoJpaRepository productoJpaRepository;
    private final AnimalJpaRepository animalJpaRepository;
    private final EmpleadoJpaRepository empleadoJpaRepository;

    public RecoleccionDatosImpl(
            final RecoleccionJpaRepository jpaRepository,
            final ProductoJpaRepository productoJpaRepository,
            final AnimalJpaRepository animalJpaRepository,
            final EmpleadoJpaRepository empleadoJpaRepository) {
        this.jpaRepository = jpaRepository;
        this.productoJpaRepository = productoJpaRepository;
        this.animalJpaRepository = animalJpaRepository;
        this.empleadoJpaRepository = empleadoJpaRepository;
    }

    @Override
    @Transactional
    public void crear(final RecoleccionEntidad entidad) {
        resolverFKs(entidad);
        jpaRepository.save(entidad);
    }

    @Override
    public List<RecoleccionEntidad> consultar(final RecoleccionEntidad filtro) {
        return jpaRepository.findAll();
    }

    @Override
    @Transactional
    public void modificar(final RecoleccionEntidad entidad) {
        resolverFKs(entidad);
        jpaRepository.save(entidad);
    }

    @Override
    @Transactional
    public void eliminar(final UUID id) {
        jpaRepository.deleteById(id);
    }

    private void resolverFKs(final RecoleccionEntidad entidad) {
        if (entidad.getProducto() != null && entidad.getProducto().getId() != null) {
            entidad.setProducto(productoJpaRepository.getReferenceById(entidad.getProducto().getId()));
        }
        if (entidad.getAnimal() != null && entidad.getAnimal().getId() != null) {
            entidad.setAnimal(animalJpaRepository.getReferenceById(entidad.getAnimal().getId()));
        }
        if (entidad.getEmpleado() != null && entidad.getEmpleado().getId() != null) {
            entidad.setEmpleado(empleadoJpaRepository.getReferenceById(entidad.getEmpleado().getId()));
        }
    }
}
