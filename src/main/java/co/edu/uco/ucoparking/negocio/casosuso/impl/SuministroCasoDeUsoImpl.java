package co.edu.uco.ucoparking.negocio.casosuso.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import co.edu.uco.ucoparking.datos.SuministroDatos;
import co.edu.uco.ucoparking.dominio.SuministroDominio;
import co.edu.uco.ucoparking.negocio.assembler.entidad.SuministroEntidadAssembler;
import co.edu.uco.ucoparking.negocio.casosuso.SuministroCasoDeUso;
import co.edu.uco.ucoparking.transversal.UtilTexto;
import co.edu.uco.ucoparking.transversal.UtilUUID;
import co.edu.uco.ucoparking.transversal.excepciones.NegocioException;

public final class SuministroCasoDeUsoImpl implements SuministroCasoDeUso {

    private final SuministroDatos datos;

    public SuministroCasoDeUsoImpl(final SuministroDatos datos) {
        this.datos = datos;
    }

    @Override
    public void crear(final SuministroDominio dominio) {
        validarCamposObligatorios(dominio);
        final SuministroDominio dominioConId = SuministroDominio.builder()
                .id(UtilUUID.generarNuevo())
                .nombre(dominio.getNombre())
                .cantidad(dominio.getCantidad())
                .unidadMedida(dominio.getUnidadMedida())
                .tipoSuministro(dominio.getTipoSuministro())
                .almacen(dominio.getAlmacen())
                .proveedor(dominio.getProveedor())
                .build();
        datos.crear(SuministroEntidadAssembler.toEntidad(dominioConId));
    }

    @Override
    public List<SuministroDominio> consultar(final SuministroDominio filtro) {
        return datos.consultar(SuministroEntidadAssembler.toEntidad(filtro))
                .stream()
                .map(SuministroEntidadAssembler::toDominio)
                .collect(Collectors.toList());
    }

    @Override
    public void modificar(final SuministroDominio dominio) {
        if (dominio.getId() == null) {
            throw new NegocioException(
                    "SuministroCasoDeUsoImpl.modificar: el id del suministro es obligatorio.",
                    "El id del suministro es obligatorio para modificar.");
        }
        validarCamposObligatorios(dominio);
        datos.modificar(SuministroEntidadAssembler.toEntidad(dominio));
    }

    @Override
    public void eliminar(final UUID id) {
        if (id == null) {
            throw new NegocioException(
                    "SuministroCasoDeUsoImpl.eliminar: el id del suministro es obligatorio.",
                    "El id del suministro es obligatorio para eliminar.");
        }
        datos.eliminar(id);
    }

    private void validarCamposObligatorios(final SuministroDominio dominio) {
        if (UtilTexto.esNuloOVacio(dominio.getNombre())) {
            throw new NegocioException(
                    "SuministroCasoDeUsoImpl: el nombre del suministro es obligatorio.",
                    "El nombre del suministro es obligatorio.");
        }
        if (dominio.getTipoSuministro() == null || dominio.getTipoSuministro().getId() == null) {
            throw new NegocioException(
                    "SuministroCasoDeUsoImpl: el tipo de suministro es obligatorio.",
                    "El tipo de suministro es obligatorio.");
        }
        if (dominio.getAlmacen() == null || dominio.getAlmacen().getId() == null) {
            throw new NegocioException(
                    "SuministroCasoDeUsoImpl: el almacen del suministro es obligatorio.",
                    "El almacen del suministro es obligatorio.");
        }
        if (dominio.getProveedor() == null || dominio.getProveedor().getId() == null) {
            throw new NegocioException(
                    "SuministroCasoDeUsoImpl: el proveedor del suministro es obligatorio.",
                    "El proveedor del suministro es obligatorio.");
        }
    }
}
