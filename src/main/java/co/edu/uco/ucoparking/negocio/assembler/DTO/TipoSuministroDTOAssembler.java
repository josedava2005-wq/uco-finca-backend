package co.edu.uco.ucoparking.negocio.assembler.DTO;

import java.util.UUID;
import co.edu.uco.ucoparking.dominio.TipoSuministroDominio;
import co.edu.uco.ucoparking.dto.TipoSuministroDTO;

public final class TipoSuministroDTOAssembler {

    private TipoSuministroDTOAssembler() {}

    public static TipoSuministroDominio toDominio(final TipoSuministroDTO dto) {
        return TipoSuministroDominio.builder()
                .id(dto.getId())
                .nombre(dto.getNombre())
                .descripcion(dto.getDescripcion())
                .build();
    }

    public static TipoSuministroDTO toDTO(final TipoSuministroDominio dominio) {
        return new TipoSuministroDTO(dominio.getId(), dominio.getNombre(), dominio.getDescripcion());
    }
}
