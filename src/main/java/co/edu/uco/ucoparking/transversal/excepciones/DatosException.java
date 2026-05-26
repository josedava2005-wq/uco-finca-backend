package co.edu.uco.ucoparking.transversal.excepciones;

public class DatosException extends UcoException {

    private static final long serialVersionUID = 1L;

    public DatosException(final String mensajeTecnico, final String mensajeUsuario,
                          final Throwable causa) {
        super(mensajeTecnico, mensajeUsuario, causa);
    }
}
