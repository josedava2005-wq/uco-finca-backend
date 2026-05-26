package co.edu.uco.ucoparking.negocio.assembler.DTO;

import java.util.UUID;
import co.edu.uco.ucoparking.dominio.AnimalDominio;
import co.edu.uco.ucoparking.dominio.EmpleadoDominio;
import co.edu.uco.ucoparking.dominio.ProductoDominio;
import co.edu.uco.ucoparking.dominio.RecoleccionDominio;
import co.edu.uco.ucoparking.dto.RecoleccionDTO;

public final class RecoleccionDTOAssembler {

    private RecoleccionDTOAssembler() {}

    public static RecoleccionDominio toDominio(final RecoleccionDTO dto) {
        ProductoDominio producto = dto.getIdProducto() != null
                ? ProductoDominio.builder().id(dto.getIdProducto()).build() : null;
        AnimalDominio animal = dto.getIdAnimal() != null
                ? AnimalDominio.builder().id(dto.getIdAnimal()).build() : null;
        EmpleadoDominio empleado = dto.getIdEmpleado() != null
                ? EmpleadoDominio.builder().id(dto.getIdEmpleado()).build() : null;
        return RecoleccionDominio.builder()
                .id(dto.getId())
                .fechaHora(dto.getFechaHora())
                .cantidad(dto.getCantidad())
                .unidadMedida(dto.getUnidadMedida())
                .producto(producto)
                .animal(animal)
                .empleado(empleado)
                .build();
    }

    public static RecoleccionDTO toDTO(final RecoleccionDominio dominio) {
        return new RecoleccionDTO(dominio.getId(), dominio.getFechaHora(), dominio.getCantidad(), dominio.getUnidadMedida(), dominio.getProducto() != null ? dominio.getProducto().getId() : null, dominio.getAnimal() != null ? dominio.getAnimal().getId() : null, dominio.getEmpleado() != null ? dominio.getEmpleado().getId() : null);
    }
}
