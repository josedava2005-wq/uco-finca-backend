package co.edu.uco.ucoparking.negocio.fachada.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import co.edu.uco.ucoparking.datos.ProductoDatos;
import co.edu.uco.ucoparking.dto.ProductoDTO;
import co.edu.uco.ucoparking.negocio.assembler.DTO.ProductoDTOAssembler;
import co.edu.uco.ucoparking.negocio.casosuso.impl.ProductoCasoDeUsoImpl;
import co.edu.uco.ucoparking.negocio.fachada.ProductoFachada;

@Service
public final class ProductoFachadaImpl implements ProductoFachada {

    private final ProductoDatos datos;

    public ProductoFachadaImpl(final ProductoDatos datos) {
        this.datos = datos;
    }

    @Override
    public void crear(final ProductoDTO dto) {
        new ProductoCasoDeUsoImpl(datos).crear(ProductoDTOAssembler.toDominio(dto));
    }

    @Override
    public List<ProductoDTO> consultar(final ProductoDTO filtro) {
        return new ProductoCasoDeUsoImpl(datos)
                .consultar(ProductoDTOAssembler.toDominio(filtro))
                .stream()
                .map(ProductoDTOAssembler::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void modificar(final ProductoDTO dto) {
        new ProductoCasoDeUsoImpl(datos).modificar(ProductoDTOAssembler.toDominio(dto));
    }

    @Override
    public void eliminar(final UUID id) {
        new ProductoCasoDeUsoImpl(datos).eliminar(id);
    }
}
