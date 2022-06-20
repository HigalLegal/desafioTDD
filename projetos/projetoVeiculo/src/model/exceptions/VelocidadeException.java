package model.exceptions;

public class VelocidadeException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;

    public VelocidadeException(String mensagem) {
        super(mensagem);
    }
}
