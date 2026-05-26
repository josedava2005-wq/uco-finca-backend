package co.edu.uco.ucoparking.negocio.casosuso;

import java.util.List;
import java.util.UUID;
import co.edu.uco.ucoparking.dominio.PaisDominio;

public interface PaisCasoDeUso {
    void crear(PaisDominio dominio);
    List<PaisDominio> consultar(PaisDominio filtro);
    void modificar(PaisDominio dominio);
    void eliminar(UUID id);
}
