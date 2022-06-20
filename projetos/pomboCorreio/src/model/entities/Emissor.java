package model.entities;

import model.exceptions.LimiteMensagensException;

public class Emissor extends Usuario {
	
	private Pombo pombo;
	
	// ------------------------------------------------------

	public Emissor(Integer id, String nome, Integer idade, Pombo pombo) {
		super(id, nome, idade);
		this.pombo = pombo;
	}

	// ------------------------------------------------------
	
	public Pombo getPombo() {
		return pombo;
	}

	public void setPombo(Pombo pombo) {
		this.pombo = pombo;
	}
	
	// ------------------------------------------------------

	public void postIt(Mensagem... mensagens2) {
		
		int quantidadeMensagens = mensagens2.length;
		
		if(quantidadeMensagens + this.getMensagens().size() > 20) {
			throw new LimiteMensagensException("Você não pode colocar mais de 20 mensagens no post-it!");
		}
		
		for(Mensagem mensagem : mensagens2) {
			this.adicionarMensagem(mensagem);
		}
				
		pombo.receberMensagem(this.getMensagens());
	}

}
