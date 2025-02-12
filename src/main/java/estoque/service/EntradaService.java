package estoque.service;

import estoque.model.Entrada;
import estoque.model.Produto;
import estoque.repository.EntradaRepository;
import estoque.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Service
public class EntradaService {



 @Autowired
 private ProdutoRepository produtoRepository;
@Autowired
 private EntradaRepository entradaRepository;


    public void salvarEntrada(Produto produto) {
        LocalDate data = LocalDate.now();

        Entrada entrada = new Entrada();
        entrada.setDate(data);
        entrada.setProduto(produto);
        produtoRepository.save(produto);

        entradaRepository.save(entrada);
    }
}
