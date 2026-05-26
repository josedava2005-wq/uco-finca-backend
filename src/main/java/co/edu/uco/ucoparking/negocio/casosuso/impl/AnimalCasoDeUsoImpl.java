package co.edu.uco.ucoparking.negocio.casosuso.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import co.edu.uco.ucoparking.datos.AnimalDatos;
import co.edu.uco.ucoparking.dominio.AnimalDominio;
import co.edu.uco.ucoparking.negocio.assembler.entidad.AnimalEntidadAssembler;
import co.edu.uco.ucoparking.negocio.casosuso.AnimalCasoDeUso;
import co.edu.uco.ucoparking.transversal.UtilUUID;

public final class AnimalCasoDeUsoImpl implements AnimalCasoDeUso {

    private final AnimalDatos datos;

    public AnimalCasoDeUsoImpl(final AnimalDatos datos) {
        this.datos = datos;
    }

    @Override
    public void crear(final AnimalDominio dominio) {
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
                .stream()
                .map(AnimalEntidadAssembler::toDominio)
                .collect(Collectors.toList());
    }

    @Override
    public void modificar(final AnimalDominio dominio) {
        datos.modificar(AnimalEntidadAssembler.toEntidad(dominio));
    }

    @Override
    public void eliminar(final UUID id) {
        datos.eliminar(id);
    }
}
