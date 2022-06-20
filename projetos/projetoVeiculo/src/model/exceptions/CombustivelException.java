package model.exceptions;

public class CombustivelException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;

    public CombustivelException(String mensagem) {
        super(mensagem);
    }
}
