package co.edu.uco.ucoparking.negocio.assembler.DTO;

import java.util.UUID;
import co.edu.uco.ucoparking.dominio.AnimalDominio;
import co.edu.uco.ucoparking.dominio.EstadoAnimalDominio;
import co.edu.uco.ucoparking.dto.EstadoAnimalDTO;

public final class EstadoAnimalDTOAssembler {

    private EstadoAnimalDTOAssembler() {}

    public static EstadoAnimalDominio toDominio(final EstadoAnimalDTO dto) {
        AnimalDominio animal = dto.getIdAnimal() != null
                ? AnimalDominio.builder().id(dto.getIdAnimal()).build() : null;
        return EstadoAnimalDominio.builder()
                .id(dto.getId())
                .estado(dto.getEstado())
                .fechaRegistro(dto.getFechaRegistro())
                .observacion(dto.getObservacion())
                .animal(animal)
                .build();
    }

    public static EstadoAnimalDTO toDTO(final EstadoAnimalDominio dominio) {
        return new EstadoAnimalDTO(dominio.getId(), dominio.getEstado(), dominio.getFechaRegistro(), dominio.getObservacion(), dominio.getAnimal() != null ? dominio.getAnimal().getId() : null);
    }
}
