package co.edu.uco.ucoparking.negocio.assembler.entidad;

import co.edu.uco.ucoparking.dominio.DetalleCompraDominio;
import co.edu.uco.ucoparking.dominio.ItemCompraDominio;
import co.edu.uco.ucoparking.entidad.DetalleCompraEntidad;
import co.edu.uco.ucoparking.entidad.ItemCompraEntidad;
import co.edu.uco.ucoparking.negocio.assembler.entidad.ItemCompraEntidadAssembler;

public final class DetalleCompraEntidadAssembler {

    private DetalleCompraEntidadAssembler() {}

    public static DetalleCompraEntidad toEntidad(final DetalleCompraDominio dominio) {
        ItemCompraEntidad itemCompraEnt = dominio.getItemCompra() != null
                ? ItemCompraEntidadAssembler.toEntidad(dominio.getItemCompra()) : null;
        return new DetalleCompraEntidad(dominio.getId(), dominio.getCostoUnitario(), dominio.getSubtotal(), dominio.getDescuento(), itemCompraEnt);
    }

    public static DetalleCompraDominio toDominio(final DetalleCompraEntidad entidad) {
        return DetalleCompraDominio.builder()
                .id(entidad.getId())
                .costoUnitario(entidad.getCostoUnitario())
                .subtotal(entidad.getSubtotal())
                .descuento(entidad.getDescuento())
                .itemCompra(entidad.getItemCompra() != null ? ItemCompraEntidadAssembler.toDominio(entidad.getItemCompra()) : null)
                .build();
    }
}
