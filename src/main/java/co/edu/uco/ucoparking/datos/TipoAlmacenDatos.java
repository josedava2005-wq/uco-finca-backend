package co.edu.uco.ucoparking.datos;

import java.util.List;
import java.util.UUID;
import co.edu.uco.ucoparking.entidad.TipoAlmacenEntidad;

public interface TipoAlmacenDatos {
    void crear(TipoAlmacenEntidad entidad);
    List<TipoAlmacenEntidad> consultar(TipoAlmacenEntidad filtro);
    void modificar(TipoAlmacenEntidad entidad);
    void eliminar(UUID id);
}
