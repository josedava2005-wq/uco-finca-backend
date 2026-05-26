package co.edu.uco.ucoparking.negocio.assembler.entidad;

import co.edu.uco.ucoparking.dominio.ProveedorDominio;
import co.edu.uco.ucoparking.entidad.ProveedorEntidad;

public final class ProveedorEntidadAssembler {

    private ProveedorEntidadAssembler() {}

    public static ProveedorEntidad toEntidad(final ProveedorDominio dominio) {
        return new ProveedorEntidad(dominio.getId(), dominio.getTipoDocumento(), dominio.getNumeroDocumento(), dominio.getNombre(), dominio.getCorreo(), dominio.getTelefono(), dominio.getDireccion());
    }

    public static ProveedorDominio toDominio(final ProveedorEntidad entidad) {
        return ProveedorDominio.builder()
                .id(entidad.getId())
                .tipoDocumento(entidad.getTipoDocumento())
                .numeroDocumento(entidad.getNumeroDocumento())
                .nombre(entidad.getNombre())
                .correo(entidad.getCorreo())
                .telefono(entidad.getTelefono())
                .direccion(entidad.getDireccion())
                .build();
    }
}
