package co.edu.uco.ucoparking.datos;

import java.util.List;
import java.util.UUID;
import co.edu.uco.ucoparking.entidad.CompraEntidad;

public interface CompraDatos {
    void crear(CompraEntidad entidad);
    List<CompraEntidad> consultar(CompraEntidad filtro);
    void modificar(CompraEntidad entidad);
    void eliminar(UUID id);
}
