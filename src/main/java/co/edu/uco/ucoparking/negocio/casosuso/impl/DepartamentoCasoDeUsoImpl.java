package co.edu.uco.ucoparking.negocio.casosuso.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import co.edu.uco.ucoparking.datos.DepartamentoDatos;
import co.edu.uco.ucoparking.dominio.DepartamentoDominio;
import co.edu.uco.ucoparking.negocio.assembler.entidad.DepartamentoEntidadAssembler;
import co.edu.uco.ucoparking.negocio.casosuso.DepartamentoCasoDeUso;
import co.edu.uco.ucoparking.transversal.UtilUUID;

public final class DepartamentoCasoDeUsoImpl implements DepartamentoCasoDeUso {

    private final DepartamentoDatos datos;

    public DepartamentoCasoDeUsoImpl(final DepartamentoDatos datos) {
        this.datos = datos;
    }

    @Override
    public void crear(final DepartamentoDominio dominio) {
        final DepartamentoDominio dominioConId = DepartamentoDominio.builder()
                .id(UtilUUID.generarNuevo())
                .nombre(dominio.getNombre())
                .codigoDANE(dominio.getCodigoDANE())
                .pais(dominio.getPais())
                .build();
        datos.crear(DepartamentoEntidadAssembler.toEntidad(dominioConId));
    }

    @Override
    public List<DepartamentoDominio> consultar(final DepartamentoDominio filtro) {
        return datos.consultar(DepartamentoEntidadAssembler.toEntidad(filtro))
                .stream()
                .map(DepartamentoEntidadAssembler::toDominio)
                .collect(Collectors.toList());
    }

    @Override
    public void modificar(final DepartamentoDominio dominio) {
        datos.modificar(DepartamentoEntidadAssembler.toEntidad(dominio));
    }

    @Override
    public void eliminar(final UUID id) {
        datos.eliminar(id);
    }
}
