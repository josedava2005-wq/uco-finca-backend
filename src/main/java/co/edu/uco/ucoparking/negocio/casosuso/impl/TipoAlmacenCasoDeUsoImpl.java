package co.edu.uco.ucoparking.negocio.casosuso.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import co.edu.uco.ucoparking.datos.TipoAlmacenDatos;
import co.edu.uco.ucoparking.dominio.TipoAlmacenDominio;
import co.edu.uco.ucoparking.negocio.assembler.entidad.TipoAlmacenEntidadAssembler;
import co.edu.uco.ucoparking.negocio.casosuso.TipoAlmacenCasoDeUso;
import co.edu.uco.ucoparking.transversal.UtilTexto;
import co.edu.uco.ucoparking.transversal.UtilUUID;
import co.edu.uco.ucoparking.transversal.excepciones.NegocioException;

public final class TipoAlmacenCasoDeUsoImpl implements TipoAlmacenCasoDeUso {

    private final TipoAlmacenDatos datos;

    public TipoAlmacenCasoDeUsoImpl(final TipoAlmacenDatos datos) {
        this.datos = datos;
    }

    @Override
    public void crear(final TipoAlmacenDominio dominio) {
        if (UtilTexto.esNuloOVacio(dominio.getNombre())) {
            throw new NegocioException(
                    "Nombre de tipo almacén nulo o vacío en TipoAlmacenCasoDeUsoImpl.crear()",
                    "El nombre del tipo de almacén es obligatorio");
        }
        final TipoAlmacenDominio dominioConId = TipoAlmacenDominio.builder()
                .id(UtilUUID.generarNuevo())
                .nombre(dominio.getNombre())
                .descripcion(dominio.getDescripcion())
                .build();
        datos.crear(TipoAlmacenEntidadAssembler.toEntidad(dominioConId));
    }

    @Override
    public List<TipoAlmacenDominio> consultar(final TipoAlmacenDominio filtro) {
        return datos.consultar(TipoAlmacenEntidadAssembler.toEntidad(filtro))
                .stream().map(TipoAlmacenEntidadAssembler::toDominio).collect(Collectors.toList());
    }

    @Override
    public void modificar(final TipoAlmacenDominio dominio) {
        if (dominio.getId() == null) {
            throw new NegocioException(
                    "ID de tipo almacén nulo en TipoAlmacenCasoDeUsoImpl.modificar()",
                    "El ID del tipo de almacén es obligatorio para modificar");
        }
        if (UtilTexto.esNuloOVacio(dominio.getNombre())) {
            throw new NegocioException(
                    "Nombre de tipo almacén nulo o vacío en TipoAlmacenCasoDeUsoImpl.modificar()",
                    "El nombre del tipo de almacén es obligatorio");
        }
        datos.modificar(TipoAlmacenEntidadAssembler.toEntidad(dominio));
    }

    @Override
    public void eliminar(final UUID id) {
        if (id == null) {
            throw new NegocioException(
                    "ID de tipo almacén nulo en TipoAlmacenCasoDeUsoImpl.eliminar()",
                    "El ID del tipo de almacén es obligatorio para eliminar");
        }
        datos.eliminar(id);
    }
}
