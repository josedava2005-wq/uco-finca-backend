package co.edu.uco.ucoparking.negocio.casosuso.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import co.edu.uco.ucoparking.datos.PaisDatos;
import co.edu.uco.ucoparking.dominio.PaisDominio;
import co.edu.uco.ucoparking.negocio.assembler.entidad.PaisEntidadAssembler;
import co.edu.uco.ucoparking.negocio.casosuso.PaisCasoDeUso;
import co.edu.uco.ucoparking.transversal.UtilTexto;
import co.edu.uco.ucoparking.transversal.UtilUUID;
import co.edu.uco.ucoparking.transversal.excepciones.NegocioException;

public final class PaisCasoDeUsoImpl implements PaisCasoDeUso {

    private final PaisDatos datos;

    public PaisCasoDeUsoImpl(final PaisDatos datos) {
        this.datos = datos;
    }

    @Override
    public void crear(final PaisDominio dominio) {
        if (UtilTexto.esNuloOVacio(dominio.getNombre())) {
            throw new NegocioException(
                    "Nombre de país nulo o vacío en PaisCasoDeUsoImpl.crear()",
                    "El nombre del país es obligatorio");
        }
        final PaisDominio dominioConId = PaisDominio.builder()
                .id(UtilUUID.generarNuevo())
                .nombre(dominio.getNombre())
                .codigoISO(dominio.getCodigoISO())
                .continente(dominio.getContinente())
                .idioma(dominio.getIdioma())
                .moneda(dominio.getMoneda())
                .telefono(dominio.getTelefono())
                .build();
        datos.crear(PaisEntidadAssembler.toEntidad(dominioConId));
    }

    @Override
    public List<PaisDominio> consultar(final PaisDominio filtro) {
        return datos.consultar(PaisEntidadAssembler.toEntidad(filtro))
                .stream().map(PaisEntidadAssembler::toDominio).collect(Collectors.toList());
    }

    @Override
    public void modificar(final PaisDominio dominio) {
        if (dominio.getId() == null) {
            throw new NegocioException(
                    "ID de país nulo en PaisCasoDeUsoImpl.modificar()",
                    "El ID del país es obligatorio para modificar");
        }
        if (UtilTexto.esNuloOVacio(dominio.getNombre())) {
            throw new NegocioException(
                    "Nombre de país nulo o vacío en PaisCasoDeUsoImpl.modificar()",
                    "El nombre del país es obligatorio");
        }
        datos.modificar(PaisEntidadAssembler.toEntidad(dominio));
    }

    @Override
    public void eliminar(final UUID id) {
        if (id == null) {
            throw new NegocioException(
                    "ID de país nulo en PaisCasoDeUsoImpl.eliminar()",
                    "El ID del país es obligatorio para eliminar");
        }
        datos.eliminar(id);
    }
}
