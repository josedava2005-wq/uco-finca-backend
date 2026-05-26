package co.edu.uco.ucoparking.negocio.assembler.DTO;

import java.util.UUID;
import co.edu.uco.ucoparking.dominio.AlimentacionDominio;
import co.edu.uco.ucoparking.dominio.AnimalDominio;
import co.edu.uco.ucoparking.dominio.EmpleadoDominio;
import co.edu.uco.ucoparking.dto.AlimentacionDTO;

public final class AlimentacionDTOAssembler {

    private AlimentacionDTOAssembler() {}

    public static AlimentacionDominio toDominio(final AlimentacionDTO dto) {
        AnimalDominio animal = dto.getIdAnimal() != null
                ? AnimalDominio.builder().id(dto.getIdAnimal()).build() : null;
        EmpleadoDominio empleado = dto.getIdEmpleado() != null
                ? EmpleadoDominio.builder().id(dto.getIdEmpleado()).build() : null;
        return AlimentacionDominio.builder()
                .id(dto.getId())
                .fechaHora(dto.getFechaHora())
                .cantidad(dto.getCantidad())
                .unidadMedida(dto.getUnidadMedida())
                .tipoAlimento(dto.getTipoAlimento())
                .animal(animal)
                .empleado(empleado)
                .build();
    }

    public static AlimentacionDTO toDTO(final AlimentacionDominio dominio) {
        return new AlimentacionDTO(dominio.getId(), dominio.getFechaHora(), dominio.getCantidad(), dominio.getUnidadMedida(), dominio.getTipoAlimento(), dominio.getAnimal() != null ? dominio.getAnimal().getId() : null, dominio.getEmpleado() != null ? dominio.getEmpleado().getId() : null);
    }
}
