package co.edu.uco.ucoparking.negocio.assembler.entidad;

import co.edu.uco.ucoparking.dominio.AnimalDominio;
import co.edu.uco.ucoparking.dominio.FincaDominio;
import co.edu.uco.ucoparking.entidad.AnimalEntidad;
import co.edu.uco.ucoparking.entidad.FincaEntidad;
import co.edu.uco.ucoparking.negocio.assembler.entidad.FincaEntidadAssembler;

public final class AnimalEntidadAssembler {

    private AnimalEntidadAssembler() {}

    public static AnimalEntidad toEntidad(final AnimalDominio dominio) {
        FincaEntidad fincaEnt = dominio.getFinca() != null
                ? FincaEntidadAssembler.toEntidad(dominio.getFinca()) : null;
        return new AnimalEntidad(dominio.getId(), dominio.getNombre(), dominio.getEspecie(), dominio.getRaza(), dominio.getSexo(), dominio.getFechaNacimiento(), dominio.getPesoKg(), fincaEnt);
    }

    public static AnimalDominio toDominio(final AnimalEntidad entidad) {
        return AnimalDominio.builder()
                .id(entidad.getId())
                .nombre(entidad.getNombre())
                .especie(entidad.getEspecie())
                .raza(entidad.getRaza())
                .sexo(entidad.getSexo())
                .fechaNacimiento(entidad.getFechaNacimiento())
                .pesoKg(entidad.getPesoKg())
                .finca(entidad.getFinca() != null ? FincaEntidadAssembler.toDominio(entidad.getFinca()) : null)
                .build();
    }
}
