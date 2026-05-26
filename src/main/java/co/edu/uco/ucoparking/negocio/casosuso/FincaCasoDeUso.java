package co.edu.uco.ucoparking.negocio.casosuso;

import java.util.List;
import java.util.UUID;
import co.edu.uco.ucoparking.dominio.FincaDominio;

public interface FincaCasoDeUso {
    void crear(FincaDominio dominio);
    List<FincaDominio> consultar(FincaDominio filtro);
    void modificar(FincaDominio dominio);
    void eliminar(UUID id);
}
