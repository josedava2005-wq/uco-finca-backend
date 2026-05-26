package co.edu.uco.ucoparking.negocio.casosuso;

import java.util.List;
import java.util.UUID;
import co.edu.uco.ucoparking.dominio.ItemCompraDominio;

public interface ItemCompraCasoDeUso {
    void crear(ItemCompraDominio dominio);
    List<ItemCompraDominio> consultar(ItemCompraDominio filtro);
    void modificar(ItemCompraDominio dominio);
    void eliminar(UUID id);
}
