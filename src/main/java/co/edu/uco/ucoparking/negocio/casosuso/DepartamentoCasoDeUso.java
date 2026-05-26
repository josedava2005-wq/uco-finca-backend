package co.edu.uco.ucoparking.negocio.casosuso;

import java.util.List;
import java.util.UUID;
import co.edu.uco.ucoparking.dominio.DepartamentoDominio;

public interface DepartamentoCasoDeUso {
    void crear(DepartamentoDominio dominio);
    List<DepartamentoDominio> consultar(DepartamentoDominio filtro);
    void modificar(DepartamentoDominio dominio);
    void eliminar(UUID id);
}
