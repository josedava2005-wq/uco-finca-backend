package co.edu.uco.ucoparking.negocio.assembler.DTO;

import java.util.UUID;
import co.edu.uco.ucoparking.dominio.EmpleadoDominio;
import co.edu.uco.ucoparking.dominio.FincaDominio;
import co.edu.uco.ucoparking.dto.EmpleadoDTO;

public final class EmpleadoDTOAssembler {

    private EmpleadoDTOAssembler() {}

    public static EmpleadoDominio toDominio(final EmpleadoDTO dto) {
        FincaDominio finca = dto.getIdFinca() != null
                ? FincaDominio.builder().id(dto.getIdFinca()).build() : null;
        return EmpleadoDominio.builder()
                .id(dto.getId())
                .nombre(dto.getNombre())
                .tipoDocumento(dto.getTipoDocumento())
                .numeroDocumento(dto.getNumeroDocumento())
                .cargo(dto.getCargo())
                .telefono(dto.getTelefono())
                .fechaVinculacion(dto.getFechaVinculacion())
                .finca(finca)
                .build();
    }

    public static EmpleadoDTO toDTO(final EmpleadoDominio dominio) {
        return new EmpleadoDTO(dominio.getId(), dominio.getNombre(), dominio.getTipoDocumento(), dominio.getNumeroDocumento(), dominio.getCargo(), dominio.getTelefono(), dominio.getFechaVinculacion(), dominio.getFinca() != null ? dominio.getFinca().getId() : null);
    }
}
