package co.edu.uco.ucoparking.negocio.assembler.entidad;

import co.edu.uco.ucoparking.dominio.AnimalDominio;
import co.edu.uco.ucoparking.dominio.EstadoAnimalDominio;
import co.edu.uco.ucoparking.entidad.AnimalEntidad;
import co.edu.uco.ucoparking.entidad.EstadoAnimalEntidad;
import co.edu.uco.ucoparking.negocio.assembler.entidad.AnimalEntidadAssembler;

public final class EstadoAnimalEntidadAssembler {

    private EstadoAnimalEntidadAssembler() {}

    public static EstadoAnimalEntidad toEntidad(final EstadoAnimalDominio dominio) {
        AnimalEntidad animalEnt = dominio.getAnimal() != null
                ? AnimalEntidadAssembler.toEntidad(dominio.getAnimal()) : null;
        return new EstadoAnimalEntidad(dominio.getId(), dominio.getEstado(), dominio.getFechaRegistro(), dominio.getObservacion(), animalEnt);
    }

    public static EstadoAnimalDominio toDominio(final EstadoAnimalEntidad entidad) {
        return EstadoAnimalDominio.builder()
                .id(entidad.getId())
                .estado(entidad.getEstado())
                .fechaRegistro(entidad.getFechaRegistro())
                .observacion(entidad.getObservacion())
                .animal(entidad.getAnimal() != null ? AnimalEntidadAssembler.toDominio(entidad.getAnimal()) : null)
                .build();
    }
}
