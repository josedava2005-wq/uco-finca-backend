package co.edu.uco.ucoparking.negocio.assembler.entidad;

import co.edu.uco.ucoparking.dominio.TipoAlmacenDominio;
import co.edu.uco.ucoparking.entidad.TipoAlmacenEntidad;

public final class TipoAlmacenEntidadAssembler {

    private TipoAlmacenEntidadAssembler() {}

    public static TipoAlmacenEntidad toEntidad(final TipoAlmacenDominio dominio) {
        return new TipoAlmacenEntidad(dominio.getId(), dominio.getNombre(), dominio.getDescripcion());
    }

    public static TipoAlmacenDominio toDominio(final TipoAlmacenEntidad entidad) {
        return TipoAlmacenDominio.builder()
                .id(entidad.getId())
                .nombre(entidad.getNombre())
                .descripcion(entidad.getDescripcion())
                .build();
    }
}
