package co.edu.uco.ucoparking.negocio.casosuso.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import co.edu.uco.ucoparking.datos.EstadoAnimalDatos;
import co.edu.uco.ucoparking.dominio.EstadoAnimalDominio;
import co.edu.uco.ucoparking.negocio.assembler.entidad.EstadoAnimalEntidadAssembler;
import co.edu.uco.ucoparking.negocio.casosuso.EstadoAnimalCasoDeUso;
import co.edu.uco.ucoparking.transversal.UtilTexto;
import co.edu.uco.ucoparking.transversal.UtilUUID;
import co.edu.uco.ucoparking.transversal.excepciones.NegocioException;

public final class EstadoAnimalCasoDeUsoImpl implements EstadoAnimalCasoDeUso {

    private final EstadoAnimalDatos datos;

    public EstadoAnimalCasoDeUsoImpl(final EstadoAnimalDatos datos) {
        this.datos = datos;
    }

    @Override
    public void crear(final EstadoAnimalDominio dominio) {
        validarCamposObligatorios(dominio);
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
        if (dominio.getId() == null) {
            throw new NegocioException(
                    "EstadoAnimalCasoDeUsoImpl.modificar: el id del estado del animal es obligatorio.",
                    "El id del estado del animal es obligatorio para modificar.");
        }
        validarCamposObligatorios(dominio);
        datos.modificar(EstadoAnimalEntidadAssembler.toEntidad(dominio));
    }

    @Override
    public void eliminar(final UUID id) {
        if (id == null) {
            throw new NegocioException(
                    "EstadoAnimalCasoDeUsoImpl.eliminar: el id del estado del animal es obligatorio.",
                    "El id del estado del animal es obligatorio para eliminar.");
        }
        datos.eliminar(id);
    }

    private void validarCamposObligatorios(final EstadoAnimalDominio dominio) {
        if (UtilTexto.esNuloOVacio(dominio.getEstado())) {
            throw new NegocioException(
                    "EstadoAnimalCasoDeUsoImpl: el estado del animal es obligatorio.",
                    "El estado del animal es obligatorio.");
        }
        if (dominio.getAnimal() == null || dominio.getAnimal().getId() == null) {
            throw new NegocioException(
                    "EstadoAnimalCasoDeUsoImpl: el animal asociado al estado es obligatorio.",
                    "El animal asociado al estado es obligatorio.");
        }
    }
}
