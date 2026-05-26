package co.edu.uco.ucoparking.negocio.assembler.entidad;

import co.edu.uco.ucoparking.dominio.AlmacenDominio;
import co.edu.uco.ucoparking.dominio.FincaDominio;
import co.edu.uco.ucoparking.dominio.TipoAlmacenDominio;
import co.edu.uco.ucoparking.entidad.AlmacenEntidad;
import co.edu.uco.ucoparking.entidad.FincaEntidad;
import co.edu.uco.ucoparking.entidad.TipoAlmacenEntidad;
import co.edu.uco.ucoparking.negocio.assembler.entidad.FincaEntidadAssembler;
import co.edu.uco.ucoparking.negocio.assembler.entidad.TipoAlmacenEntidadAssembler;

public final class AlmacenEntidadAssembler {

    private AlmacenEntidadAssembler() {}

    public static AlmacenEntidad toEntidad(final AlmacenDominio dominio) {
        TipoAlmacenEntidad tipoAlmacenEnt = dominio.getTipoAlmacen() != null
                ? TipoAlmacenEntidadAssembler.toEntidad(dominio.getTipoAlmacen()) : null;
        FincaEntidad fincaEnt = dominio.getFinca() != null
                ? FincaEntidadAssembler.toEntidad(dominio.getFinca()) : null;
        return new AlmacenEntidad(dominio.getId(), dominio.getNombre(), dominio.getCapacidadM2(), tipoAlmacenEnt, fincaEnt);
    }

    public static AlmacenDominio toDominio(final AlmacenEntidad entidad) {
        return AlmacenDominio.builder()
                .id(entidad.getId())
                .nombre(entidad.getNombre())
                .capacidadM2(entidad.getCapacidadM2())
                .tipoAlmacen(entidad.getTipoAlmacen() != null ? TipoAlmacenEntidadAssembler.toDominio(entidad.getTipoAlmacen()) : null)
                .finca(entidad.getFinca() != null ? FincaEntidadAssembler.toDominio(entidad.getFinca()) : null)
                .build();
    }
}
