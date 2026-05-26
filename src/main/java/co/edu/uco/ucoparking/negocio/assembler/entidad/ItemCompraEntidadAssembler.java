package co.edu.uco.ucoparking.negocio.assembler.entidad;

import co.edu.uco.ucoparking.dominio.CompraDominio;
import co.edu.uco.ucoparking.dominio.ItemCompraDominio;
import co.edu.uco.ucoparking.dominio.ProductoDominio;
import co.edu.uco.ucoparking.entidad.CompraEntidad;
import co.edu.uco.ucoparking.entidad.ItemCompraEntidad;
import co.edu.uco.ucoparking.entidad.ProductoEntidad;
import co.edu.uco.ucoparking.negocio.assembler.entidad.CompraEntidadAssembler;
import co.edu.uco.ucoparking.negocio.assembler.entidad.ProductoEntidadAssembler;

public final class ItemCompraEntidadAssembler {

    private ItemCompraEntidadAssembler() {}

    public static ItemCompraEntidad toEntidad(final ItemCompraDominio dominio) {
        CompraEntidad compraEnt = dominio.getCompra() != null
                ? CompraEntidadAssembler.toEntidad(dominio.getCompra()) : null;
        ProductoEntidad productoEnt = dominio.getProducto() != null
                ? ProductoEntidadAssembler.toEntidad(dominio.getProducto()) : null;
        return new ItemCompraEntidad(dominio.getId(), dominio.getCantidad(), dominio.getPrecioUnitario(), compraEnt, productoEnt);
    }

    public static ItemCompraDominio toDominio(final ItemCompraEntidad entidad) {
        return ItemCompraDominio.builder()
                .id(entidad.getId())
                .cantidad(entidad.getCantidad())
                .precioUnitario(entidad.getPrecioUnitario())
                .compra(entidad.getCompra() != null ? CompraEntidadAssembler.toDominio(entidad.getCompra()) : null)
                .producto(entidad.getProducto() != null ? ProductoEntidadAssembler.toDominio(entidad.getProducto()) : null)
                .build();
    }
}
