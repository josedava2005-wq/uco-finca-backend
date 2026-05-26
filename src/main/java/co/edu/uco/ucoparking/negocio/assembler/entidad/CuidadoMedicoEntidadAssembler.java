package co.edu.uco.ucoparking.negocio.assembler.entidad;

import co.edu.uco.ucoparking.dominio.AnimalDominio;
import co.edu.uco.ucoparking.dominio.CuidadoMedicoDominio;
import co.edu.uco.ucoparking.dominio.EmpleadoDominio;
import co.edu.uco.ucoparking.entidad.AnimalEntidad;
import co.edu.uco.ucoparking.entidad.CuidadoMedicoEntidad;
import co.edu.uco.ucoparking.entidad.EmpleadoEntidad;
import co.edu.uco.ucoparking.negocio.assembler.entidad.AnimalEntidadAssembler;
import co.edu.uco.ucoparking.negocio.assembler.entidad.EmpleadoEntidadAssembler;

public final class CuidadoMedicoEntidadAssembler {

    private CuidadoMedicoEntidadAssembler() {}

    public static CuidadoMedicoEntidad toEntidad(final CuidadoMedicoDominio dominio) {
        AnimalEntidad animalEnt = dominio.getAnimal() != null
                ? AnimalEntidadAssembler.toEntidad(dominio.getAnimal()) : null;
        EmpleadoEntidad empleadoEnt = dominio.getEmpleado() != null
                ? EmpleadoEntidadAssembler.toEntidad(dominio.getEmpleado()) : null;
        return new CuidadoMedicoEntidad(dominio.getId(), dominio.getTipo(), dominio.getFechaHora(), dominio.getDescripcion(), dominio.getMedicamento(), animalEnt, empleadoEnt);
    }

    public static CuidadoMedicoDominio toDominio(final CuidadoMedicoEntidad entidad) {
        return CuidadoMedicoDominio.builder()
                .id(entidad.getId())
                .tipo(entidad.getTipo())
                .fechaHora(entidad.getFechaHora())
                .descripcion(entidad.getDescripcion())
                .medicamento(entidad.getMedicamento())
                .animal(entidad.getAnimal() != null ? AnimalEntidadAssembler.toDominio(entidad.getAnimal()) : null)
                .empleado(entidad.getEmpleado() != null ? EmpleadoEntidadAssembler.toDominio(entidad.getEmpleado()) : null)
                .build();
    }
}
