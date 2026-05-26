package co.edu.uco.ucoparking.datos;

import java.util.List;
import java.util.UUID;
import co.edu.uco.ucoparking.entidad.AlmacenEntidad;

public interface AlmacenDatos {
    void crear(AlmacenEntidad entidad);
    List<AlmacenEntidad> consultar(AlmacenEntidad filtro);
    void modificar(AlmacenEntidad entidad);
    void eliminar(UUID id);
}
