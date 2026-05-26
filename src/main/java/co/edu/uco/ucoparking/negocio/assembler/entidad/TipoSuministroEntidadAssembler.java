package co.edu.uco.ucoparking.negocio.assembler.entidad;

import co.edu.uco.ucoparking.dominio.TipoSuministroDominio;
import co.edu.uco.ucoparking.entidad.TipoSuministroEntidad;

public final class TipoSuministroEntidadAssembler {

    private TipoSuministroEntidadAssembler() {}

    public static TipoSuministroEntidad toEntidad(final TipoSuministroDominio dominio) {
        return new TipoSuministroEntidad(dominio.getId(), dominio.getNombre(), dominio.getDescripcion());
    }

    public static TipoSuministroDominio toDominio(final TipoSuministroEntidad entidad) {
        return TipoSuministroDominio.builder()
                .id(entidad.getId())
                .nombre(entidad.getNombre())
                .descripcion(entidad.getDescripcion())
                .build();
    }
}
