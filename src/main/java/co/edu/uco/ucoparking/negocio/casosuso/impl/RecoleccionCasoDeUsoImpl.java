package co.edu.uco.ucoparking.negocio.casosuso.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import co.edu.uco.ucoparking.datos.RecoleccionDatos;
import co.edu.uco.ucoparking.dominio.RecoleccionDominio;
import co.edu.uco.ucoparking.negocio.assembler.entidad.RecoleccionEntidadAssembler;
import co.edu.uco.ucoparking.negocio.casosuso.RecoleccionCasoDeUso;
import co.edu.uco.ucoparking.transversal.UtilUUID;

public final class RecoleccionCasoDeUsoImpl implements RecoleccionCasoDeUso {

    private final RecoleccionDatos datos;

    public RecoleccionCasoDeUsoImpl(final RecoleccionDatos datos) {
        this.datos = datos;
    }

    @Override
    public void crear(final RecoleccionDominio dominio) {
        final RecoleccionDominio dominioConId = RecoleccionDominio.builder()
                .id(UtilUUID.generarNuevo())
                .fechaHora(dominio.getFechaHora())
                .cantidad(dominio.getCantidad())
                .unidadMedida(dominio.getUnidadMedida())
                .producto(dominio.getProducto())
                .animal(dominio.getAnimal())
                .empleado(dominio.getEmpleado())
                .build();
        datos.crear(RecoleccionEntidadAssembler.toEntidad(dominioConId));
    }

    @Override
    public List<RecoleccionDominio> consultar(final RecoleccionDominio filtro) {
        return datos.consultar(RecoleccionEntidadAssembler.toEntidad(filtro))
                .stream()
                .map(RecoleccionEntidadAssembler::toDominio)
                .collect(Collectors.toList());
    }

    @Override
    public void modificar(final RecoleccionDominio dominio) {
        datos.modificar(RecoleccionEntidadAssembler.toEntidad(dominio));
    }

    @Override
    public void eliminar(final UUID id) {
        datos.eliminar(id);
    }
}
