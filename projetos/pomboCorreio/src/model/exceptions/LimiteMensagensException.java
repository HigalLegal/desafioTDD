package model.exceptions;

public class LimiteMensagensException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public LimiteMensagensException(String mensagem) {
		super(mensagem);
	}

}
