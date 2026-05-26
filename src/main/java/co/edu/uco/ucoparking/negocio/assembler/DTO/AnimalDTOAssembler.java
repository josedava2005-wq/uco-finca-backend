package co.edu.uco.ucoparking.negocio.assembler.DTO;

import java.util.UUID;
import co.edu.uco.ucoparking.dominio.AnimalDominio;
import co.edu.uco.ucoparking.dominio.FincaDominio;
import co.edu.uco.ucoparking.dto.AnimalDTO;

public final class AnimalDTOAssembler {

    private AnimalDTOAssembler() {}

    public static AnimalDominio toDominio(final AnimalDTO dto) {
        FincaDominio finca = dto.getIdFinca() != null
                ? FincaDominio.builder().id(dto.getIdFinca()).build() : null;
        return AnimalDominio.builder()
                .id(dto.getId())
                .nombre(dto.getNombre())
                .especie(dto.getEspecie())
                .raza(dto.getRaza())
                .sexo(dto.getSexo())
                .fechaNacimiento(dto.getFechaNacimiento())
                .pesoKg(dto.getPesoKg())
                .finca(finca)
                .build();
    }

    public static AnimalDTO toDTO(final AnimalDominio dominio) {
        return new AnimalDTO(dominio.getId(), dominio.getNombre(), dominio.getEspecie(), dominio.getRaza(), dominio.getSexo(), dominio.getFechaNacimiento(), dominio.getPesoKg(), dominio.getFinca() != null ? dominio.getFinca().getId() : null);
    }
}
