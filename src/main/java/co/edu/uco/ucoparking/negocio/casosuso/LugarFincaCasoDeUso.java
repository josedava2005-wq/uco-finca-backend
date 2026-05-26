package co.edu.uco.ucoparking.negocio.casosuso;

import java.util.List;
import java.util.UUID;
import co.edu.uco.ucoparking.dominio.LugarFincaDominio;

public interface LugarFincaCasoDeUso {
    void crear(LugarFincaDominio dominio);
    List<LugarFincaDominio> consultar(LugarFincaDominio filtro);
    void modificar(LugarFincaDominio dominio);
    void eliminar(UUID id);
}
