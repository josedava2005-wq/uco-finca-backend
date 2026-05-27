package co.edu.uco.ucoparking.datos.impl;

import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import co.edu.uco.ucoparking.datos.EstadoAnimalDatos;
import co.edu.uco.ucoparking.datos.jpa.AnimalJpaRepository;
import co.edu.uco.ucoparking.datos.jpa.EstadoAnimalJpaRepository;
import co.edu.uco.ucoparking.entidad.EstadoAnimalEntidad;

@Repository
public class EstadoAnimalDatosImpl implements EstadoAnimalDatos {

    private final EstadoAnimalJpaRepository jpaRepository;
    private final AnimalJpaRepository animalJpaRepository;

    public EstadoAnimalDatosImpl(
            final EstadoAnimalJpaRepository jpaRepository,
            final AnimalJpaRepository animalJpaRepository) {
        this.jpaRepository = jpaRepository;
        this.animalJpaRepository = animalJpaRepository;
    }

    @Override
    @Transactional
    public void crear(final EstadoAnimalEntidad entidad) {
        resolverFKs(entidad);
        jpaRepository.save(entidad);
    }

    @Override
    public List<EstadoAnimalEntidad> consultar(final EstadoAnimalEntidad filtro) {
        return jpaRepository.findAll();
    }

    @Override
    @Transactional
    public void modificar(final EstadoAnimalEntidad entidad) {
        resolverFKs(entidad);
        jpaRepository.save(entidad);
    }

    @Override
    @Transactional
    public void eliminar(final UUID id) {
        jpaRepository.deleteById(id);
    }

    private void resolverFKs(final EstadoAnimalEntidad entidad) {
        if (entidad.getAnimal() != null && entidad.getAnimal().getId() != null) {
            entidad.setAnimal(animalJpaRepository.getReferenceById(entidad.getAnimal().getId()));
        }
    }
}
