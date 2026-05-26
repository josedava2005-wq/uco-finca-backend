package co.edu.uco.ucoparking.negocio.casosuso.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import co.edu.uco.ucoparking.datos.AlmacenDatos;
import co.edu.uco.ucoparking.dominio.AlmacenDominio;
import co.edu.uco.ucoparking.negocio.assembler.entidad.AlmacenEntidadAssembler;
import co.edu.uco.ucoparking.negocio.casosuso.AlmacenCasoDeUso;
import co.edu.uco.ucoparking.transversal.UtilUUID;

public final class AlmacenCasoDeUsoImpl implements AlmacenCasoDeUso {

    private final AlmacenDatos datos;

    public AlmacenCasoDeUsoImpl(final AlmacenDatos datos) {
        this.datos = datos;
    }

    @Override
    public void crear(final AlmacenDominio dominio) {
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
                .stream()
                .map(AlmacenEntidadAssembler::toDominio)
                .collect(Collectors.toList());
    }

    @Override
    public void modificar(final AlmacenDominio dominio) {
        datos.modificar(AlmacenEntidadAssembler.toEntidad(dominio));
    }

    @Override
    public void eliminar(final UUID id) {
        datos.eliminar(id);
    }
}
