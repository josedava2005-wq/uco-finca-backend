package co.edu.uco.ucoparking.negocio.casosuso.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import co.edu.uco.ucoparking.datos.DepartamentoDatos;
import co.edu.uco.ucoparking.dominio.DepartamentoDominio;
import co.edu.uco.ucoparking.negocio.assembler.entidad.DepartamentoEntidadAssembler;
import co.edu.uco.ucoparking.negocio.casosuso.DepartamentoCasoDeUso;
import co.edu.uco.ucoparking.transversal.UtilTexto;
import co.edu.uco.ucoparking.transversal.UtilUUID;
import co.edu.uco.ucoparking.transversal.excepciones.NegocioException;

public final class DepartamentoCasoDeUsoImpl implements DepartamentoCasoDeUso {

    private final DepartamentoDatos datos;

    public DepartamentoCasoDeUsoImpl(final DepartamentoDatos datos) {
        this.datos = datos;
    }

    @Override
    public void crear(final DepartamentoDominio dominio) {
        if (UtilTexto.esNuloOVacio(dominio.getNombre())) {
            throw new NegocioException(
                    "Nombre de departamento nulo o vacío en DepartamentoCasoDeUsoImpl.crear()",
                    "El nombre del departamento es obligatorio");
        }
        if (dominio.getPais() == null || dominio.getPais().getId() == null) {
            throw new NegocioException(
                    "País o su ID es nulo en DepartamentoCasoDeUsoImpl.crear()",
                    "Debe indicar el país del departamento (idPais)");
        }
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
                .stream().map(DepartamentoEntidadAssembler::toDominio).collect(Collectors.toList());
    }

    @Override
    public void modificar(final DepartamentoDominio dominio) {
        if (dominio.getId() == null) {
            throw new NegocioException(
                    "ID de departamento nulo en DepartamentoCasoDeUsoImpl.modificar()",
                    "El ID del departamento es obligatorio para modificar");
        }
        if (UtilTexto.esNuloOVacio(dominio.getNombre())) {
            throw new NegocioException(
                    "Nombre de departamento nulo o vacío en DepartamentoCasoDeUsoImpl.modificar()",
                    "El nombre del departamento es obligatorio");
        }
        if (dominio.getPais() == null || dominio.getPais().getId() == null) {
            throw new NegocioException(
                    "País o su ID es nulo en DepartamentoCasoDeUsoImpl.modificar()",
                    "Debe indicar el país del departamento (idPais)");
        }
        datos.modificar(DepartamentoEntidadAssembler.toEntidad(dominio));
    }

    @Override
    public void eliminar(final UUID id) {
        if (id == null) {
            throw new NegocioException(
                    "ID de departamento nulo en DepartamentoCasoDeUsoImpl.eliminar()",
                    "El ID del departamento es obligatorio para eliminar");
        }
        datos.eliminar(id);
    }
}
