package co.edu.uco.ucoparking.datos.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Repository;
import co.edu.uco.ucoparking.datos.ProductoDatos;
import co.edu.uco.ucoparking.entidad.ProductoEntidad;

@Repository
public class ProductoDatosImpl implements ProductoDatos {

    private static final List<ProductoEntidad> almacen = new ArrayList<>();

    @Override
    public void crear(final ProductoEntidad entidad) {
        almacen.add(entidad);
    }

    @Override
    public List<ProductoEntidad> consultar(final ProductoEntidad filtro) {
        return new ArrayList<>(almacen);
    }

    @Override
    public void modificar(final ProductoEntidad entidad) {
        for (int i = 0; i < almacen.size(); i++) {
            if (almacen.get(i).getId() != null
                    && almacen.get(i).getId().equals(entidad.getId())) {
                almacen.set(i, entidad);
                return;
            }
        }
    }

    @Override
    public void eliminar(final UUID id) {
        almacen.removeIf(e -> e.getId() != null && e.getId().equals(id));
    }
}
