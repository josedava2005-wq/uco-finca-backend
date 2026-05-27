package co.edu.uco.ucoparking.negocio.casosuso.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import co.edu.uco.ucoparking.datos.AnimalDatos;
import co.edu.uco.ucoparking.dominio.AnimalDominio;
import co.edu.uco.ucoparking.negocio.assembler.entidad.AnimalEntidadAssembler;
import co.edu.uco.ucoparking.negocio.casosuso.AnimalCasoDeUso;
import co.edu.uco.ucoparking.transversal.UtilTexto;
import co.edu.uco.ucoparking.transversal.UtilUUID;
import co.edu.uco.ucoparking.transversal.excepciones.NegocioException;

public final class AnimalCasoDeUsoImpl implements AnimalCasoDeUso {

    private final AnimalDatos datos;

    public AnimalCasoDeUsoImpl(final AnimalDatos datos) {
        this.datos = datos;
    }

    @Override
    public void crear(final AnimalDominio dominio) {
        if (UtilTexto.esNuloOVacio(dominio.getNombre())) {
            throw new NegocioException(
                    "Nombre de animal nulo o vacío en AnimalCasoDeUsoImpl.crear()",
                    "El nombre del animal es obligatorio");
        }
        if (UtilTexto.esNuloOVacio(dominio.getEspecie())) {
            throw new NegocioException(
                    "Especie de animal nula o vacía en AnimalCasoDeUsoImpl.crear()",
                    "La especie del animal es obligatoria");
        }
        if (dominio.getFinca() == null || dominio.getFinca().getId() == null) {
            throw new NegocioException(
                    "Finca o su ID es nulo en AnimalCasoDeUsoImpl.crear()",
                    "Debe indicar la finca del animal (idFinca)");
        }
        final AnimalDominio dominioConId = AnimalDominio.builder()
                .id(UtilUUID.generarNuevo())
                .nombre(dominio.getNombre())
                .especie(dominio.getEspecie())
                .raza(dominio.getRaza())
                .sexo(dominio.getSexo())
                .fechaNacimiento(dominio.getFechaNacimiento())
                .pesoKg(dominio.getPesoKg())
                .finca(dominio.getFinca())
                .build();
        datos.crear(AnimalEntidadAssembler.toEntidad(dominioConId));
    }

    @Override
    public List<AnimalDominio> consultar(final AnimalDominio filtro) {
        return datos.consultar(AnimalEntidadAssembler.toEntidad(filtro))
                .stream().map(AnimalEntidadAssembler::toDominio).collect(Collectors.toList());
    }

    @Override
    public void modificar(final AnimalDominio dominio) {
        if (dominio.getId() == null) {
            throw new NegocioException(
                    "ID de animal nulo en AnimalCasoDeUsoImpl.modificar()",
                    "El ID del animal es obligatorio para modificar");
        }
        if (UtilTexto.esNuloOVacio(dominio.getNombre())) {
            throw new NegocioException(
                    "Nombre de animal nulo o vacío en AnimalCasoDeUsoImpl.modificar()",
                    "El nombre del animal es obligatorio");
        }
        if (UtilTexto.esNuloOVacio(dominio.getEspecie())) {
            throw new NegocioException(
                    "Especie de animal nula o vacía en AnimalCasoDeUsoImpl.modificar()",
                    "La especie del animal es obligatoria");
        }
        if (dominio.getFinca() == null || dominio.getFinca().getId() == null) {
            throw new NegocioException(
                    "Finca o su ID es nulo en AnimalCasoDeUsoImpl.modificar()",
                    "Debe indicar la finca del animal (idFinca)");
        }
        datos.modificar(AnimalEntidadAssembler.toEntidad(dominio));
    }

    @Override
    public void eliminar(final UUID id) {
        if (id == null) {
            throw new NegocioException(
                    "ID de animal nulo en AnimalCasoDeUsoImpl.eliminar()",
                    "El ID del animal es obligatorio para eliminar");
        }
        datos.eliminar(id);
    }
}
