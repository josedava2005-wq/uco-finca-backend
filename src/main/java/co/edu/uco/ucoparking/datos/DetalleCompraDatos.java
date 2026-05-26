package co.edu.uco.ucoparking.datos;

import java.util.List;
import java.util.UUID;
import co.edu.uco.ucoparking.entidad.DetalleCompraEntidad;

public interface DetalleCompraDatos {
    void crear(DetalleCompraEntidad entidad);
    List<DetalleCompraEntidad> consultar(DetalleCompraEntidad filtro);
    void modificar(DetalleCompraEntidad entidad);
    void eliminar(UUID id);
}
