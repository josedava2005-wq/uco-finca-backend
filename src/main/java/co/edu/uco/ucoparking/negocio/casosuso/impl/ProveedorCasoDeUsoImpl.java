package co.edu.uco.ucoparking.negocio.casosuso.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import co.edu.uco.ucoparking.datos.ProveedorDatos;
import co.edu.uco.ucoparking.dominio.ProveedorDominio;
import co.edu.uco.ucoparking.negocio.assembler.entidad.ProveedorEntidadAssembler;
import co.edu.uco.ucoparking.negocio.casosuso.ProveedorCasoDeUso;
import co.edu.uco.ucoparking.transversal.UtilTexto;
import co.edu.uco.ucoparking.transversal.UtilUUID;
import co.edu.uco.ucoparking.transversal.excepciones.NegocioException;

public final class ProveedorCasoDeUsoImpl implements ProveedorCasoDeUso {

    private final ProveedorDatos datos;

    public ProveedorCasoDeUsoImpl(final ProveedorDatos datos) {
        this.datos = datos;
    }

    @Override
    public void crear(final ProveedorDominio dominio) {
        validarCamposObligatorios(dominio);
        final ProveedorDominio dominioConId = ProveedorDominio.builder()
                .id(UtilUUID.generarNuevo())
                .tipoDocumento(dominio.getTipoDocumento())
                .numeroDocumento(dominio.getNumeroDocumento())
                .nombre(dominio.getNombre())
                .correo(dominio.getCorreo())
                .telefono(dominio.getTelefono())
                .direccion(dominio.getDireccion())
                .build();
        datos.crear(ProveedorEntidadAssembler.toEntidad(dominioConId));
    }

    @Override
    public List<ProveedorDominio> consultar(final ProveedorDominio filtro) {
        return datos.consultar(ProveedorEntidadAssembler.toEntidad(filtro))
                .stream()
                .map(ProveedorEntidadAssembler::toDominio)
                .collect(Collectors.toList());
    }

    @Override
    public void modificar(final ProveedorDominio dominio) {
        if (dominio.getId() == null) {
            throw new NegocioException(
                    "ProveedorCasoDeUsoImpl.modificar: el id del proveedor es obligatorio.",
                    "El id del proveedor es obligatorio para modificar.");
        }
        validarCamposObligatorios(dominio);
        datos.modificar(ProveedorEntidadAssembler.toEntidad(dominio));
    }

    @Override
    public void eliminar(final UUID id) {
        if (id == null) {
            throw new NegocioException(
                    "ProveedorCasoDeUsoImpl.eliminar: el id del proveedor es obligatorio.",
                    "El id del proveedor es obligatorio para eliminar.");
        }
        datos.eliminar(id);
    }

    private void validarCamposObligatorios(final ProveedorDominio dominio) {
        if (UtilTexto.esNuloOVacio(dominio.getNombre())) {
            throw new NegocioException(
                    "ProveedorCasoDeUsoImpl: el nombre del proveedor es obligatorio.",
                    "El nombre del proveedor es obligatorio.");
        }
        if (UtilTexto.esNuloOVacio(dominio.getTipoDocumento())) {
            throw new NegocioException(
                    "ProveedorCasoDeUsoImpl: el tipo de documento del proveedor es obligatorio.",
                    "El tipo de documento del proveedor es obligatorio.");
        }
        if (UtilTexto.esNuloOVacio(dominio.getNumeroDocumento())) {
            throw new NegocioException(
                    "ProveedorCasoDeUsoImpl: el numero de documento del proveedor es obligatorio.",
                    "El numero de documento del proveedor es obligatorio.");
        }
    }
}
