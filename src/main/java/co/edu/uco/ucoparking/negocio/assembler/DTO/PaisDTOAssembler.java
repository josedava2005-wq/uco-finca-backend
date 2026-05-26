package co.edu.uco.ucoparking.negocio.assembler.DTO;

import java.util.UUID;
import co.edu.uco.ucoparking.dominio.PaisDominio;
import co.edu.uco.ucoparking.dto.PaisDTO;

public final class PaisDTOAssembler {

    private PaisDTOAssembler() {}

    public static PaisDominio toDominio(final PaisDTO dto) {
        return PaisDominio.builder()
                .id(dto.getId())
                .nombre(dto.getNombre())
                .codigoISO(dto.getCodigoISO())
                .continente(dto.getContinente())
                .idioma(dto.getIdioma())
                .moneda(dto.getMoneda())
                .telefono(dto.getTelefono())
                .build();
    }

    public static PaisDTO toDTO(final PaisDominio dominio) {
        return new PaisDTO(dominio.getId(), dominio.getNombre(), dominio.getCodigoISO(), dominio.getContinente(), dominio.getIdioma(), dominio.getMoneda(), dominio.getTelefono());
    }
}
