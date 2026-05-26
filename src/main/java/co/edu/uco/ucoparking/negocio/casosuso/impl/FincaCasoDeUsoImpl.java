package co.edu.uco.ucoparking.negocio.casosuso.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import co.edu.uco.ucoparking.datos.FincaDatos;
import co.edu.uco.ucoparking.dominio.FincaDominio;
import co.edu.uco.ucoparking.negocio.assembler.entidad.FincaEntidadAssembler;
import co.edu.uco.ucoparking.negocio.casosuso.FincaCasoDeUso;
import co.edu.uco.ucoparking.transversal.UtilUUID;

public final class FincaCasoDeUsoImpl implements FincaCasoDeUso {

    private final FincaDatos datos;

    public FincaCasoDeUsoImpl(final FincaDatos datos) {
        this.datos = datos;
    }

    @Override
    public void crear(final FincaDominio dominio) {
        final FincaDominio dominioConId = FincaDominio.builder()
                .id(UtilUUID.generarNuevo())
                .nombre(dominio.getNombre())
                .hectareas(dominio.getHectareas())
                .fechaRegistro(dominio.getFechaRegistro())
                .lugarFinca(dominio.getLugarFinca())
                .build();
        datos.crear(FincaEntidadAssembler.toEntidad(dominioConId));
    }

    @Override
    public List<FincaDominio> consultar(final FincaDominio filtro) {
        return datos.consultar(FincaEntidadAssembler.toEntidad(filtro))
                .stream()
                .map(FincaEntidadAssembler::toDominio)
                .collect(Collectors.toList());
    }

    @Override
    public void modificar(final FincaDominio dominio) {
        datos.modificar(FincaEntidadAssembler.toEntidad(dominio));
    }

    @Override
    public void eliminar(final UUID id) {
        datos.eliminar(id);
    }
}
