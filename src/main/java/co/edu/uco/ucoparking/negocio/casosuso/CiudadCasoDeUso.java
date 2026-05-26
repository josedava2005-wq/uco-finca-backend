package co.edu.uco.ucoparking.negocio.casosuso;

import java.util.List;
import java.util.UUID;
import co.edu.uco.ucoparking.dominio.CiudadDominio;

public interface CiudadCasoDeUso {
    void crear(CiudadDominio dominio);
    List<CiudadDominio> consultar(CiudadDominio filtro);
    void modificar(CiudadDominio dominio);
    void eliminar(UUID id);
}
