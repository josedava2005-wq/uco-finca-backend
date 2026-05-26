package co.edu.uco.ucoparking.negocio.fachada.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import co.edu.uco.ucoparking.datos.ClienteDatos;
import co.edu.uco.ucoparking.dto.ClienteDTO;
import co.edu.uco.ucoparking.negocio.assembler.DTO.ClienteDTOAssembler;
import co.edu.uco.ucoparking.negocio.casosuso.impl.ClienteCasoDeUsoImpl;
import co.edu.uco.ucoparking.negocio.fachada.ClienteFachada;

@Service
public final class ClienteFachadaImpl implements ClienteFachada {

    private final ClienteDatos datos;

    public ClienteFachadaImpl(final ClienteDatos datos) {
        this.datos = datos;
    }

    @Override
    public void crear(final ClienteDTO dto) {
        new ClienteCasoDeUsoImpl(datos).crear(ClienteDTOAssembler.toDominio(dto));
    }

    @Override
    public List<ClienteDTO> consultar(final ClienteDTO filtro) {
        return new ClienteCasoDeUsoImpl(datos)
                .consultar(ClienteDTOAssembler.toDominio(filtro))
                .stream()
                .map(ClienteDTOAssembler::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void modificar(final ClienteDTO dto) {
        new ClienteCasoDeUsoImpl(datos).modificar(ClienteDTOAssembler.toDominio(dto));
    }

    @Override
    public void eliminar(final UUID id) {
        new ClienteCasoDeUsoImpl(datos).eliminar(id);
    }
}
