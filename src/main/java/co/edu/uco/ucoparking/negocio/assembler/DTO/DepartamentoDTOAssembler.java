package co.edu.uco.ucoparking.negocio.assembler.DTO;

import java.util.UUID;
import co.edu.uco.ucoparking.dominio.DepartamentoDominio;
import co.edu.uco.ucoparking.dominio.PaisDominio;
import co.edu.uco.ucoparking.dto.DepartamentoDTO;

public final class DepartamentoDTOAssembler {

    private DepartamentoDTOAssembler() {}

    public static DepartamentoDominio toDominio(final DepartamentoDTO dto) {
        PaisDominio pais = dto.getIdPais() != null
                ? PaisDominio.builder().id(dto.getIdPais()).build() : null;
        return DepartamentoDominio.builder()
                .id(dto.getId())
                .nombre(dto.getNombre())
                .codigoDANE(dto.getCodigoDANE())
                .pais(pais)
                .build();
    }

    public static DepartamentoDTO toDTO(final DepartamentoDominio dominio) {
        return new DepartamentoDTO(dominio.getId(), dominio.getNombre(), dominio.getCodigoDANE(), dominio.getPais() != null ? dominio.getPais().getId() : null);
    }
}
