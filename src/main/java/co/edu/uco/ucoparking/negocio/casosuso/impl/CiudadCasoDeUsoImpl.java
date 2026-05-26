package co.edu.uco.ucoparking.negocio.casosuso.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import co.edu.uco.ucoparking.datos.CiudadDatos;
import co.edu.uco.ucoparking.dominio.CiudadDominio;
import co.edu.uco.ucoparking.negocio.assembler.entidad.CiudadEntidadAssembler;
import co.edu.uco.ucoparking.negocio.casosuso.CiudadCasoDeUso;
import co.edu.uco.ucoparking.transversal.UtilUUID;

public final class CiudadCasoDeUsoImpl implements CiudadCasoDeUso {

    private final CiudadDatos datos;

    public CiudadCasoDeUsoImpl(final CiudadDatos datos) {
        this.datos = datos;
    }

    @Override
    public void crear(final CiudadDominio dominio) {
        final CiudadDominio dominioConId = CiudadDominio.builder()
                .id(UtilUUID.generarNuevo())
                .nombre(dominio.getNombre())
                .departamento(dominio.getDepartamento())
                .build();
        datos.crear(CiudadEntidadAssembler.toEntidad(dominioConId));
    }

    @Override
    public List<CiudadDominio> consultar(final CiudadDominio filtro) {
        return datos.consultar(CiudadEntidadAssembler.toEntidad(filtro))
                .stream()
                .map(CiudadEntidadAssembler::toDominio)
                .collect(Collectors.toList());
    }

    @Override
    public void modificar(final CiudadDominio dominio) {
        datos.modificar(CiudadEntidadAssembler.toEntidad(dominio));
    }

    @Override
    public void eliminar(final UUID id) {
        datos.eliminar(id);
    }
}
