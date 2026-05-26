package co.edu.uco.ucoparking.negocio.assembler.entidad;

import co.edu.uco.ucoparking.dominio.AlmacenDominio;
import co.edu.uco.ucoparking.dominio.ProveedorDominio;
import co.edu.uco.ucoparking.dominio.SuministroDominio;
import co.edu.uco.ucoparking.dominio.TipoSuministroDominio;
import co.edu.uco.ucoparking.entidad.AlmacenEntidad;
import co.edu.uco.ucoparking.entidad.ProveedorEntidad;
import co.edu.uco.ucoparking.entidad.SuministroEntidad;
import co.edu.uco.ucoparking.entidad.TipoSuministroEntidad;
import co.edu.uco.ucoparking.negocio.assembler.entidad.AlmacenEntidadAssembler;
import co.edu.uco.ucoparking.negocio.assembler.entidad.ProveedorEntidadAssembler;
import co.edu.uco.ucoparking.negocio.assembler.entidad.TipoSuministroEntidadAssembler;

public final class SuministroEntidadAssembler {

    private SuministroEntidadAssembler() {}

    public static SuministroEntidad toEntidad(final SuministroDominio dominio) {
        TipoSuministroEntidad tipoSuministroEnt = dominio.getTipoSuministro() != null
                ? TipoSuministroEntidadAssembler.toEntidad(dominio.getTipoSuministro()) : null;
        AlmacenEntidad almacenEnt = dominio.getAlmacen() != null
                ? AlmacenEntidadAssembler.toEntidad(dominio.getAlmacen()) : null;
        ProveedorEntidad proveedorEnt = dominio.getProveedor() != null
                ? ProveedorEntidadAssembler.toEntidad(dominio.getProveedor()) : null;
        return new SuministroEntidad(dominio.getId(), dominio.getNombre(), dominio.getCantidad(), dominio.getUnidadMedida(), tipoSuministroEnt, almacenEnt, proveedorEnt);
    }

    public static SuministroDominio toDominio(final SuministroEntidad entidad) {
        return SuministroDominio.builder()
                .id(entidad.getId())
                .nombre(entidad.getNombre())
                .cantidad(entidad.getCantidad())
                .unidadMedida(entidad.getUnidadMedida())
                .tipoSuministro(entidad.getTipoSuministro() != null ? TipoSuministroEntidadAssembler.toDominio(entidad.getTipoSuministro()) : null)
                .almacen(entidad.getAlmacen() != null ? AlmacenEntidadAssembler.toDominio(entidad.getAlmacen()) : null)
                .proveedor(entidad.getProveedor() != null ? ProveedorEntidadAssembler.toDominio(entidad.getProveedor()) : null)
                .build();
    }
}
