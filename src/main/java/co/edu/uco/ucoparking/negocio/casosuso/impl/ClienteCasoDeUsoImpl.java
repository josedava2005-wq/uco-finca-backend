package co.edu.uco.ucoparking.negocio.casosuso.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import co.edu.uco.ucoparking.datos.ClienteDatos;
import co.edu.uco.ucoparking.dominio.ClienteDominio;
import co.edu.uco.ucoparking.negocio.assembler.entidad.ClienteEntidadAssembler;
import co.edu.uco.ucoparking.negocio.casosuso.ClienteCasoDeUso;
import co.edu.uco.ucoparking.transversal.UtilUUID;

public final class ClienteCasoDeUsoImpl implements ClienteCasoDeUso {

    private final ClienteDatos datos;

    public ClienteCasoDeUsoImpl(final ClienteDatos datos) {
        this.datos = datos;
    }

    @Override
    public void crear(final ClienteDominio dominio) {
        final ClienteDominio dominioConId = ClienteDominio.builder()
                .id(UtilUUID.generarNuevo())
                .tipoDocumento(dominio.getTipoDocumento())
                .numeroDocumento(dominio.getNumeroDocumento())
                .nombre(dominio.getNombre())
                .correo(dominio.getCorreo())
                .telefono(dominio.getTelefono())
                .ciudad(dominio.getCiudad())
                .build();
        datos.crear(ClienteEntidadAssembler.toEntidad(dominioConId));
    }

    @Override
    public List<ClienteDominio> consultar(final ClienteDominio filtro) {
        return datos.consultar(ClienteEntidadAssembler.toEntidad(filtro))
                .stream()
                .map(ClienteEntidadAssembler::toDominio)
                .collect(Collectors.toList());
    }

    @Override
    public void modificar(final ClienteDominio dominio) {
        datos.modificar(ClienteEntidadAssembler.toEntidad(dominio));
    }

    @Override
    public void eliminar(final UUID id) {
        datos.eliminar(id);
    }
}
