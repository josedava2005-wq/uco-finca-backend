package co.edu.uco.ucoparking.negocio.assembler.entidad;

import co.edu.uco.ucoparking.dominio.EmpleadoDominio;
import co.edu.uco.ucoparking.dominio.FincaDominio;
import co.edu.uco.ucoparking.entidad.EmpleadoEntidad;
import co.edu.uco.ucoparking.entidad.FincaEntidad;
import co.edu.uco.ucoparking.negocio.assembler.entidad.FincaEntidadAssembler;

public final class EmpleadoEntidadAssembler {

    private EmpleadoEntidadAssembler() {}

    public static EmpleadoEntidad toEntidad(final EmpleadoDominio dominio) {
        FincaEntidad fincaEnt = dominio.getFinca() != null
                ? FincaEntidadAssembler.toEntidad(dominio.getFinca()) : null;
        return new EmpleadoEntidad(dominio.getId(), dominio.getNombre(), dominio.getTipoDocumento(), dominio.getNumeroDocumento(), dominio.getCargo(), dominio.getTelefono(), dominio.getFechaVinculacion(), fincaEnt);
    }

    public static EmpleadoDominio toDominio(final EmpleadoEntidad entidad) {
        return EmpleadoDominio.builder()
                .id(entidad.getId())
                .nombre(entidad.getNombre())
                .tipoDocumento(entidad.getTipoDocumento())
                .numeroDocumento(entidad.getNumeroDocumento())
                .cargo(entidad.getCargo())
                .telefono(entidad.getTelefono())
                .fechaVinculacion(entidad.getFechaVinculacion())
                .finca(entidad.getFinca() != null ? FincaEntidadAssembler.toDominio(entidad.getFinca()) : null)
                .build();
    }
}
