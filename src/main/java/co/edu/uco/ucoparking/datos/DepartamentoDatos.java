package co.edu.uco.ucoparking.datos;

import java.util.List;
import java.util.UUID;
import co.edu.uco.ucoparking.entidad.DepartamentoEntidad;

public interface DepartamentoDatos {
    void crear(DepartamentoEntidad entidad);
    List<DepartamentoEntidad> consultar(DepartamentoEntidad filtro);
    void modificar(DepartamentoEntidad entidad);
    void eliminar(UUID id);
}
