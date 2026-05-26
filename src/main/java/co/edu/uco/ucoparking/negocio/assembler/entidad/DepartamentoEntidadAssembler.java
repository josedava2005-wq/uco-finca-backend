package co.edu.uco.ucoparking.negocio.assembler.entidad;

import co.edu.uco.ucoparking.dominio.DepartamentoDominio;
import co.edu.uco.ucoparking.dominio.PaisDominio;
import co.edu.uco.ucoparking.entidad.DepartamentoEntidad;
import co.edu.uco.ucoparking.entidad.PaisEntidad;
import co.edu.uco.ucoparking.negocio.assembler.entidad.PaisEntidadAssembler;

public final class DepartamentoEntidadAssembler {

    private DepartamentoEntidadAssembler() {}

    public static DepartamentoEntidad toEntidad(final DepartamentoDominio dominio) {
        PaisEntidad paisEnt = dominio.getPais() != null
                ? PaisEntidadAssembler.toEntidad(dominio.getPais()) : null;
        return new DepartamentoEntidad(dominio.getId(), dominio.getNombre(), dominio.getCodigoDANE(), paisEnt);
    }

    public static DepartamentoDominio toDominio(final DepartamentoEntidad entidad) {
        return DepartamentoDominio.builder()
                .id(entidad.getId())
                .nombre(entidad.getNombre())
                .codigoDANE(entidad.getCodigoDANE())
                .pais(entidad.getPais() != null ? PaisEntidadAssembler.toDominio(entidad.getPais()) : null)
                .build();
    }
}
