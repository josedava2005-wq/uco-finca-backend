package co.edu.uco.ucoparking.datos;

import java.util.List;
import java.util.UUID;
import co.edu.uco.ucoparking.entidad.ItemCompraEntidad;

public interface ItemCompraDatos {
    void crear(ItemCompraEntidad entidad);
    List<ItemCompraEntidad> consultar(ItemCompraEntidad filtro);
    void modificar(ItemCompraEntidad entidad);
    void eliminar(UUID id);
}
