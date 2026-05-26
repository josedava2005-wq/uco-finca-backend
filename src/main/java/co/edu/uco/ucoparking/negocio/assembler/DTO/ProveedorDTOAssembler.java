package co.edu.uco.ucoparking.negocio.assembler.DTO;

import java.util.UUID;
import co.edu.uco.ucoparking.dominio.ProveedorDominio;
import co.edu.uco.ucoparking.dto.ProveedorDTO;

public final class ProveedorDTOAssembler {

    private ProveedorDTOAssembler() {}

    public static ProveedorDominio toDominio(final ProveedorDTO dto) {
        return ProveedorDominio.builder()
                .id(dto.getId())
                .tipoDocumento(dto.getTipoDocumento())
                .numeroDocumento(dto.getNumeroDocumento())
                .nombre(dto.getNombre())
                .correo(dto.getCorreo())
                .telefono(dto.getTelefono())
                .direccion(dto.getDireccion())
                .build();
    }

    public static ProveedorDTO toDTO(final ProveedorDominio dominio) {
        return new ProveedorDTO(dominio.getId(), dominio.getTipoDocumento(), dominio.getNumeroDocumento(), dominio.getNombre(), dominio.getCorreo(), dominio.getTelefono(), dominio.getDireccion());
    }
}
