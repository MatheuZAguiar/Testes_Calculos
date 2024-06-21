package app.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CalculoServiceTest {

	@Autowired
	CalculoService calculoService;

	@Test
	@DisplayName("TESTE UNITÁRIO DE SOMA DE 2 + 3")
	void testarSoma() {

		List<Integer> lista = new ArrayList<>();
		lista.add(2);
		lista.add(3);


		int retorno = this.calculoService.somar(lista);

		assertEquals(5, retorno);

	}

	@Test
	@DisplayName("TESTE UNITÁRIO DE LANÇAMENTO DE EXCEÇÃO/ERRO")
	void testarSoma2() {

		List<Integer> lista = new ArrayList<>();
		lista.add(null);
		lista.add(4);

		assertThrows(Exception.class, () -> {
			int retorno = this.calculoService.somar(lista);
		});


	}

	
	
	@Test
	@DisplayName("TESTANDO MAIOR NÚMERO ENTRE 4,5,8,1")
	void testarMaiorNumero() {
		
		List<Integer> lista = new ArrayList<>();
		lista.add(4);
		lista.add(5);
		lista.add(8);
		lista.add(1);
		
		int retorno = this.calculoService.buscarMaiorNumero(lista);
		
		assertEquals(8, retorno);
		
	}

	@Test
	@DisplayName("TESTANDO SOMA COM LISTA VAZIA (RETORNA 0)")
	void testarSomaComListaVazia() {
		List<Integer> lista = new ArrayList<>();

		int retorno = this.calculoService.somar(lista);

		assertEquals(0, retorno);
	}

	@Test
	@DisplayName("TESTE UNITÁRIO DE LANÇAMENTO DE EXCEÇÃO COM LISTA NULA")
	void testarSomaComListaNula() {
		assertThrows(NullPointerException.class, () -> {
			this.calculoService.somar(null);
		});
	}

	@Test
	@DisplayName("TESTE UNITÁRIO DE SOMA DE 1 + 2 + 3")
	void testarSoma3() {
		List<Integer> lista = new ArrayList<>();
		lista.add(1);
		lista.add(2);
		lista.add(3);

		int retorno = this.calculoService.somar(lista);

		assertEquals(6, retorno);
	}

	@Test
	@DisplayName("TESTE UNITÁRIO DE LANÇAMENTO DE EXCEÇÃO COM LISTA NULA NA BUSCA DE MAIOR NÚMERO")
	void testarMaiorNumeroComListaNula() {
		assertThrows(NullPointerException.class, () -> {
			this.calculoService.buscarMaiorNumero(null);
		});
	}
}
