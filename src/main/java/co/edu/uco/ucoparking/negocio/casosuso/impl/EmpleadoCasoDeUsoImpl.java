package co.edu.uco.ucoparking.negocio.casosuso.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import co.edu.uco.ucoparking.datos.EmpleadoDatos;
import co.edu.uco.ucoparking.dominio.EmpleadoDominio;
import co.edu.uco.ucoparking.negocio.assembler.entidad.EmpleadoEntidadAssembler;
import co.edu.uco.ucoparking.negocio.casosuso.EmpleadoCasoDeUso;
import co.edu.uco.ucoparking.transversal.UtilTexto;
import co.edu.uco.ucoparking.transversal.UtilUUID;
import co.edu.uco.ucoparking.transversal.excepciones.NegocioException;

public final class EmpleadoCasoDeUsoImpl implements EmpleadoCasoDeUso {

    private final EmpleadoDatos datos;

    public EmpleadoCasoDeUsoImpl(final EmpleadoDatos datos) {
        this.datos = datos;
    }

    @Override
    public void crear(final EmpleadoDominio dominio) {
        if (UtilTexto.esNuloOVacio(dominio.getNombre())) {
            throw new NegocioException(
                    "Nombre de empleado nulo o vacío en EmpleadoCasoDeUsoImpl.crear()",
                    "El nombre del empleado es obligatorio");
        }
        if (UtilTexto.esNuloOVacio(dominio.getTipoDocumento())) {
            throw new NegocioException(
                    "Tipo de documento nulo o vacío en EmpleadoCasoDeUsoImpl.crear()",
                    "El tipo de documento del empleado es obligatorio");
        }
        if (UtilTexto.esNuloOVacio(dominio.getNumeroDocumento())) {
            throw new NegocioException(
                    "Número de documento nulo o vacío en EmpleadoCasoDeUsoImpl.crear()",
                    "El número de documento del empleado es obligatorio");
        }
        if (dominio.getFinca() == null || dominio.getFinca().getId() == null) {
            throw new NegocioException(
                    "Finca o su ID es nulo en EmpleadoCasoDeUsoImpl.crear()",
                    "Debe indicar la finca del empleado (idFinca)");
        }
        final EmpleadoDominio dominioConId = EmpleadoDominio.builder()
                .id(UtilUUID.generarNuevo())
                .nombre(dominio.getNombre())
                .tipoDocumento(dominio.getTipoDocumento())
                .numeroDocumento(dominio.getNumeroDocumento())
                .cargo(dominio.getCargo())
                .telefono(dominio.getTelefono())
                .fechaVinculacion(dominio.getFechaVinculacion())
                .finca(dominio.getFinca())
                .build();
        datos.crear(EmpleadoEntidadAssembler.toEntidad(dominioConId));
    }

    @Override
    public List<EmpleadoDominio> consultar(final EmpleadoDominio filtro) {
        return datos.consultar(EmpleadoEntidadAssembler.toEntidad(filtro))
                .stream().map(EmpleadoEntidadAssembler::toDominio).collect(Collectors.toList());
    }

    @Override
    public void modificar(final EmpleadoDominio dominio) {
        if (dominio.getId() == null) {
            throw new NegocioException(
                    "ID de empleado nulo en EmpleadoCasoDeUsoImpl.modificar()",
                    "El ID del empleado es obligatorio para modificar");
        }
        if (UtilTexto.esNuloOVacio(dominio.getNombre())) {
            throw new NegocioException(
                    "Nombre de empleado nulo o vacío en EmpleadoCasoDeUsoImpl.modificar()",
                    "El nombre del empleado es obligatorio");
        }
        if (UtilTexto.esNuloOVacio(dominio.getNumeroDocumento())) {
            throw new NegocioException(
                    "Número de documento nulo o vacío en EmpleadoCasoDeUsoImpl.modificar()",
                    "El número de documento del empleado es obligatorio");
        }
        if (dominio.getFinca() == null || dominio.getFinca().getId() == null) {
            throw new NegocioException(
                    "Finca o su ID es nulo en EmpleadoCasoDeUsoImpl.modificar()",
                    "Debe indicar la finca del empleado (idFinca)");
        }
        datos.modificar(EmpleadoEntidadAssembler.toEntidad(dominio));
    }

    @Override
    public void eliminar(final UUID id) {
        if (id == null) {
            throw new NegocioException(
                    "ID de empleado nulo en EmpleadoCasoDeUsoImpl.eliminar()",
                    "El ID del empleado es obligatorio para eliminar");
        }
        datos.eliminar(id);
    }
}
