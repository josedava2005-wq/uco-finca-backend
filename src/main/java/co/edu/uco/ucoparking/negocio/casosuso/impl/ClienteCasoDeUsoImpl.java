package co.edu.uco.ucoparking.negocio.casosuso.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import co.edu.uco.ucoparking.datos.ClienteDatos;
import co.edu.uco.ucoparking.dominio.ClienteDominio;
import co.edu.uco.ucoparking.negocio.assembler.entidad.ClienteEntidadAssembler;
import co.edu.uco.ucoparking.negocio.casosuso.ClienteCasoDeUso;
import co.edu.uco.ucoparking.transversal.UtilTexto;
import co.edu.uco.ucoparking.transversal.UtilUUID;
import co.edu.uco.ucoparking.transversal.excepciones.NegocioException;

public final class ClienteCasoDeUsoImpl implements ClienteCasoDeUso {

    private final ClienteDatos datos;

    public ClienteCasoDeUsoImpl(final ClienteDatos datos) {
        this.datos = datos;
    }

    @Override
    public void crear(final ClienteDominio dominio) {
        if (UtilTexto.esNuloOVacio(dominio.getNombre())) {
            throw new NegocioException(
                    "Nombre de cliente nulo o vacío en ClienteCasoDeUsoImpl.crear()",
                    "El nombre del cliente es obligatorio");
        }
        if (UtilTexto.esNuloOVacio(dominio.getTipoDocumento())) {
            throw new NegocioException(
                    "Tipo de documento nulo o vacío en ClienteCasoDeUsoImpl.crear()",
                    "El tipo de documento del cliente es obligatorio");
        }
        if (UtilTexto.esNuloOVacio(dominio.getNumeroDocumento())) {
            throw new NegocioException(
                    "Número de documento nulo o vacío en ClienteCasoDeUsoImpl.crear()",
                    "El número de documento del cliente es obligatorio");
        }
        if (dominio.getCiudad() == null || dominio.getCiudad().getId() == null) {
            throw new NegocioException(
                    "Ciudad o su ID es nulo en ClienteCasoDeUsoImpl.crear()",
                    "Debe indicar la ciudad del cliente (idCiudad)");
        }
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
                .stream().map(ClienteEntidadAssembler::toDominio).collect(Collectors.toList());
    }

    @Override
    public void modificar(final ClienteDominio dominio) {
        if (dominio.getId() == null) {
            throw new NegocioException(
                    "ID de cliente nulo en ClienteCasoDeUsoImpl.modificar()",
                    "El ID del cliente es obligatorio para modificar");
        }
        if (UtilTexto.esNuloOVacio(dominio.getNombre())) {
            throw new NegocioException(
                    "Nombre de cliente nulo o vacío en ClienteCasoDeUsoImpl.modificar()",
                    "El nombre del cliente es obligatorio");
        }
        if (UtilTexto.esNuloOVacio(dominio.getNumeroDocumento())) {
            throw new NegocioException(
                    "Número de documento nulo o vacío en ClienteCasoDeUsoImpl.modificar()",
                    "El número de documento del cliente es obligatorio");
        }
        if (dominio.getCiudad() == null || dominio.getCiudad().getId() == null) {
            throw new NegocioException(
                    "Ciudad o su ID es nulo en ClienteCasoDeUsoImpl.modificar()",
                    "Debe indicar la ciudad del cliente (idCiudad)");
        }
        datos.modificar(ClienteEntidadAssembler.toEntidad(dominio));
    }

    @Override
    public void eliminar(final UUID id) {
        if (id == null) {
            throw new NegocioException(
                    "ID de cliente nulo en ClienteCasoDeUsoImpl.eliminar()",
                    "El ID del cliente es obligatorio para eliminar");
        }
        datos.eliminar(id);
    }
}
