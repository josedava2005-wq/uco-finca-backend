package co.edu.uco.ucoparking.negocio.casosuso;

import java.util.List;
import java.util.UUID;
import co.edu.uco.ucoparking.dominio.AnimalDominio;

public interface AnimalCasoDeUso {
    void crear(AnimalDominio dominio);
    List<AnimalDominio> consultar(AnimalDominio filtro);
    void modificar(AnimalDominio dominio);
    void eliminar(UUID id);
}
