package co.edu.uco.ucoparking.negocio.casosuso.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import co.edu.uco.ucoparking.datos.TareaDatos;
import co.edu.uco.ucoparking.dominio.TareaDominio;
import co.edu.uco.ucoparking.negocio.assembler.entidad.TareaEntidadAssembler;
import co.edu.uco.ucoparking.negocio.casosuso.TareaCasoDeUso;
import co.edu.uco.ucoparking.transversal.UtilTexto;
import co.edu.uco.ucoparking.transversal.UtilUUID;
import co.edu.uco.ucoparking.transversal.excepciones.NegocioException;

public final class TareaCasoDeUsoImpl implements TareaCasoDeUso {

    private final TareaDatos datos;

    public TareaCasoDeUsoImpl(final TareaDatos datos) {
        this.datos = datos;
    }

    @Override
    public void crear(final TareaDominio dominio) {
        validarCamposObligatorios(dominio);
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
        if (dominio.getId() == null) {
            throw new NegocioException(
                    "TareaCasoDeUsoImpl.modificar: el id de la tarea es obligatorio.",
                    "El id de la tarea es obligatorio para modificar.");
        }
        validarCamposObligatorios(dominio);
        datos.modificar(TareaEntidadAssembler.toEntidad(dominio));
    }

    @Override
    public void eliminar(final UUID id) {
        if (id == null) {
            throw new NegocioException(
                    "TareaCasoDeUsoImpl.eliminar: el id de la tarea es obligatorio.",
                    "El id de la tarea es obligatorio para eliminar.");
        }
        datos.eliminar(id);
    }

    private void validarCamposObligatorios(final TareaDominio dominio) {
        if (UtilTexto.esNuloOVacio(dominio.getDescripcion())) {
            throw new NegocioException(
                    "TareaCasoDeUsoImpl: la descripcion de la tarea es obligatoria.",
                    "La descripcion de la tarea es obligatoria.");
        }
        if (dominio.getEmpleado() == null || dominio.getEmpleado().getId() == null) {
            throw new NegocioException(
                    "TareaCasoDeUsoImpl: el empleado asignado a la tarea es obligatorio.",
                    "El empleado asignado a la tarea es obligatorio.");
        }
        if (dominio.getFinca() == null || dominio.getFinca().getId() == null) {
            throw new NegocioException(
                    "TareaCasoDeUsoImpl: la finca de la tarea es obligatoria.",
                    "La finca de la tarea es obligatoria.");
        }
    }
}
