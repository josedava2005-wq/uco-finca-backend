package co.edu.uco.ucoparking.negocio.casosuso.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import co.edu.uco.ucoparking.datos.AlmacenDatos;
import co.edu.uco.ucoparking.dominio.AlmacenDominio;
import co.edu.uco.ucoparking.negocio.assembler.entidad.AlmacenEntidadAssembler;
import co.edu.uco.ucoparking.negocio.casosuso.AlmacenCasoDeUso;
import co.edu.uco.ucoparking.transversal.UtilTexto;
import co.edu.uco.ucoparking.transversal.UtilUUID;
import co.edu.uco.ucoparking.transversal.excepciones.NegocioException;

public final class AlmacenCasoDeUsoImpl implements AlmacenCasoDeUso {

    private final AlmacenDatos datos;

    public AlmacenCasoDeUsoImpl(final AlmacenDatos datos) {
        this.datos = datos;
    }

    @Override
    public void crear(final AlmacenDominio dominio) {
        if (UtilTexto.esNuloOVacio(dominio.getNombre())) {
            throw new NegocioException(
                    "Nombre de almacén nulo o vacío en AlmacenCasoDeUsoImpl.crear()",
                    "El nombre del almacén es obligatorio");
        }
        if (dominio.getTipoAlmacen() == null || dominio.getTipoAlmacen().getId() == null) {
            throw new NegocioException(
                    "TipoAlmacen o su ID es nulo en AlmacenCasoDeUsoImpl.crear()",
                    "Debe indicar el tipo de almacén (idTipoAlmacen)");
        }
        if (dominio.getFinca() == null || dominio.getFinca().getId() == null) {
            throw new NegocioException(
                    "Finca o su ID es nulo en AlmacenCasoDeUsoImpl.crear()",
                    "Debe indicar la finca del almacén (idFinca)");
        }
        final AlmacenDominio dominioConId = AlmacenDominio.builder()
                .id(UtilUUID.generarNuevo())
                .nombre(dominio.getNombre())
                .capacidadM2(dominio.getCapacidadM2())
                .tipoAlmacen(dominio.getTipoAlmacen())
                .finca(dominio.getFinca())
                .build();
        datos.crear(AlmacenEntidadAssembler.toEntidad(dominioConId));
    }

    @Override
    public List<AlmacenDominio> consultar(final AlmacenDominio filtro) {
        return datos.consultar(AlmacenEntidadAssembler.toEntidad(filtro))
                .stream().map(AlmacenEntidadAssembler::toDominio).collect(Collectors.toList());
    }

    @Override
    public void modificar(final AlmacenDominio dominio) {
        if (dominio.getId() == null) {
            throw new NegocioException(
                    "ID de almacén nulo en AlmacenCasoDeUsoImpl.modificar()",
                    "El ID del almacén es obligatorio para modificar");
        }
        if (UtilTexto.esNuloOVacio(dominio.getNombre())) {
            throw new NegocioException(
                    "Nombre de almacén nulo o vacío en AlmacenCasoDeUsoImpl.modificar()",
                    "El nombre del almacén es obligatorio");
        }
        if (dominio.getTipoAlmacen() == null || dominio.getTipoAlmacen().getId() == null) {
            throw new NegocioException(
                    "TipoAlmacen o su ID es nulo en AlmacenCasoDeUsoImpl.modificar()",
                    "Debe indicar el tipo de almacén (idTipoAlmacen)");
        }
        if (dominio.getFinca() == null || dominio.getFinca().getId() == null) {
            throw new NegocioException(
                    "Finca o su ID es nulo en AlmacenCasoDeUsoImpl.modificar()",
                    "Debe indicar la finca del almacén (idFinca)");
        }
        datos.modificar(AlmacenEntidadAssembler.toEntidad(dominio));
    }

    @Override
    public void eliminar(final UUID id) {
        if (id == null) {
            throw new NegocioException(
                    "ID de almacén nulo en AlmacenCasoDeUsoImpl.eliminar()",
                    "El ID del almacén es obligatorio para eliminar");
        }
        datos.eliminar(id);
    }
}
