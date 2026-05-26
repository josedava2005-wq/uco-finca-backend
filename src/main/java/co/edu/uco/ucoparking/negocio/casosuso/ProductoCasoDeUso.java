package co.edu.uco.ucoparking.negocio.casosuso;

import java.util.List;
import java.util.UUID;
import co.edu.uco.ucoparking.dominio.ProductoDominio;

public interface ProductoCasoDeUso {
    void crear(ProductoDominio dominio);
    List<ProductoDominio> consultar(ProductoDominio filtro);
    void modificar(ProductoDominio dominio);
    void eliminar(UUID id);
}
