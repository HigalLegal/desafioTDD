package model.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.exceptions.EntregaException;
import model.exceptions.LimiteMensagensException;
import model.utils.CriarListaCom20Mensagens;
import model.utils.CriarMaisDe20MensagensParaTest;
import model.utils.EmissorBuilder;

public class EmissorTest {

	private EmissorBuilder emissorBuilder;

	// ---------------------------------------------------------------------------------------

	@BeforeEach
	public void setup() {
		emissorBuilder = new EmissorBuilder();
	}

	// ---------------------------------------------------------------------------------------

	@Test
	public void criarObjetoEmissorBuilder() {
		var emissoBuilder = new EmissorBuilder();
	}

	@Test
	public void vendoSeChegaMensagemNoPombo() {
		emissorBuilder.getEmissor().postIt(new Mensagem("A", "AAA"));
		List<Mensagem> mensagens = emissorBuilder.getEmissor().getPombo().getMensagensParaSeremEnviadas();
		mensagens.forEach(System.out::println);
		assertEquals(false, mensagens.isEmpty());
	}

	@Test
	public void vendoSeChegaMensagemNoReceptor() {

		var vinteMensagens = new CriarListaCom20Mensagens();

		Mensagem[] mensagensEnviadas = vinteMensagens.getMensagens().toArray(new Mensagem[0]);

		emissorBuilder.getEmissor().postIt(mensagensEnviadas);
		emissorBuilder.getEmissor().getPombo().enviarMensagem();
		List<Mensagem> mensagens = emissorBuilder.getEmissor().getPombo().getReceptor().getMensagens();

		assertEquals(20, mensagens.size());
	}

	// ---------------------------------------------------------------------------------------

	@Test
	public void limitandoMensagens() {
		var criacaoDe20Mensagens = new CriarMaisDe20MensagensParaTest();

		LimiteMensagensException limiteDeMensagens = Assertions.assertThrows(LimiteMensagensException.class, () -> {
			criacaoDe20Mensagens.getMensagens().forEach((mensagem) -> {
				emissorBuilder.getEmissor().postIt(mensagem);
			});
		});

		Assertions.assertEquals("Você não pode colocar mais de 20 mensagens no post-it!",
				limiteDeMensagens.getMessage());
	}

	@Test
	public void limitandoEntregas() {
		EntregaException entregaException = Assertions.assertThrows(EntregaException.class, () -> {
			emissorBuilder.getEmissor().postIt(new Mensagem("A", "AA"), new Mensagem("B", "BB"));
			emissorBuilder.getEmissor().getPombo().enviarMensagem();
		});

		Assertions.assertEquals("Ainda não tem 20, voltarei a dormir.", entregaException.getMessage());
	}

}
//https://dojopuzzles.com/problems/pombo-correio/