package model.entities;

import java.util.ArrayList;
import java.util.List;

import model.exceptions.EntregaException;

public class Pombo {

	private Integer id;
	private String nome;
	private Receptor receptor;
	
	private List<Mensagem> mensagensParaSeremEnviadas = new ArrayList<>();

	// --------------------------------------------------

	public Pombo(Integer id, String nome, Receptor receptor) {
		this.id = id;
		this.nome = nome;
		this.receptor = receptor;
	}

	// --------------------------------------------------

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Receptor getReceptor() {
		return receptor;
	}
	
	public void setReceptor(Receptor receptor) {
		this.receptor = receptor;
	}
	
	public List<Mensagem> getMensagensParaSeremEnviadas() {
		return mensagensParaSeremEnviadas;
	}

	// --------------------------------------------------

	public void receberMensagem(List<Mensagem> mensagens) {
		mensagensParaSeremEnviadas.addAll(mensagens);
	}
	
	public void enviarMensagem() {
		
		if(mensagensParaSeremEnviadas.size() < 20) {
			throw new EntregaException("Ainda não tem 20, voltarei a dormir.");
		}
		
		receptor.adicionarMensagem(mensagensParaSeremEnviadas);
		
	}
	

}