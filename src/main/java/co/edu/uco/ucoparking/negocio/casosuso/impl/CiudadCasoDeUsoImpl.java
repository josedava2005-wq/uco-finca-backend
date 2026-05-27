package co.edu.uco.ucoparking.negocio.casosuso.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import co.edu.uco.ucoparking.datos.CiudadDatos;
import co.edu.uco.ucoparking.dominio.CiudadDominio;
import co.edu.uco.ucoparking.negocio.assembler.entidad.CiudadEntidadAssembler;
import co.edu.uco.ucoparking.negocio.casosuso.CiudadCasoDeUso;
import co.edu.uco.ucoparking.transversal.UtilTexto;
import co.edu.uco.ucoparking.transversal.UtilUUID;
import co.edu.uco.ucoparking.transversal.excepciones.NegocioException;

public final class CiudadCasoDeUsoImpl implements CiudadCasoDeUso {

    private final CiudadDatos datos;

    public CiudadCasoDeUsoImpl(final CiudadDatos datos) {
        this.datos = datos;
    }

    @Override
    public void crear(final CiudadDominio dominio) {
        if (UtilTexto.esNuloOVacio(dominio.getNombre())) {
            throw new NegocioException(
                    "Nombre de ciudad nulo o vacío en CiudadCasoDeUsoImpl.crear()",
                    "El nombre de la ciudad es obligatorio");
        }
        if (dominio.getDepartamento() == null || dominio.getDepartamento().getId() == null) {
            throw new NegocioException(
                    "Departamento o su ID es nulo en CiudadCasoDeUsoImpl.crear()",
                    "Debe indicar el departamento de la ciudad (idDepartamento)");
        }
        final CiudadDominio dominioConId = CiudadDominio.builder()
                .id(UtilUUID.generarNuevo())
                .nombre(dominio.getNombre())
                .departamento(dominio.getDepartamento())
                .build();
        datos.crear(CiudadEntidadAssembler.toEntidad(dominioConId));
    }

    @Override
    public List<CiudadDominio> consultar(final CiudadDominio filtro) {
        return datos.consultar(CiudadEntidadAssembler.toEntidad(filtro))
                .stream().map(CiudadEntidadAssembler::toDominio).collect(Collectors.toList());
    }

    @Override
    public void modificar(final CiudadDominio dominio) {
        if (dominio.getId() == null) {
            throw new NegocioException(
                    "ID de ciudad nulo en CiudadCasoDeUsoImpl.modificar()",
                    "El ID de la ciudad es obligatorio para modificar");
        }
        if (UtilTexto.esNuloOVacio(dominio.getNombre())) {
            throw new NegocioException(
                    "Nombre de ciudad nulo o vacío en CiudadCasoDeUsoImpl.modificar()",
                    "El nombre de la ciudad es obligatorio");
        }
        if (dominio.getDepartamento() == null || dominio.getDepartamento().getId() == null) {
            throw new NegocioException(
                    "Departamento o su ID es nulo en CiudadCasoDeUsoImpl.modificar()",
                    "Debe indicar el departamento de la ciudad (idDepartamento)");
        }
        datos.modificar(CiudadEntidadAssembler.toEntidad(dominio));
    }

    @Override
    public void eliminar(final UUID id) {
        if (id == null) {
            throw new NegocioException(
                    "ID de ciudad nulo en CiudadCasoDeUsoImpl.eliminar()",
                    "El ID de la ciudad es obligatorio para eliminar");
        }
        datos.eliminar(id);
    }
}
