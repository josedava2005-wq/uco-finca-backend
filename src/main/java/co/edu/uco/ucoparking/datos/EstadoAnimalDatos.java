package co.edu.uco.ucoparking.datos;

import java.util.List;
import java.util.UUID;
import co.edu.uco.ucoparking.entidad.EstadoAnimalEntidad;

public interface EstadoAnimalDatos {
    void crear(EstadoAnimalEntidad entidad);
    List<EstadoAnimalEntidad> consultar(EstadoAnimalEntidad filtro);
    void modificar(EstadoAnimalEntidad entidad);
    void eliminar(UUID id);
}
