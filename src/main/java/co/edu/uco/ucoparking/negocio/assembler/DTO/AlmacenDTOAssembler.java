package co.edu.uco.ucoparking.negocio.assembler.DTO;

import java.util.UUID;
import co.edu.uco.ucoparking.dominio.AlmacenDominio;
import co.edu.uco.ucoparking.dominio.FincaDominio;
import co.edu.uco.ucoparking.dominio.TipoAlmacenDominio;
import co.edu.uco.ucoparking.dto.AlmacenDTO;

public final class AlmacenDTOAssembler {

    private AlmacenDTOAssembler() {}

    public static AlmacenDominio toDominio(final AlmacenDTO dto) {
        TipoAlmacenDominio tipoAlmacen = dto.getIdTipoAlmacen() != null
                ? TipoAlmacenDominio.builder().id(dto.getIdTipoAlmacen()).build() : null;
        FincaDominio finca = dto.getIdFinca() != null
                ? FincaDominio.builder().id(dto.getIdFinca()).build() : null;
        return AlmacenDominio.builder()
                .id(dto.getId())
                .nombre(dto.getNombre())
                .capacidadM2(dto.getCapacidadM2())
                .tipoAlmacen(tipoAlmacen)
                .finca(finca)
                .build();
    }

    public static AlmacenDTO toDTO(final AlmacenDominio dominio) {
        return new AlmacenDTO(dominio.getId(), dominio.getNombre(), dominio.getCapacidadM2(), dominio.getTipoAlmacen() != null ? dominio.getTipoAlmacen().getId() : null, dominio.getFinca() != null ? dominio.getFinca().getId() : null);
    }
}
