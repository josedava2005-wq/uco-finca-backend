package co.edu.uco.ucoparking.negocio.assembler.entidad;

import co.edu.uco.ucoparking.dominio.AnimalDominio;
import co.edu.uco.ucoparking.dominio.CuidadoEspecialDominio;
import co.edu.uco.ucoparking.dominio.EmpleadoDominio;
import co.edu.uco.ucoparking.entidad.AnimalEntidad;
import co.edu.uco.ucoparking.entidad.CuidadoEspecialEntidad;
import co.edu.uco.ucoparking.entidad.EmpleadoEntidad;
import co.edu.uco.ucoparking.negocio.assembler.entidad.AnimalEntidadAssembler;
import co.edu.uco.ucoparking.negocio.assembler.entidad.EmpleadoEntidadAssembler;

public final class CuidadoEspecialEntidadAssembler {

    private CuidadoEspecialEntidadAssembler() {}

    public static CuidadoEspecialEntidad toEntidad(final CuidadoEspecialDominio dominio) {
        AnimalEntidad animalEnt = dominio.getAnimal() != null
                ? AnimalEntidadAssembler.toEntidad(dominio.getAnimal()) : null;
        EmpleadoEntidad empleadoEnt = dominio.getEmpleado() != null
                ? EmpleadoEntidadAssembler.toEntidad(dominio.getEmpleado()) : null;
        return new CuidadoEspecialEntidad(dominio.getId(), dominio.getTipo(), dominio.getFechaHora(), dominio.getDescripcion(), animalEnt, empleadoEnt);
    }

    public static CuidadoEspecialDominio toDominio(final CuidadoEspecialEntidad entidad) {
        return CuidadoEspecialDominio.builder()
                .id(entidad.getId())
                .tipo(entidad.getTipo())
                .fechaHora(entidad.getFechaHora())
                .descripcion(entidad.getDescripcion())
                .animal(entidad.getAnimal() != null ? AnimalEntidadAssembler.toDominio(entidad.getAnimal()) : null)
                .empleado(entidad.getEmpleado() != null ? EmpleadoEntidadAssembler.toDominio(entidad.getEmpleado()) : null)
                .build();
    }
}
