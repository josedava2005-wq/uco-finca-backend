package co.edu.uco.ucoparking.negocio.assembler.DTO;

import java.util.UUID;
import co.edu.uco.ucoparking.dominio.EmpleadoDominio;
import co.edu.uco.ucoparking.dominio.FincaDominio;
import co.edu.uco.ucoparking.dominio.TareaDominio;
import co.edu.uco.ucoparking.dto.TareaDTO;

public final class TareaDTOAssembler {

    private TareaDTOAssembler() {}

    public static TareaDominio toDominio(final TareaDTO dto) {
        EmpleadoDominio empleado = dto.getIdEmpleado() != null
                ? EmpleadoDominio.builder().id(dto.getIdEmpleado()).build() : null;
        FincaDominio finca = dto.getIdFinca() != null
                ? FincaDominio.builder().id(dto.getIdFinca()).build() : null;
        return TareaDominio.builder()
                .id(dto.getId())
                .descripcion(dto.getDescripcion())
                .fechaHora(dto.getFechaHora())
                .estado(dto.getEstado())
                .empleado(empleado)
                .finca(finca)
                .build();
    }

    public static TareaDTO toDTO(final TareaDominio dominio) {
        return new TareaDTO(dominio.getId(), dominio.getDescripcion(), dominio.getFechaHora(), dominio.getEstado(), dominio.getEmpleado() != null ? dominio.getEmpleado().getId() : null, dominio.getFinca() != null ? dominio.getFinca().getId() : null);
    }
}
