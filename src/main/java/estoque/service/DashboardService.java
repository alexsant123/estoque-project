package estoque.service;

import estoque.model.Entrada;
import estoque.model.Produto;
import estoque.model.Saida;
import estoque.repository.EntradaRepository;
import estoque.repository.ProdutoRepository;
import estoque.repository.SaidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


@Service
public class DashboardService {

    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private EntradaRepository entradaRepository;
    @Autowired
    SaidaRepository saidaRepository;

    public long somarProdutos() {

        return produtoRepository.count();
    }

    public int contarQuantidade() {
        // Consultando todos os produtos no repositório
        List<Produto> produtos = (List<Produto>) produtoRepository.findAll();

        // Somando as quantidades usando Stream
        int somaQuantidades = produtos.stream()
                .mapToInt(Produto::getQuantidade)
                .sum();
        System.out.println(somaQuantidades);
        return somaQuantidades;
    }


}