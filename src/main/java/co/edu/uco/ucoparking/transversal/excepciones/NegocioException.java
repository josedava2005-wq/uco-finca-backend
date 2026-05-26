package co.edu.uco.ucoparking.transversal.excepciones;

public class NegocioException extends UcoException {

    private static final long serialVersionUID = 1L;

    public NegocioException(final String mensajeTecnico, final String mensajeUsuario) {
        super(mensajeTecnico, mensajeUsuario);
    }
}
