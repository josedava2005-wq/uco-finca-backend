package co.edu.uco.ucoparking.negocio.assembler.entidad;

import co.edu.uco.ucoparking.dominio.CiudadDominio;
import co.edu.uco.ucoparking.dominio.LugarFincaDominio;
import co.edu.uco.ucoparking.entidad.CiudadEntidad;
import co.edu.uco.ucoparking.entidad.LugarFincaEntidad;
import co.edu.uco.ucoparking.negocio.assembler.entidad.CiudadEntidadAssembler;

public final class LugarFincaEntidadAssembler {

    private LugarFincaEntidadAssembler() {}

    public static LugarFincaEntidad toEntidad(final LugarFincaDominio dominio) {
        CiudadEntidad ciudadEnt = dominio.getCiudad() != null
                ? CiudadEntidadAssembler.toEntidad(dominio.getCiudad()) : null;
        return new LugarFincaEntidad(dominio.getId(), dominio.getVereda(), dominio.getSector(), ciudadEnt);
    }

    public static LugarFincaDominio toDominio(final LugarFincaEntidad entidad) {
        return LugarFincaDominio.builder()
                .id(entidad.getId())
                .vereda(entidad.getVereda())
                .sector(entidad.getSector())
                .ciudad(entidad.getCiudad() != null ? CiudadEntidadAssembler.toDominio(entidad.getCiudad()) : null)
                .build();
    }
}
