package co.edu.uco.ucoparking.negocio.casosuso.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import co.edu.uco.ucoparking.datos.AlimentacionDatos;
import co.edu.uco.ucoparking.dominio.AlimentacionDominio;
import co.edu.uco.ucoparking.negocio.assembler.entidad.AlimentacionEntidadAssembler;
import co.edu.uco.ucoparking.negocio.casosuso.AlimentacionCasoDeUso;
import co.edu.uco.ucoparking.transversal.UtilUUID;
import co.edu.uco.ucoparking.transversal.excepciones.NegocioException;

public final class AlimentacionCasoDeUsoImpl implements AlimentacionCasoDeUso {

    private final AlimentacionDatos datos;

    public AlimentacionCasoDeUsoImpl(final AlimentacionDatos datos) {
        this.datos = datos;
    }

    @Override
    public void crear(final AlimentacionDominio dominio) {
        validarCamposObligatorios(dominio);
        final AlimentacionDominio dominioConId = AlimentacionDominio.builder()
                .id(UtilUUID.generarNuevo())
                .fechaHora(dominio.getFechaHora())
                .cantidad(dominio.getCantidad())
                .unidadMedida(dominio.getUnidadMedida())
                .tipoAlimento(dominio.getTipoAlimento())
                .animal(dominio.getAnimal())
                .empleado(dominio.getEmpleado())
                .build();
        datos.crear(AlimentacionEntidadAssembler.toEntidad(dominioConId));
    }

    @Override
    public List<AlimentacionDominio> consultar(final AlimentacionDominio filtro) {
        return datos.consultar(AlimentacionEntidadAssembler.toEntidad(filtro))
                .stream()
                .map(AlimentacionEntidadAssembler::toDominio)
                .collect(Collectors.toList());
    }

    @Override
    public void modificar(final AlimentacionDominio dominio) {
        if (dominio.getId() == null) {
            throw new NegocioException(
                    "AlimentacionCasoDeUsoImpl.modificar: el id de la alimentacion es obligatorio.",
                    "El id de la alimentacion es obligatorio para modificar.");
        }
        validarCamposObligatorios(dominio);
        datos.modificar(AlimentacionEntidadAssembler.toEntidad(dominio));
    }

    @Override
    public void eliminar(final UUID id) {
        if (id == null) {
            throw new NegocioException(
                    "AlimentacionCasoDeUsoImpl.eliminar: el id de la alimentacion es obligatorio.",
                    "El id de la alimentacion es obligatorio para eliminar.");
        }
        datos.eliminar(id);
    }

    private void validarCamposObligatorios(final AlimentacionDominio dominio) {
        if (dominio.getAnimal() == null || dominio.getAnimal().getId() == null) {
            throw new NegocioException(
                    "AlimentacionCasoDeUsoImpl: el animal de la alimentacion es obligatorio.",
                    "El animal de la alimentacion es obligatorio.");
        }
        if (dominio.getEmpleado() == null || dominio.getEmpleado().getId() == null) {
            throw new NegocioException(
                    "AlimentacionCasoDeUsoImpl: el empleado responsable de la alimentacion es obligatorio.",
                    "El empleado responsable de la alimentacion es obligatorio.");
        }
    }
}
