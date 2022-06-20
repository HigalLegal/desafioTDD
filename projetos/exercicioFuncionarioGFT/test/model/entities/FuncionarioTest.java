package model.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.utils.FuncionarioBuilder;

public class FuncionarioTest {

	private FuncionarioBuilder funcionarioBuilder;

	// --------------------------------------------------------------------------------

	@BeforeEach
	public void setup() {
		funcionarioBuilder = new FuncionarioBuilder();
	}

	// --------------------------------------------------------------------------------

	@Test
	public void criandoObjetoBuilder() {
		var funcionarioBuilder = new FuncionarioBuilder();
	}

	@Test
	public void testandoBonificacaFuncionarioComum() {
		BigDecimal valorEsperado = new BigDecimal("1300");
		BigDecimal valorReal = funcionarioBuilder.getFuncionarioComum().bonificacao();
		
		assertEquals(valorEsperado.doubleValue(), valorReal.doubleValue());
	}
	
	@Test
	public void testandoBonificacaoVendedor() {
		BigDecimal valorEsperado = new BigDecimal("4500");
		BigDecimal valorReal = funcionarioBuilder.getVendedor().bonificacao();
		
		assertEquals(valorEsperado.doubleValue(), valorReal.doubleValue());
	}
	
	@Test
	public void testandoBonificacaoSupervisor() {
		BigDecimal valorEsperado = new BigDecimal("7500");
		BigDecimal valorReal = funcionarioBuilder.getSupervisor().bonificacao();
		
		assertEquals(valorEsperado.doubleValue(), valorReal.doubleValue());
	}
	
	@Test
	public void testandoBonificacaoGerente() {
		BigDecimal valorEsperado = new BigDecimal("13000");
		BigDecimal valorReal = funcionarioBuilder.getGerente().bonificacao();
		
		assertEquals(valorEsperado.doubleValue(), valorReal.doubleValue());
	}

}
