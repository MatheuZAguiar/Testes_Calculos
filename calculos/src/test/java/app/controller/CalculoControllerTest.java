package app.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import app.entity.Entrada;
import app.service.CalculoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import app.entity.Saida;
import app.repository.CalculoRepository;

@SpringBootTest
public class CalculoControllerTest {

	@Autowired
	CalculoController calculoController;

	@Autowired
	CalculoService calculoService;

	@MockBean
	CalculoRepository calculoRepostiory;

	@BeforeEach
	void setup() {

		List<Saida> lista = new ArrayList<>();
		lista.add(new Saida(1, 10,3));
		lista.add(new Saida(1, 10,3));

		when(this.calculoRepostiory.findAll()).thenReturn(lista);

	}

	@Test
	@DisplayName("TESTE DE INTEGRAÇÃO MOCANDO O REPOSITORY PARA O MÉTODO FINDALL")
	void cenario1() {

		ResponseEntity<List<Saida>> response = this.calculoController.findAll();
		List<Saida> lista = response.getBody();

		assertEquals(2, lista.size());

	}

	@Test
	@DisplayName("TESTE DE INTEGRAÇÃO MOCANDO O SERVICE PARA O MÉTODO CALCULAR")
	void cenario2() {
		Entrada entrada = new Entrada();
		List<Integer> numeros = new ArrayList<>();
		numeros.add(1);
		numeros.add(2);
		entrada.setLista(numeros);

		ResponseEntity<Saida> response = this.calculoController.calcular(entrada);
		Saida saida = response.getBody();

		assertEquals(3, saida.getSoma());
		assertEquals(2, saida.getMaiorNumeroLista());
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	@DisplayName("TESTE DE INTEGRAÇÃO MOCANDO O SERVICE PARA LANÇAR EXCEÇÃO NO FINDALL")
	void cenario3() {
		when(this.calculoService.findAll()).thenThrow(new RuntimeException("Erro no banco de dados"));

		ResponseEntity<List<Saida>> response = this.calculoController.findAll();

		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
	}

}