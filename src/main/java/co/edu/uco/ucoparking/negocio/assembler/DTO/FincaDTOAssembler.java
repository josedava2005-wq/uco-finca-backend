package co.edu.uco.ucoparking.negocio.assembler.DTO;

import java.util.UUID;
import co.edu.uco.ucoparking.dominio.FincaDominio;
import co.edu.uco.ucoparking.dominio.LugarFincaDominio;
import co.edu.uco.ucoparking.dto.FincaDTO;

public final class FincaDTOAssembler {

    private FincaDTOAssembler() {}

    public static FincaDominio toDominio(final FincaDTO dto) {
        LugarFincaDominio lugarFinca = dto.getIdLugarFinca() != null
                ? LugarFincaDominio.builder().id(dto.getIdLugarFinca()).build() : null;
        return FincaDominio.builder()
                .id(dto.getId())
                .nombre(dto.getNombre())
                .hectareas(dto.getHectareas())
                .fechaRegistro(dto.getFechaRegistro())
                .lugarFinca(lugarFinca)
                .build();
    }

    public static FincaDTO toDTO(final FincaDominio dominio) {
        return new FincaDTO(dominio.getId(), dominio.getNombre(), dominio.getHectareas(), dominio.getFechaRegistro(), dominio.getLugarFinca() != null ? dominio.getLugarFinca().getId() : null);
    }
}
