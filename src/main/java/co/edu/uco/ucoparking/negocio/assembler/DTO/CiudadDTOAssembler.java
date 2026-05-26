package co.edu.uco.ucoparking.negocio.assembler.DTO;

import java.util.UUID;
import co.edu.uco.ucoparking.dominio.CiudadDominio;
import co.edu.uco.ucoparking.dominio.DepartamentoDominio;
import co.edu.uco.ucoparking.dto.CiudadDTO;

public final class CiudadDTOAssembler {

    private CiudadDTOAssembler() {}

    public static CiudadDominio toDominio(final CiudadDTO dto) {
        DepartamentoDominio departamento = dto.getIdDepartamento() != null
                ? DepartamentoDominio.builder().id(dto.getIdDepartamento()).build() : null;
        return CiudadDominio.builder()
                .id(dto.getId())
                .nombre(dto.getNombre())
                .departamento(departamento)
                .build();
    }

    public static CiudadDTO toDTO(final CiudadDominio dominio) {
        return new CiudadDTO(dominio.getId(), dominio.getNombre(), dominio.getDepartamento() != null ? dominio.getDepartamento().getId() : null);
    }
}
