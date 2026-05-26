package co.edu.uco.ucoparking.transversal;

public final class UtilTexto {

    private UtilTexto() {}

    public static String aplicarTrim(final String texto) {
        return texto == null ? "" : texto.trim();
    }

    public static boolean esNuloOVacio(final String texto) {
        return texto == null || texto.trim().isEmpty();
    }

    public static String aplicarValorDefecto(final String texto, final String defecto) {
        return esNuloOVacio(texto) ? defecto : texto.trim();
    }
}
