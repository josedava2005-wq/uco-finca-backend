package co.edu.uco.ucoparking.negocio.casosuso.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import co.edu.uco.ucoparking.datos.FincaDatos;
import co.edu.uco.ucoparking.dominio.FincaDominio;
import co.edu.uco.ucoparking.negocio.assembler.entidad.FincaEntidadAssembler;
import co.edu.uco.ucoparking.negocio.casosuso.FincaCasoDeUso;
import co.edu.uco.ucoparking.transversal.UtilTexto;
import co.edu.uco.ucoparking.transversal.UtilUUID;
import co.edu.uco.ucoparking.transversal.excepciones.NegocioException;

/**
 * Caso de uso de Finca con validaciones básicas de negocio.
 *
 * PATRÓN DE VALIDACIÓN (aplica a todos los CasoDeUsoImpl del sistema):
 *
 *   crear():
 *     1. Validar campos obligatorios (nombre, lugarFinca)
 *     2. Generar UUID nuevo
 *     3. Construir dominio completo
 *     4. Delegar a datos
 *
 *   modificar():
 *     1. Validar que el ID venga informado
 *     2. Validar campos obligatorios
 *     3. Delegar a datos (save() detecta ID existente → UPDATE)
 *
 *   eliminar():
 *     1. Validar que el ID no sea null
 *     2. Delegar a datos (deleteById lanza EntityNotFoundException si no existe)
 *
 * Las excepciones NegocioException son capturadas por GlobalExceptionHandler
 * y devueltas como JSON 422 con mensaje limpio al frontend.
 */
public final class FincaCasoDeUsoImpl implements FincaCasoDeUso {

    private final FincaDatos datos;

    public FincaCasoDeUsoImpl(final FincaDatos datos) {
        this.datos = datos;
    }

    @Override
    public void crear(final FincaDominio dominio) {

        // 1. Validar nombre obligatorio
        if (UtilTexto.esNuloOVacio(dominio.getNombre())) {
            throw new NegocioException(
                    "Nombre de finca nulo o vacío en FincaCasoDeUsoImpl.crear()",
                    "El nombre de la finca es obligatorio");
        }

        // 2. Validar FK lugarFinca obligatoria
        if (dominio.getLugarFinca() == null || dominio.getLugarFinca().getId() == null) {
            throw new NegocioException(
                    "LugarFinca o su ID es nulo en FincaCasoDeUsoImpl.crear()",
                    "Debe indicar el lugar de la finca (idLugarFinca)");
        }

        // 3. Construir dominio completo con UUID generado
        final FincaDominio dominioConId = FincaDominio.builder()
                .id(UtilUUID.generarNuevo())
                .nombre(dominio.getNombre())
                .hectareas(dominio.getHectareas())
                .fechaRegistro(dominio.getFechaRegistro())
                .lugarFinca(dominio.getLugarFinca())
                .build();

        // 4. Persistir
        datos.crear(FincaEntidadAssembler.toEntidad(dominioConId));
    }

    @Override
    public List<FincaDominio> consultar(final FincaDominio filtro) {
        return datos.consultar(FincaEntidadAssembler.toEntidad(filtro))
                .stream()
                .map(FincaEntidadAssembler::toDominio)
                .collect(Collectors.toList());
    }

    @Override
    public void modificar(final FincaDominio dominio) {

        // 1. Validar ID obligatorio
        if (dominio.getId() == null) {
            throw new NegocioException(
                    "ID de finca nulo en FincaCasoDeUsoImpl.modificar()",
                    "El ID de la finca es obligatorio para modificar");
        }

        // 2. Validar nombre obligatorio
        if (UtilTexto.esNuloOVacio(dominio.getNombre())) {
            throw new NegocioException(
                    "Nombre de finca nulo o vacío en FincaCasoDeUsoImpl.modificar()",
                    "El nombre de la finca es obligatorio");
        }

        // 3. Validar FK lugarFinca obligatoria
        if (dominio.getLugarFinca() == null || dominio.getLugarFinca().getId() == null) {
            throw new NegocioException(
                    "LugarFinca o su ID es nulo en FincaCasoDeUsoImpl.modificar()",
                    "Debe indicar el lugar de la finca (idLugarFinca)");
        }

        // 4. Persistir (save() detecta ID existente → UPDATE)
        datos.modificar(FincaEntidadAssembler.toEntidad(dominio));
    }

    @Override
    public void eliminar(final UUID id) {

        // 1. Validar ID obligatorio
        if (id == null) {
            throw new NegocioException(
                    "ID de finca nulo en FincaCasoDeUsoImpl.eliminar()",
                    "El ID de la finca es obligatorio para eliminar");
        }

        // 2. Eliminar (deleteById lanza EmptyResultDataAccessException si no existe
        //    → capturado por GlobalExceptionHandler como 404)
        datos.eliminar(id);
    }
}
