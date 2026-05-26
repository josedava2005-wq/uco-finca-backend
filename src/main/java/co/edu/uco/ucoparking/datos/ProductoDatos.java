package co.edu.uco.ucoparking.datos;

import java.util.List;
import java.util.UUID;
import co.edu.uco.ucoparking.entidad.ProductoEntidad;

public interface ProductoDatos {
    void crear(ProductoEntidad entidad);
    List<ProductoEntidad> consultar(ProductoEntidad filtro);
    void modificar(ProductoEntidad entidad);
    void eliminar(UUID id);
}
