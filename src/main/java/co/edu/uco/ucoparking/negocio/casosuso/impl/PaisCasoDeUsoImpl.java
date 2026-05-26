package co.edu.uco.ucoparking.negocio.casosuso.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import co.edu.uco.ucoparking.datos.PaisDatos;
import co.edu.uco.ucoparking.dominio.PaisDominio;
import co.edu.uco.ucoparking.negocio.assembler.entidad.PaisEntidadAssembler;
import co.edu.uco.ucoparking.negocio.casosuso.PaisCasoDeUso;
import co.edu.uco.ucoparking.transversal.UtilUUID;

public final class PaisCasoDeUsoImpl implements PaisCasoDeUso {

    private final PaisDatos datos;

    public PaisCasoDeUsoImpl(final PaisDatos datos) {
        this.datos = datos;
    }

    @Override
    public void crear(final PaisDominio dominio) {
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
                .stream()
                .map(PaisEntidadAssembler::toDominio)
                .collect(Collectors.toList());
    }

    @Override
    public void modificar(final PaisDominio dominio) {
        datos.modificar(PaisEntidadAssembler.toEntidad(dominio));
    }

    @Override
    public void eliminar(final UUID id) {
        datos.eliminar(id);
    }
}
