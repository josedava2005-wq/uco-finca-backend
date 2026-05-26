package co.edu.uco.ucoparking.negocio.assembler.entidad;

import co.edu.uco.ucoparking.dominio.AlimentacionDominio;
import co.edu.uco.ucoparking.dominio.AnimalDominio;
import co.edu.uco.ucoparking.dominio.EmpleadoDominio;
import co.edu.uco.ucoparking.entidad.AlimentacionEntidad;
import co.edu.uco.ucoparking.entidad.AnimalEntidad;
import co.edu.uco.ucoparking.entidad.EmpleadoEntidad;
import co.edu.uco.ucoparking.negocio.assembler.entidad.AnimalEntidadAssembler;
import co.edu.uco.ucoparking.negocio.assembler.entidad.EmpleadoEntidadAssembler;

public final class AlimentacionEntidadAssembler {

    private AlimentacionEntidadAssembler() {}

    public static AlimentacionEntidad toEntidad(final AlimentacionDominio dominio) {
        AnimalEntidad animalEnt = dominio.getAnimal() != null
                ? AnimalEntidadAssembler.toEntidad(dominio.getAnimal()) : null;
        EmpleadoEntidad empleadoEnt = dominio.getEmpleado() != null
                ? EmpleadoEntidadAssembler.toEntidad(dominio.getEmpleado()) : null;
        return new AlimentacionEntidad(dominio.getId(), dominio.getFechaHora(), dominio.getCantidad(), dominio.getUnidadMedida(), dominio.getTipoAlimento(), animalEnt, empleadoEnt);
    }

    public static AlimentacionDominio toDominio(final AlimentacionEntidad entidad) {
        return AlimentacionDominio.builder()
                .id(entidad.getId())
                .fechaHora(entidad.getFechaHora())
                .cantidad(entidad.getCantidad())
                .unidadMedida(entidad.getUnidadMedida())
                .tipoAlimento(entidad.getTipoAlimento())
                .animal(entidad.getAnimal() != null ? AnimalEntidadAssembler.toDominio(entidad.getAnimal()) : null)
                .empleado(entidad.getEmpleado() != null ? EmpleadoEntidadAssembler.toDominio(entidad.getEmpleado()) : null)
                .build();
    }
}
