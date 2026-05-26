package co.edu.uco.ucoparking.datos.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Repository;
import co.edu.uco.ucoparking.datos.TareaDatos;
import co.edu.uco.ucoparking.entidad.TareaEntidad;

@Repository
public class TareaDatosImpl implements TareaDatos {

    private static final List<TareaEntidad> almacen = new ArrayList<>();

    @Override
    public void crear(final TareaEntidad entidad) {
        almacen.add(entidad);
    }

    @Override
    public List<TareaEntidad> consultar(final TareaEntidad filtro) {
        return new ArrayList<>(almacen);
    }

    @Override
    public void modificar(final TareaEntidad entidad) {
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
