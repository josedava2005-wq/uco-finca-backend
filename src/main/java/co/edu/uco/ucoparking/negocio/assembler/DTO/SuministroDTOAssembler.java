package co.edu.uco.ucoparking.negocio.assembler.DTO;

import java.util.UUID;
import co.edu.uco.ucoparking.dominio.AlmacenDominio;
import co.edu.uco.ucoparking.dominio.ProveedorDominio;
import co.edu.uco.ucoparking.dominio.SuministroDominio;
import co.edu.uco.ucoparking.dominio.TipoSuministroDominio;
import co.edu.uco.ucoparking.dto.SuministroDTO;

public final class SuministroDTOAssembler {

    private SuministroDTOAssembler() {}

    public static SuministroDominio toDominio(final SuministroDTO dto) {
        TipoSuministroDominio tipoSuministro = dto.getIdTipoSuministro() != null
                ? TipoSuministroDominio.builder().id(dto.getIdTipoSuministro()).build() : null;
        AlmacenDominio almacen = dto.getIdAlmacen() != null
                ? AlmacenDominio.builder().id(dto.getIdAlmacen()).build() : null;
        ProveedorDominio proveedor = dto.getIdProveedor() != null
                ? ProveedorDominio.builder().id(dto.getIdProveedor()).build() : null;
        return SuministroDominio.builder()
                .id(dto.getId())
                .nombre(dto.getNombre())
                .cantidad(dto.getCantidad())
                .unidadMedida(dto.getUnidadMedida())
                .tipoSuministro(tipoSuministro)
                .almacen(almacen)
                .proveedor(proveedor)
                .build();
    }

    public static SuministroDTO toDTO(final SuministroDominio dominio) {
        return new SuministroDTO(dominio.getId(), dominio.getNombre(), dominio.getCantidad(), dominio.getUnidadMedida(), dominio.getTipoSuministro() != null ? dominio.getTipoSuministro().getId() : null, dominio.getAlmacen() != null ? dominio.getAlmacen().getId() : null, dominio.getProveedor() != null ? dominio.getProveedor().getId() : null);
    }
}
