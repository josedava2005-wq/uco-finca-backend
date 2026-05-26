package co.edu.uco.ucoparking.negocio.casosuso;

import java.util.List;
import java.util.UUID;
import co.edu.uco.ucoparking.dominio.ClienteDominio;

public interface ClienteCasoDeUso {
    void crear(ClienteDominio dominio);
    List<ClienteDominio> consultar(ClienteDominio filtro);
    void modificar(ClienteDominio dominio);
    void eliminar(UUID id);
}
