package co.edu.uco.ucoparking.negocio.assembler.DTO;

import java.util.UUID;
import co.edu.uco.ucoparking.dominio.CiudadDominio;
import co.edu.uco.ucoparking.dominio.ClienteDominio;
import co.edu.uco.ucoparking.dto.ClienteDTO;

public final class ClienteDTOAssembler {

    private ClienteDTOAssembler() {}

    public static ClienteDominio toDominio(final ClienteDTO dto) {
        CiudadDominio ciudad = dto.getIdCiudad() != null
                ? CiudadDominio.builder().id(dto.getIdCiudad()).build() : null;
        return ClienteDominio.builder()
                .id(dto.getId())
                .tipoDocumento(dto.getTipoDocumento())
                .numeroDocumento(dto.getNumeroDocumento())
                .nombre(dto.getNombre())
                .correo(dto.getCorreo())
                .telefono(dto.getTelefono())
                .ciudad(ciudad)
                .build();
    }

    public static ClienteDTO toDTO(final ClienteDominio dominio) {
        return new ClienteDTO(dominio.getId(), dominio.getTipoDocumento(), dominio.getNumeroDocumento(), dominio.getNombre(), dominio.getCorreo(), dominio.getTelefono(), dominio.getCiudad() != null ? dominio.getCiudad().getId() : null);
    }
}
