package estoque.service;

import estoque.model.Entrada;
import estoque.model.Produto;
import estoque.repository.EntradaRepository;
import estoque.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

@Service
public class EntradaService {

 private Entrada entrada;

 @Autowired
 private ProdutoRepository produtoRepository;
@Autowired
 private EntradaRepository entradaRepository;


    public void salvarEntrada(Produto produto) {

       entrada.setProduto(produto);
       entrada.setDateTime(LocalDateTime.now());
       produtoRepository.save(produto);
       entradaRepository.save(entrada);
    }
}
