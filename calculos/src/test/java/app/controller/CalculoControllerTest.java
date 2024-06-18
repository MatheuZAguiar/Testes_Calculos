package app.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import app.entity.Saida;
import app.repository.CalculoRepository;

@SpringBootTest
public class CalculoControllerTest {
	
	@Autowired
	CalculoController calculoController;
	
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

}
