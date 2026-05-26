package co.edu.uco.ucoparking.negocio.assembler.DTO;

import java.util.UUID;
import co.edu.uco.ucoparking.dominio.TipoAlmacenDominio;
import co.edu.uco.ucoparking.dto.TipoAlmacenDTO;

public final class TipoAlmacenDTOAssembler {

    private TipoAlmacenDTOAssembler() {}

    public static TipoAlmacenDominio toDominio(final TipoAlmacenDTO dto) {
        return TipoAlmacenDominio.builder()
                .id(dto.getId())
                .nombre(dto.getNombre())
                .descripcion(dto.getDescripcion())
                .build();
    }

    public static TipoAlmacenDTO toDTO(final TipoAlmacenDominio dominio) {
        return new TipoAlmacenDTO(dominio.getId(), dominio.getNombre(), dominio.getDescripcion());
    }
}
