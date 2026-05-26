package co.edu.uco.ucoparking.negocio.casosuso;

import java.util.List;
import java.util.UUID;
import co.edu.uco.ucoparking.dominio.EmpleadoDominio;

public interface EmpleadoCasoDeUso {
    void crear(EmpleadoDominio dominio);
    List<EmpleadoDominio> consultar(EmpleadoDominio filtro);
    void modificar(EmpleadoDominio dominio);
    void eliminar(UUID id);
}
