package co.edu.uco.ucoparking.transversal.excepciones;

public class UcoException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private final String mensajeTecnico;
    private final String mensajeUsuario;

    public UcoException(final String mensajeTecnico, final String mensajeUsuario) {
        super(mensajeTecnico);
        this.mensajeTecnico = mensajeTecnico;
        this.mensajeUsuario = mensajeUsuario;
    }

    public UcoException(final String mensajeTecnico, final String mensajeUsuario,
                        final Throwable causa) {
        super(mensajeTecnico, causa);
        this.mensajeTecnico = mensajeTecnico;
        this.mensajeUsuario = mensajeUsuario;
    }

    public String getMensajeTecnico() { return mensajeTecnico; }
    public String getMensajeUsuario() { return mensajeUsuario; }
}
