package model.entities;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

	private Integer id;
	private String nome;
	private Integer idade;
	
	private List<Mensagem> mensagens = new ArrayList<>();

	// ------------------------------------------------------

	public Usuario(Integer id, String nome, Integer idade) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
	}

	// ------------------------------------------------------

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

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	
	public List<Mensagem> getMensagens() {
		return mensagens;
	}
	
	public void adicionarMensagem(Mensagem mensagem) {
		mensagens.add(mensagem);
	}
	
	public void adicionarMensagem(List<Mensagem> mensagens) {
		this.mensagens.addAll(mensagens);
	}

}
