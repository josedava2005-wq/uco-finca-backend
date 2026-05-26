package co.edu.uco.ucoparking.transversal;

public final class UtilNumero {

    private UtilNumero() {}

    public static boolean esNulo(final Number numero) {
        return numero == null;
    }

    public static boolean esMenorOIgualACero(final double valor) {
        return valor <= 0;
    }

    public static double obtenerValorDefecto() {
        return 0.0;
    }
}
