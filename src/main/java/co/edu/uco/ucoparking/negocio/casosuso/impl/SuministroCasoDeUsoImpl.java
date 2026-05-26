package co.edu.uco.ucoparking.negocio.casosuso.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import co.edu.uco.ucoparking.datos.SuministroDatos;
import co.edu.uco.ucoparking.dominio.SuministroDominio;
import co.edu.uco.ucoparking.negocio.assembler.entidad.SuministroEntidadAssembler;
import co.edu.uco.ucoparking.negocio.casosuso.SuministroCasoDeUso;
import co.edu.uco.ucoparking.transversal.UtilUUID;

public final class SuministroCasoDeUsoImpl implements SuministroCasoDeUso {

    private final SuministroDatos datos;

    public SuministroCasoDeUsoImpl(final SuministroDatos datos) {
        this.datos = datos;
    }

    @Override
    public void crear(final SuministroDominio dominio) {
        final SuministroDominio dominioConId = SuministroDominio.builder()
                .id(UtilUUID.generarNuevo())
                .nombre(dominio.getNombre())
                .cantidad(dominio.getCantidad())
                .unidadMedida(dominio.getUnidadMedida())
                .tipoSuministro(dominio.getTipoSuministro())
                .almacen(dominio.getAlmacen())
                .proveedor(dominio.getProveedor())
                .build();
        datos.crear(SuministroEntidadAssembler.toEntidad(dominioConId));
    }

    @Override
    public List<SuministroDominio> consultar(final SuministroDominio filtro) {
        return datos.consultar(SuministroEntidadAssembler.toEntidad(filtro))
                .stream()
                .map(SuministroEntidadAssembler::toDominio)
                .collect(Collectors.toList());
    }

    @Override
    public void modificar(final SuministroDominio dominio) {
        datos.modificar(SuministroEntidadAssembler.toEntidad(dominio));
    }

    @Override
    public void eliminar(final UUID id) {
        datos.eliminar(id);
    }
}
