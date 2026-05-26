package co.edu.uco.ucoparking.negocio.assembler.entidad;

import co.edu.uco.ucoparking.dominio.FincaDominio;
import co.edu.uco.ucoparking.dominio.LugarFincaDominio;
import co.edu.uco.ucoparking.entidad.FincaEntidad;
import co.edu.uco.ucoparking.entidad.LugarFincaEntidad;
import co.edu.uco.ucoparking.negocio.assembler.entidad.LugarFincaEntidadAssembler;

public final class FincaEntidadAssembler {

    private FincaEntidadAssembler() {}

    public static FincaEntidad toEntidad(final FincaDominio dominio) {
        LugarFincaEntidad lugarFincaEnt = dominio.getLugarFinca() != null
                ? LugarFincaEntidadAssembler.toEntidad(dominio.getLugarFinca()) : null;
        return new FincaEntidad(dominio.getId(), dominio.getNombre(), dominio.getHectareas(), dominio.getFechaRegistro(), lugarFincaEnt);
    }

    public static FincaDominio toDominio(final FincaEntidad entidad) {
        return FincaDominio.builder()
                .id(entidad.getId())
                .nombre(entidad.getNombre())
                .hectareas(entidad.getHectareas())
                .fechaRegistro(entidad.getFechaRegistro())
                .lugarFinca(entidad.getLugarFinca() != null ? LugarFincaEntidadAssembler.toDominio(entidad.getLugarFinca()) : null)
                .build();
    }
}
