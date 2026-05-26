package co.edu.uco.ucoparking.negocio.casosuso.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import co.edu.uco.ucoparking.datos.CuidadoEspecialDatos;
import co.edu.uco.ucoparking.dominio.CuidadoEspecialDominio;
import co.edu.uco.ucoparking.negocio.assembler.entidad.CuidadoEspecialEntidadAssembler;
import co.edu.uco.ucoparking.negocio.casosuso.CuidadoEspecialCasoDeUso;
import co.edu.uco.ucoparking.transversal.UtilUUID;

public final class CuidadoEspecialCasoDeUsoImpl implements CuidadoEspecialCasoDeUso {

    private final CuidadoEspecialDatos datos;

    public CuidadoEspecialCasoDeUsoImpl(final CuidadoEspecialDatos datos) {
        this.datos = datos;
    }

    @Override
    public void crear(final CuidadoEspecialDominio dominio) {
        final CuidadoEspecialDominio dominioConId = CuidadoEspecialDominio.builder()
                .id(UtilUUID.generarNuevo())
                .tipo(dominio.getTipo())
                .fechaHora(dominio.getFechaHora())
                .descripcion(dominio.getDescripcion())
                .animal(dominio.getAnimal())
                .empleado(dominio.getEmpleado())
                .build();
        datos.crear(CuidadoEspecialEntidadAssembler.toEntidad(dominioConId));
    }

    @Override
    public List<CuidadoEspecialDominio> consultar(final CuidadoEspecialDominio filtro) {
        return datos.consultar(CuidadoEspecialEntidadAssembler.toEntidad(filtro))
                .stream()
                .map(CuidadoEspecialEntidadAssembler::toDominio)
                .collect(Collectors.toList());
    }

    @Override
    public void modificar(final CuidadoEspecialDominio dominio) {
        datos.modificar(CuidadoEspecialEntidadAssembler.toEntidad(dominio));
    }

    @Override
    public void eliminar(final UUID id) {
        datos.eliminar(id);
    }
}
