package co.edu.uco.ucoparking.negocio.casosuso.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import co.edu.uco.ucoparking.datos.EstadoAnimalDatos;
import co.edu.uco.ucoparking.dominio.EstadoAnimalDominio;
import co.edu.uco.ucoparking.negocio.assembler.entidad.EstadoAnimalEntidadAssembler;
import co.edu.uco.ucoparking.negocio.casosuso.EstadoAnimalCasoDeUso;
import co.edu.uco.ucoparking.transversal.UtilUUID;

public final class EstadoAnimalCasoDeUsoImpl implements EstadoAnimalCasoDeUso {

    private final EstadoAnimalDatos datos;

    public EstadoAnimalCasoDeUsoImpl(final EstadoAnimalDatos datos) {
        this.datos = datos;
    }

    @Override
    public void crear(final EstadoAnimalDominio dominio) {
        final EstadoAnimalDominio dominioConId = EstadoAnimalDominio.builder()
                .id(UtilUUID.generarNuevo())
                .estado(dominio.getEstado())
                .fechaRegistro(dominio.getFechaRegistro())
                .observacion(dominio.getObservacion())
                .animal(dominio.getAnimal())
                .build();
        datos.crear(EstadoAnimalEntidadAssembler.toEntidad(dominioConId));
    }

    @Override
    public List<EstadoAnimalDominio> consultar(final EstadoAnimalDominio filtro) {
        return datos.consultar(EstadoAnimalEntidadAssembler.toEntidad(filtro))
                .stream()
                .map(EstadoAnimalEntidadAssembler::toDominio)
                .collect(Collectors.toList());
    }

    @Override
    public void modificar(final EstadoAnimalDominio dominio) {
        datos.modificar(EstadoAnimalEntidadAssembler.toEntidad(dominio));
    }

    @Override
    public void eliminar(final UUID id) {
        datos.eliminar(id);
    }
}
