package co.edu.uco.ucoparking.negocio.assembler.entidad;

import co.edu.uco.ucoparking.dominio.CiudadDominio;
import co.edu.uco.ucoparking.dominio.DepartamentoDominio;
import co.edu.uco.ucoparking.entidad.CiudadEntidad;
import co.edu.uco.ucoparking.entidad.DepartamentoEntidad;
import co.edu.uco.ucoparking.negocio.assembler.entidad.DepartamentoEntidadAssembler;

public final class CiudadEntidadAssembler {

    private CiudadEntidadAssembler() {}

    public static CiudadEntidad toEntidad(final CiudadDominio dominio) {
        DepartamentoEntidad departamentoEnt = dominio.getDepartamento() != null
                ? DepartamentoEntidadAssembler.toEntidad(dominio.getDepartamento()) : null;
        return new CiudadEntidad(dominio.getId(), dominio.getNombre(), departamentoEnt);
    }

    public static CiudadDominio toDominio(final CiudadEntidad entidad) {
        return CiudadDominio.builder()
                .id(entidad.getId())
                .nombre(entidad.getNombre())
                .departamento(entidad.getDepartamento() != null ? DepartamentoEntidadAssembler.toDominio(entidad.getDepartamento()) : null)
                .build();
    }
}
