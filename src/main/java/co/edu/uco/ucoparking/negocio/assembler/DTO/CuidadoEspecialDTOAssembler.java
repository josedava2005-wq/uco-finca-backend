package co.edu.uco.ucoparking.negocio.assembler.DTO;

import java.util.UUID;
import co.edu.uco.ucoparking.dominio.AnimalDominio;
import co.edu.uco.ucoparking.dominio.CuidadoEspecialDominio;
import co.edu.uco.ucoparking.dominio.EmpleadoDominio;
import co.edu.uco.ucoparking.dto.CuidadoEspecialDTO;

public final class CuidadoEspecialDTOAssembler {

    private CuidadoEspecialDTOAssembler() {}

    public static CuidadoEspecialDominio toDominio(final CuidadoEspecialDTO dto) {
        AnimalDominio animal = dto.getIdAnimal() != null
                ? AnimalDominio.builder().id(dto.getIdAnimal()).build() : null;
        EmpleadoDominio empleado = dto.getIdEmpleado() != null
                ? EmpleadoDominio.builder().id(dto.getIdEmpleado()).build() : null;
        return CuidadoEspecialDominio.builder()
                .id(dto.getId())
                .tipo(dto.getTipo())
                .fechaHora(dto.getFechaHora())
                .descripcion(dto.getDescripcion())
                .animal(animal)
                .empleado(empleado)
                .build();
    }

    public static CuidadoEspecialDTO toDTO(final CuidadoEspecialDominio dominio) {
        return new CuidadoEspecialDTO(dominio.getId(), dominio.getTipo(), dominio.getFechaHora(), dominio.getDescripcion(), dominio.getAnimal() != null ? dominio.getAnimal().getId() : null, dominio.getEmpleado() != null ? dominio.getEmpleado().getId() : null);
    }
}
