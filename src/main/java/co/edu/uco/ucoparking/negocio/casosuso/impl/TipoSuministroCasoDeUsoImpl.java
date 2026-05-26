package co.edu.uco.ucoparking.negocio.casosuso.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import co.edu.uco.ucoparking.datos.TipoSuministroDatos;
import co.edu.uco.ucoparking.dominio.TipoSuministroDominio;
import co.edu.uco.ucoparking.negocio.assembler.entidad.TipoSuministroEntidadAssembler;
import co.edu.uco.ucoparking.negocio.casosuso.TipoSuministroCasoDeUso;
import co.edu.uco.ucoparking.transversal.UtilUUID;

public final class TipoSuministroCasoDeUsoImpl implements TipoSuministroCasoDeUso {

    private final TipoSuministroDatos datos;

    public TipoSuministroCasoDeUsoImpl(final TipoSuministroDatos datos) {
        this.datos = datos;
    }

    @Override
    public void crear(final TipoSuministroDominio dominio) {
        final TipoSuministroDominio dominioConId = TipoSuministroDominio.builder()
                .id(UtilUUID.generarNuevo())
                .nombre(dominio.getNombre())
                .descripcion(dominio.getDescripcion())
                .build();
        datos.crear(TipoSuministroEntidadAssembler.toEntidad(dominioConId));
    }

    @Override
    public List<TipoSuministroDominio> consultar(final TipoSuministroDominio filtro) {
        return datos.consultar(TipoSuministroEntidadAssembler.toEntidad(filtro))
                .stream()
                .map(TipoSuministroEntidadAssembler::toDominio)
                .collect(Collectors.toList());
    }

    @Override
    public void modificar(final TipoSuministroDominio dominio) {
        datos.modificar(TipoSuministroEntidadAssembler.toEntidad(dominio));
    }

    @Override
    public void eliminar(final UUID id) {
        datos.eliminar(id);
    }
}
