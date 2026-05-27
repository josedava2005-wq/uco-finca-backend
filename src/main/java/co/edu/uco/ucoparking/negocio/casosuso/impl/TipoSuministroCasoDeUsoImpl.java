package co.edu.uco.ucoparking.negocio.casosuso.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import co.edu.uco.ucoparking.datos.TipoSuministroDatos;
import co.edu.uco.ucoparking.dominio.TipoSuministroDominio;
import co.edu.uco.ucoparking.negocio.assembler.entidad.TipoSuministroEntidadAssembler;
import co.edu.uco.ucoparking.negocio.casosuso.TipoSuministroCasoDeUso;
import co.edu.uco.ucoparking.transversal.UtilTexto;
import co.edu.uco.ucoparking.transversal.UtilUUID;
import co.edu.uco.ucoparking.transversal.excepciones.NegocioException;

public final class TipoSuministroCasoDeUsoImpl implements TipoSuministroCasoDeUso {

    private final TipoSuministroDatos datos;

    public TipoSuministroCasoDeUsoImpl(final TipoSuministroDatos datos) {
        this.datos = datos;
    }

    @Override
    public void crear(final TipoSuministroDominio dominio) {
        if (UtilTexto.esNuloOVacio(dominio.getNombre())) {
            throw new NegocioException(
                    "Nombre de tipo suministro nulo o vacío en TipoSuministroCasoDeUsoImpl.crear()",
                    "El nombre del tipo de suministro es obligatorio");
        }
        final TipoSuministroDominio dominioConId = TipoSuministroDominio.builder()
                .id(UtilUUID.generarNuevo())
                .nombre(dominio.getNombre())
                .descripcion(dominio.getDescripcion())
                .build();
        datos.crear(TipoSuministroEntidadAssembler.toEntidad(dominioConId));
    }

    @Override
    public List<TipoSuministroDominio> consultar(final TipoSuministroDominio filtro) {
        return datos.consultar(TipoSuministroEntidadAssembler.toEntidad(filtro))
                .stream().map(TipoSuministroEntidadAssembler::toDominio).collect(Collectors.toList());
    }

    @Override
    public void modificar(final TipoSuministroDominio dominio) {
        if (dominio.getId() == null) {
            throw new NegocioException(
                    "ID de tipo suministro nulo en TipoSuministroCasoDeUsoImpl.modificar()",
                    "El ID del tipo de suministro es obligatorio para modificar");
        }
        if (UtilTexto.esNuloOVacio(dominio.getNombre())) {
            throw new NegocioException(
                    "Nombre de tipo suministro nulo o vacío en TipoSuministroCasoDeUsoImpl.modificar()",
                    "El nombre del tipo de suministro es obligatorio");
        }
        datos.modificar(TipoSuministroEntidadAssembler.toEntidad(dominio));
    }

    @Override
    public void eliminar(final UUID id) {
        if (id == null) {
            throw new NegocioException(
                    "ID de tipo suministro nulo en TipoSuministroCasoDeUsoImpl.eliminar()",
                    "El ID del tipo de suministro es obligatorio para eliminar");
        }
        datos.eliminar(id);
    }
}
