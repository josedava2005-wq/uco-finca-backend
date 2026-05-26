package co.edu.uco.ucoparking.negocio.assembler.DTO;

import java.util.UUID;
import co.edu.uco.ucoparking.dominio.CiudadDominio;
import co.edu.uco.ucoparking.dominio.LugarFincaDominio;
import co.edu.uco.ucoparking.dto.LugarFincaDTO;

public final class LugarFincaDTOAssembler {

    private LugarFincaDTOAssembler() {}

    public static LugarFincaDominio toDominio(final LugarFincaDTO dto) {
        CiudadDominio ciudad = dto.getIdCiudad() != null
                ? CiudadDominio.builder().id(dto.getIdCiudad()).build() : null;
        return LugarFincaDominio.builder()
                .id(dto.getId())
                .vereda(dto.getVereda())
                .sector(dto.getSector())
                .ciudad(ciudad)
                .build();
    }

    public static LugarFincaDTO toDTO(final LugarFincaDominio dominio) {
        return new LugarFincaDTO(dominio.getId(), dominio.getVereda(), dominio.getSector(), dominio.getCiudad() != null ? dominio.getCiudad().getId() : null);
    }
}
