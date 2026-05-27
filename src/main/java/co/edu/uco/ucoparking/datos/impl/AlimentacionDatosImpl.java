package co.edu.uco.ucoparking.datos.impl;

import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import co.edu.uco.ucoparking.datos.AlimentacionDatos;
import co.edu.uco.ucoparking.datos.jpa.AlimentacionJpaRepository;
import co.edu.uco.ucoparking.datos.jpa.AnimalJpaRepository;
import co.edu.uco.ucoparking.datos.jpa.EmpleadoJpaRepository;
import co.edu.uco.ucoparking.entidad.AlimentacionEntidad;

@Repository
public class AlimentacionDatosImpl implements AlimentacionDatos {

    private final AlimentacionJpaRepository jpaRepository;
    private final AnimalJpaRepository animalJpaRepository;
    private final EmpleadoJpaRepository empleadoJpaRepository;

    public AlimentacionDatosImpl(
            final AlimentacionJpaRepository jpaRepository,
            final AnimalJpaRepository animalJpaRepository,
            final EmpleadoJpaRepository empleadoJpaRepository) {
        this.jpaRepository = jpaRepository;
        this.animalJpaRepository = animalJpaRepository;
        this.empleadoJpaRepository = empleadoJpaRepository;
    }

    @Override
    @Transactional
    public void crear(final AlimentacionEntidad entidad) {
        resolverFKs(entidad);
        jpaRepository.save(entidad);
    }

    @Override
    public List<AlimentacionEntidad> consultar(final AlimentacionEntidad filtro) {
        return jpaRepository.findAll();
    }

    @Override
    @Transactional
    public void modificar(final AlimentacionEntidad entidad) {
        resolverFKs(entidad);
        jpaRepository.save(entidad);
    }

    @Override
    @Transactional
    public void eliminar(final UUID id) {
        jpaRepository.deleteById(id);
    }

    private void resolverFKs(final AlimentacionEntidad entidad) {
        if (entidad.getAnimal() != null && entidad.getAnimal().getId() != null) {
            entidad.setAnimal(animalJpaRepository.getReferenceById(entidad.getAnimal().getId()));
        }
        if (entidad.getEmpleado() != null && entidad.getEmpleado().getId() != null) {
            entidad.setEmpleado(empleadoJpaRepository.getReferenceById(entidad.getEmpleado().getId()));
        }
    }
}
