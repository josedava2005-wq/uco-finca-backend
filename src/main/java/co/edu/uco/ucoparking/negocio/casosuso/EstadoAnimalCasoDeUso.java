package co.edu.uco.ucoparking.negocio.casosuso;

import java.util.List;
import java.util.UUID;
import co.edu.uco.ucoparking.dominio.EstadoAnimalDominio;

public interface EstadoAnimalCasoDeUso {
    void crear(EstadoAnimalDominio dominio);
    List<EstadoAnimalDominio> consultar(EstadoAnimalDominio filtro);
    void modificar(EstadoAnimalDominio dominio);
    void eliminar(UUID id);
}
