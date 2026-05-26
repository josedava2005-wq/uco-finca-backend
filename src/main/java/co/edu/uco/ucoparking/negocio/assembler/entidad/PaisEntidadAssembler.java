package co.edu.uco.ucoparking.negocio.assembler.entidad;

import co.edu.uco.ucoparking.dominio.PaisDominio;
import co.edu.uco.ucoparking.entidad.PaisEntidad;

public final class PaisEntidadAssembler {

    private PaisEntidadAssembler() {}

    public static PaisEntidad toEntidad(final PaisDominio dominio) {
        return new PaisEntidad(dominio.getId(), dominio.getNombre(), dominio.getCodigoISO(), dominio.getContinente(), dominio.getIdioma(), dominio.getMoneda(), dominio.getTelefono());
    }

    public static PaisDominio toDominio(final PaisEntidad entidad) {
        return PaisDominio.builder()
                .id(entidad.getId())
                .nombre(entidad.getNombre())
                .codigoISO(entidad.getCodigoISO())
                .continente(entidad.getContinente())
                .idioma(entidad.getIdioma())
                .moneda(entidad.getMoneda())
                .telefono(entidad.getTelefono())
                .build();
    }
}
