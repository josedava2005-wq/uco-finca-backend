package co.edu.uco.ucoparking.negocio.casosuso.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import co.edu.uco.ucoparking.datos.ProveedorDatos;
import co.edu.uco.ucoparking.dominio.ProveedorDominio;
import co.edu.uco.ucoparking.negocio.assembler.entidad.ProveedorEntidadAssembler;
import co.edu.uco.ucoparking.negocio.casosuso.ProveedorCasoDeUso;
import co.edu.uco.ucoparking.transversal.UtilUUID;

public final class ProveedorCasoDeUsoImpl implements ProveedorCasoDeUso {

    private final ProveedorDatos datos;

    public ProveedorCasoDeUsoImpl(final ProveedorDatos datos) {
        this.datos = datos;
    }

    @Override
    public void crear(final ProveedorDominio dominio) {
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
        datos.modificar(ProveedorEntidadAssembler.toEntidad(dominio));
    }

    @Override
    public void eliminar(final UUID id) {
        datos.eliminar(id);
    }
}
