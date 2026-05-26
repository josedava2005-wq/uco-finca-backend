package co.edu.uco.ucoparking.negocio.assembler.entidad;

import co.edu.uco.ucoparking.dominio.CiudadDominio;
import co.edu.uco.ucoparking.dominio.ClienteDominio;
import co.edu.uco.ucoparking.entidad.CiudadEntidad;
import co.edu.uco.ucoparking.entidad.ClienteEntidad;
import co.edu.uco.ucoparking.negocio.assembler.entidad.CiudadEntidadAssembler;

public final class ClienteEntidadAssembler {

    private ClienteEntidadAssembler() {}

    public static ClienteEntidad toEntidad(final ClienteDominio dominio) {
        CiudadEntidad ciudadEnt = dominio.getCiudad() != null
                ? CiudadEntidadAssembler.toEntidad(dominio.getCiudad()) : null;
        return new ClienteEntidad(dominio.getId(), dominio.getTipoDocumento(), dominio.getNumeroDocumento(), dominio.getNombre(), dominio.getCorreo(), dominio.getTelefono(), ciudadEnt);
    }

    public static ClienteDominio toDominio(final ClienteEntidad entidad) {
        return ClienteDominio.builder()
                .id(entidad.getId())
                .tipoDocumento(entidad.getTipoDocumento())
                .numeroDocumento(entidad.getNumeroDocumento())
                .nombre(entidad.getNombre())
                .correo(entidad.getCorreo())
                .telefono(entidad.getTelefono())
                .ciudad(entidad.getCiudad() != null ? CiudadEntidadAssembler.toDominio(entidad.getCiudad()) : null)
                .build();
    }
}
