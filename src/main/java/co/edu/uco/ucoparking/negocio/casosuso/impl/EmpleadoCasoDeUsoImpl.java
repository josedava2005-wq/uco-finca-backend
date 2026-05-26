package co.edu.uco.ucoparking.negocio.casosuso.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import co.edu.uco.ucoparking.datos.EmpleadoDatos;
import co.edu.uco.ucoparking.dominio.EmpleadoDominio;
import co.edu.uco.ucoparking.negocio.assembler.entidad.EmpleadoEntidadAssembler;
import co.edu.uco.ucoparking.negocio.casosuso.EmpleadoCasoDeUso;
import co.edu.uco.ucoparking.transversal.UtilUUID;

public final class EmpleadoCasoDeUsoImpl implements EmpleadoCasoDeUso {

    private final EmpleadoDatos datos;

    public EmpleadoCasoDeUsoImpl(final EmpleadoDatos datos) {
        this.datos = datos;
    }

    @Override
    public void crear(final EmpleadoDominio dominio) {
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
                .stream()
                .map(EmpleadoEntidadAssembler::toDominio)
                .collect(Collectors.toList());
    }

    @Override
    public void modificar(final EmpleadoDominio dominio) {
        datos.modificar(EmpleadoEntidadAssembler.toEntidad(dominio));
    }

    @Override
    public void eliminar(final UUID id) {
        datos.eliminar(id);
    }
}
