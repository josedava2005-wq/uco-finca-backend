package co.edu.uco.ucoparking.negocio.assembler.entidad;

import co.edu.uco.ucoparking.dominio.EmpleadoDominio;
import co.edu.uco.ucoparking.dominio.FincaDominio;
import co.edu.uco.ucoparking.dominio.TareaDominio;
import co.edu.uco.ucoparking.entidad.EmpleadoEntidad;
import co.edu.uco.ucoparking.entidad.FincaEntidad;
import co.edu.uco.ucoparking.entidad.TareaEntidad;
import co.edu.uco.ucoparking.negocio.assembler.entidad.EmpleadoEntidadAssembler;
import co.edu.uco.ucoparking.negocio.assembler.entidad.FincaEntidadAssembler;

public final class TareaEntidadAssembler {

    private TareaEntidadAssembler() {}

    public static TareaEntidad toEntidad(final TareaDominio dominio) {
        EmpleadoEntidad empleadoEnt = dominio.getEmpleado() != null
                ? EmpleadoEntidadAssembler.toEntidad(dominio.getEmpleado()) : null;
        FincaEntidad fincaEnt = dominio.getFinca() != null
                ? FincaEntidadAssembler.toEntidad(dominio.getFinca()) : null;
        return new TareaEntidad(dominio.getId(), dominio.getDescripcion(), dominio.getFechaHora(), dominio.getEstado(), empleadoEnt, fincaEnt);
    }

    public static TareaDominio toDominio(final TareaEntidad entidad) {
        return TareaDominio.builder()
                .id(entidad.getId())
                .descripcion(entidad.getDescripcion())
                .fechaHora(entidad.getFechaHora())
                .estado(entidad.getEstado())
                .empleado(entidad.getEmpleado() != null ? EmpleadoEntidadAssembler.toDominio(entidad.getEmpleado()) : null)
                .finca(entidad.getFinca() != null ? FincaEntidadAssembler.toDominio(entidad.getFinca()) : null)
                .build();
    }
}
