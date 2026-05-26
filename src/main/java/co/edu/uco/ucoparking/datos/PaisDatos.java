package co.edu.uco.ucoparking.datos;

import java.util.List;
import java.util.UUID;
import co.edu.uco.ucoparking.entidad.PaisEntidad;

public interface PaisDatos {
    void crear(PaisEntidad entidad);
    List<PaisEntidad> consultar(PaisEntidad filtro);
    void modificar(PaisEntidad entidad);
    void eliminar(UUID id);
}
