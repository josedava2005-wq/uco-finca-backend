package co.edu.uco.ucoparking.negocio.casosuso.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import co.edu.uco.ucoparking.datos.TareaDatos;
import co.edu.uco.ucoparking.dominio.TareaDominio;
import co.edu.uco.ucoparking.negocio.assembler.entidad.TareaEntidadAssembler;
import co.edu.uco.ucoparking.negocio.casosuso.TareaCasoDeUso;
import co.edu.uco.ucoparking.transversal.UtilUUID;

public final class TareaCasoDeUsoImpl implements TareaCasoDeUso {

    private final TareaDatos datos;

    public TareaCasoDeUsoImpl(final TareaDatos datos) {
        this.datos = datos;
    }

    @Override
    public void crear(final TareaDominio dominio) {
        final TareaDominio dominioConId = TareaDominio.builder()
                .id(UtilUUID.generarNuevo())
                .descripcion(dominio.getDescripcion())
                .fechaHora(dominio.getFechaHora())
                .estado(dominio.getEstado())
                .empleado(dominio.getEmpleado())
                .finca(dominio.getFinca())
                .build();
        datos.crear(TareaEntidadAssembler.toEntidad(dominioConId));
    }

    @Override
    public List<TareaDominio> consultar(final TareaDominio filtro) {
        return datos.consultar(TareaEntidadAssembler.toEntidad(filtro))
                .stream()
                .map(TareaEntidadAssembler::toDominio)
                .collect(Collectors.toList());
    }

    @Override
    public void modificar(final TareaDominio dominio) {
        datos.modificar(TareaEntidadAssembler.toEntidad(dominio));
    }

    @Override
    public void eliminar(final UUID id) {
        datos.eliminar(id);
    }
}
