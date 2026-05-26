package co.edu.uco.ucoparking.negocio.casosuso.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import co.edu.uco.ucoparking.datos.LugarFincaDatos;
import co.edu.uco.ucoparking.dominio.LugarFincaDominio;
import co.edu.uco.ucoparking.negocio.assembler.entidad.LugarFincaEntidadAssembler;
import co.edu.uco.ucoparking.negocio.casosuso.LugarFincaCasoDeUso;
import co.edu.uco.ucoparking.transversal.UtilUUID;

public final class LugarFincaCasoDeUsoImpl implements LugarFincaCasoDeUso {

    private final LugarFincaDatos datos;

    public LugarFincaCasoDeUsoImpl(final LugarFincaDatos datos) {
        this.datos = datos;
    }

    @Override
    public void crear(final LugarFincaDominio dominio) {
        final LugarFincaDominio dominioConId = LugarFincaDominio.builder()
                .id(UtilUUID.generarNuevo())
                .vereda(dominio.getVereda())
                .sector(dominio.getSector())
                .ciudad(dominio.getCiudad())
                .build();
        datos.crear(LugarFincaEntidadAssembler.toEntidad(dominioConId));
    }

    @Override
    public List<LugarFincaDominio> consultar(final LugarFincaDominio filtro) {
        return datos.consultar(LugarFincaEntidadAssembler.toEntidad(filtro))
                .stream()
                .map(LugarFincaEntidadAssembler::toDominio)
                .collect(Collectors.toList());
    }

    @Override
    public void modificar(final LugarFincaDominio dominio) {
        datos.modificar(LugarFincaEntidadAssembler.toEntidad(dominio));
    }

    @Override
    public void eliminar(final UUID id) {
        datos.eliminar(id);
    }
}
