package co.edu.uco.ucoparking.datos;

import java.util.List;
import java.util.UUID;
import co.edu.uco.ucoparking.entidad.AnimalEntidad;

public interface AnimalDatos {
    void crear(AnimalEntidad entidad);
    List<AnimalEntidad> consultar(AnimalEntidad filtro);
    void modificar(AnimalEntidad entidad);
    void eliminar(UUID id);
}
