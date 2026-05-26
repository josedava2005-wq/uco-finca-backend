package co.edu.uco.ucoparking.negocio.assembler.entidad;

import co.edu.uco.ucoparking.dominio.AnimalDominio;
import co.edu.uco.ucoparking.dominio.EmpleadoDominio;
import co.edu.uco.ucoparking.dominio.ProductoDominio;
import co.edu.uco.ucoparking.dominio.RecoleccionDominio;
import co.edu.uco.ucoparking.entidad.AnimalEntidad;
import co.edu.uco.ucoparking.entidad.EmpleadoEntidad;
import co.edu.uco.ucoparking.entidad.ProductoEntidad;
import co.edu.uco.ucoparking.entidad.RecoleccionEntidad;
import co.edu.uco.ucoparking.negocio.assembler.entidad.AnimalEntidadAssembler;
import co.edu.uco.ucoparking.negocio.assembler.entidad.EmpleadoEntidadAssembler;
import co.edu.uco.ucoparking.negocio.assembler.entidad.ProductoEntidadAssembler;

public final class RecoleccionEntidadAssembler {

    private RecoleccionEntidadAssembler() {}

    public static RecoleccionEntidad toEntidad(final RecoleccionDominio dominio) {
        ProductoEntidad productoEnt = dominio.getProducto() != null
                ? ProductoEntidadAssembler.toEntidad(dominio.getProducto()) : null;
        AnimalEntidad animalEnt = dominio.getAnimal() != null
                ? AnimalEntidadAssembler.toEntidad(dominio.getAnimal()) : null;
        EmpleadoEntidad empleadoEnt = dominio.getEmpleado() != null
                ? EmpleadoEntidadAssembler.toEntidad(dominio.getEmpleado()) : null;
        return new RecoleccionEntidad(dominio.getId(), dominio.getFechaHora(), dominio.getCantidad(), dominio.getUnidadMedida(), productoEnt, animalEnt, empleadoEnt);
    }

    public static RecoleccionDominio toDominio(final RecoleccionEntidad entidad) {
        return RecoleccionDominio.builder()
                .id(entidad.getId())
                .fechaHora(entidad.getFechaHora())
                .cantidad(entidad.getCantidad())
                .unidadMedida(entidad.getUnidadMedida())
                .producto(entidad.getProducto() != null ? ProductoEntidadAssembler.toDominio(entidad.getProducto()) : null)
                .animal(entidad.getAnimal() != null ? AnimalEntidadAssembler.toDominio(entidad.getAnimal()) : null)
                .empleado(entidad.getEmpleado() != null ? EmpleadoEntidadAssembler.toDominio(entidad.getEmpleado()) : null)
                .build();
    }
}
