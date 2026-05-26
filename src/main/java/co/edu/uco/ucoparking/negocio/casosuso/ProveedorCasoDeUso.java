package co.edu.uco.ucoparking.negocio.casosuso;

import java.util.List;
import java.util.UUID;
import co.edu.uco.ucoparking.dominio.ProveedorDominio;

public interface ProveedorCasoDeUso {
    void crear(ProveedorDominio dominio);
    List<ProveedorDominio> consultar(ProveedorDominio filtro);
    void modificar(ProveedorDominio dominio);
    void eliminar(UUID id);
}
