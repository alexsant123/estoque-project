package com.example.estoque_project;

import estoque.model.Produto;
import estoque.repository.ProdutoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class EstoqueProjectApplicationTests {


	@Test
	void contextLoads() {
	}

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ProdutoRepository produtoRepository;  // Supondo que você tenha um repositório

	@Test
	public void listarProdutosTest() throws Exception {
		// Criação de dados no banco de dados para o teste
		Produto produto1 = new Produto(5, "Produto 1", 10.0, 20.0, 10.0, 100);
		Produto produto2 = new Produto(2, "Produto 2", 15.0, 25.0, 12.0, 200);

		// Salvar no banco de dados
		produtoRepository.save(produto1);
		produtoRepository.save(produto2);

		// Realiza o teste com MockMvc
		mockMvc.perform(get("/produtos"))
				.andExpect(status().isOk())  // Verifica se o status é 200 OK
				.andExpect(view().name("entrada"));  // Verifica se a view renderizada é "entrada"
	}
}
