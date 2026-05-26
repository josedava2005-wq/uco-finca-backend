package co.edu.uco.ucoparking.transversal;

import java.util.UUID;

public final class UtilUUID {

    public static final UUID VALOR_DEFECTO = new UUID(0L, 0L);

    private UtilUUID() {}

    public static UUID generarNuevo() {
        return UUID.randomUUID();
    }

    public static boolean esNuloOVacio(final UUID id) {
        return id == null || VALOR_DEFECTO.equals(id);
    }

    public static UUID obtenerValorDefecto() {
        return VALOR_DEFECTO;
    }
}
