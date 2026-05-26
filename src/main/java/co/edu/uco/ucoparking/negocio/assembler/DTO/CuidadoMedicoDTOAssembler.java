package co.edu.uco.ucoparking.negocio.assembler.DTO;

import java.util.UUID;
import co.edu.uco.ucoparking.dominio.AnimalDominio;
import co.edu.uco.ucoparking.dominio.CuidadoMedicoDominio;
import co.edu.uco.ucoparking.dominio.EmpleadoDominio;
import co.edu.uco.ucoparking.dto.CuidadoMedicoDTO;

public final class CuidadoMedicoDTOAssembler {

    private CuidadoMedicoDTOAssembler() {}

    public static CuidadoMedicoDominio toDominio(final CuidadoMedicoDTO dto) {
        AnimalDominio animal = dto.getIdAnimal() != null
                ? AnimalDominio.builder().id(dto.getIdAnimal()).build() : null;
        EmpleadoDominio empleado = dto.getIdEmpleado() != null
                ? EmpleadoDominio.builder().id(dto.getIdEmpleado()).build() : null;
        return CuidadoMedicoDominio.builder()
                .id(dto.getId())
                .tipo(dto.getTipo())
                .fechaHora(dto.getFechaHora())
                .descripcion(dto.getDescripcion())
                .medicamento(dto.getMedicamento())
                .animal(animal)
                .empleado(empleado)
                .build();
    }

    public static CuidadoMedicoDTO toDTO(final CuidadoMedicoDominio dominio) {
        return new CuidadoMedicoDTO(dominio.getId(), dominio.getTipo(), dominio.getFechaHora(), dominio.getDescripcion(), dominio.getMedicamento(), dominio.getAnimal() != null ? dominio.getAnimal().getId() : null, dominio.getEmpleado() != null ? dominio.getEmpleado().getId() : null);
    }
}
