package model.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.exceptions.CombustivelException;
import model.exceptions.VelocidadeException;

public class VeiculoTest {
	
	private Veiculo veiculoLigado;
	private Veiculo veiculoDesligado;
	
	// ------------------------------------------------------------------------
	
	@BeforeEach
	public void setup() {
		veiculoLigado = new Veiculo("Toyota", "Corolla", "Cinza", 2400, true, 40, 0, 90000.0);
		veiculoDesligado = new Veiculo("Fiat", "Palio", "Branco", 2400, false, 40, 0, 25000.0);
	}
	
	// ------------------------------------------------------------------------
	
	@Test
	public void criandoObjetoVeiculo() {
		var veiculo = new Veiculo("Fiat", "Siena", "Cinza", 2400, true, 40, 0, 45000.0);
	}
	
	@Test
	public void vendoSeAcelera() {
		veiculoLigado.acelerar();
		veiculoLigado.acelerar();
		
		assertEquals(40, veiculoLigado.getVelocidade());
		
	}
	
	@Test
	public void vendoSeLiga() {
		veiculoDesligado.ligar();
		
		assertEquals(true, veiculoDesligado.getIsLigado());
		
	}
	
	@Test
	public void vendoSeDesliga() {
		veiculoLigado.desligar();
		
		assertEquals(false, veiculoLigado.getIsLigado());
	}
	
	@Test
	public void verificandoFreio() {
		veiculoLigado.acelerar();
		veiculoLigado.acelerar();
		veiculoLigado.acelerar();
		
		veiculoLigado.frear();
		
		assertEquals(40, veiculoLigado.getVelocidade());
	}
	
	@Test
	public void colocandoGasolina() {
		veiculoLigado.abastecer(5);
		veiculoDesligado.abastecer(5);
		
		assertEquals(45, veiculoLigado.getLitrosCombustivel());
		assertEquals(45, veiculoDesligado.getLitrosCombustivel());
	}
	
	@Test
	public void testeDePintura() {
		veiculoLigado.pintar("amarelo");
		veiculoDesligado.pintar("amarelo");
		
		assertEquals("AMARELO", veiculoLigado.getCor());
		assertEquals("AMARELO", veiculoDesligado.getCor());
	}
	
	// ------------------------------------------------------------------------
	
	@Test
	public void recusarMaisDe60Litros() {
		CombustivelException combustivelException = Assertions.assertThrows(CombustivelException.class, () -> {
			veiculoLigado.abastecer(30);
		});
		
		Assertions.assertEquals("Não permitido colocar mais de 60 litros.", combustivelException.getMessage());
	}
	
	@Test
	public void recusarFrearVeiculoParado() {
		VelocidadeException velocidadeException = Assertions.assertThrows(VelocidadeException.class, () -> {
			veiculoLigado.frear();
		});
		
		Assertions.assertEquals("Veículo parado.", velocidadeException.getMessage());
	}
	
	@Test
	public void recusarDesligarVeiculoEmMovimento() {
		VelocidadeException velocidadeException = Assertions.assertThrows(VelocidadeException.class, () -> {
			veiculoLigado.acelerar();
			veiculoLigado.desligar();
		});
		
		Assertions.assertEquals("Veículo em movimento.", velocidadeException.getMessage());
	}
	
	@Test
	public void recusarAcelerarVeiculoDesligado() {
		VelocidadeException velocidadeException = Assertions.assertThrows(VelocidadeException.class, () -> {
			veiculoDesligado.acelerar();
		});
		
		Assertions.assertEquals("Veículo desligado.", velocidadeException.getMessage());
	}

}





















