package estoque.service;

import estoque.model.Produto;
import estoque.model.Saida;
import estoque.repository.EntradaRepository;
import estoque.repository.ProdutoRepository;
import estoque.repository.SaidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


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

    public int contar_unidades_de_todos_os_produtos() {
        // Consultando todos os produtos no repositório
        List<Produto> produtos = (List<Produto>) produtoRepository.findAll();

        // Somando as quantidades usando Stream
        int somaQuantidades = produtos.stream()
                .mapToInt(Produto::getQuantidade)
                .sum();
        System.out.println(somaQuantidades);
        return somaQuantidades;
    }

    public Long contarProdutosRequistrados() {


        List<Produto> produtos = (List<Produto>) produtoRepository.findAll();
        Long somaProdutosRequistrados = produtos.stream().count();
        System.out.println(somaProdutosRequistrados);


        return somaProdutosRequistrados;

    }

    public String  maisVendido_codigo() {


        List<Saida> saidas = (List<Saida>) saidaRepository.findAll();
        Map<Long, Integer> frequencias = new HashMap<>();

// Contando a frequência de cada produto
        for (Saida saida : saidas) {
            Long codigoProduto = (long) saida.getProduto().getCodigo();  // Obtém o código do produto
            frequencias.put(codigoProduto, frequencias.getOrDefault(codigoProduto, 0) + 1);
        }

        Long codigoMaisFrequente = null;
        int maiorFrequencia = 0;

// Encontrando o código do produto mais frequente
        for (Map.Entry<Long, Integer> entry : frequencias.entrySet()) {
            if (entry.getValue() > maiorFrequencia) {
                codigoMaisFrequente = entry.getKey();
                maiorFrequencia = entry.getValue();
            }
        }

// Agora você tem o código do produto mais frequente. Vamos buscar o nome desse produto.
        Produto produtoMaisFrequente = produtoRepository.findByCodigo(codigoMaisFrequente); // Supondo que você tenha um método findByCodigo no repositório

        String nomeProdutoMaisFrequente = null;

        if (produtoMaisFrequente != null) {
            nomeProdutoMaisFrequente = produtoMaisFrequente.getProdutoNome(); // Pegando o nome do produto
        }

        System.out.println("Produto mais frequente: " + nomeProdutoMaisFrequente);
return nomeProdutoMaisFrequente;
    }


   public Integer lucroTotal(){
        List<Saida> saidas = (List<Saida>) saidaRepository.findAll();
       Integer lucroTotal = saidas.stream().mapToInt(Saida::getIntvalorVenda).sum();
        System.out.println(lucroTotal);
        return lucroTotal;
    }




    }



