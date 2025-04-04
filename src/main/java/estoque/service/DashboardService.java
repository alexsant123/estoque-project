package estoque.service;

import estoque.model.Entrada;
import estoque.model.Produto;
import estoque.model.Saida;
import estoque.repository.EntradaRepository;
import estoque.repository.ProdutoRepository;
import estoque.repository.SaidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.server.session.InMemoryWebSessionStore;

import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
public class DashboardService {

    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private EntradaRepository entradaRepository;
    @Autowired
    SaidaRepository saidaRepository;
    @Autowired
    EntradaService entradaService;

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

    public String maisVendido_codigo() {


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

        Produto produtoMaisFrequente = produtoRepository.findByCodigo(codigoMaisFrequente);

        String nomeProdutoMaisFrequente = null;

        if (produtoMaisFrequente != null) {
            nomeProdutoMaisFrequente = produtoMaisFrequente.getProdutoNome(); // Pegando o nome do produto
        }

        System.out.println("Produto mais frequente: " + nomeProdutoMaisFrequente);
        return nomeProdutoMaisFrequente;
    }


    public Integer lucroTotal() {
        List<Saida> saidas = (List<Saida>) saidaRepository.findAll();
        Integer lucroTotal = saidas.stream().mapToInt(Saida::getIntvalorVenda).sum();
        System.out.println(lucroTotal);
        return lucroTotal;
    }

    public Double ticketmedio() {
        List<Saida> saidas = (List<Saida>) saidaRepository.findAll();
        Integer numsaidas = Math.toIntExact(saidas.stream().count());
        double ticket = saidas.stream().mapToInt(Saida::getIntvalorVenda).sum() / numsaidas;

        return (double) ticket;
    }


    public Map<String, Long> contarSaidasPorMes() {
        List<Saida> saidas = (List<Saida>) saidaRepository.findAll();

        // Agrupa por ano e mês e conta a quantidade de saídas
        return saidas.stream()
                .map(Saida::getDate)  // Extrai o atributo 'data' de cada Saida
                .collect(Collectors.groupingBy(data -> Month.of(data.getMonthValue())
                                .getDisplayName(java.time.format.TextStyle.FULL, new Locale("PT", "BR")).toUpperCase(),
                        Collectors.counting()));
    }


    public Map<String, Long> contarEntradasPorMes() {
        List<Entrada> entradas = (List<Entrada>) entradaService.findAll();

        // Cria um mapa com todos os meses do ano e valor inicial 0
        Map<String, Long> mesesComContagem = Arrays.stream(Month.values())
                .collect(Collectors.toMap(
                        month -> month.getDisplayName(java.time.format.TextStyle.FULL, new Locale("PT", "BR")).toUpperCase(),
                        month -> 0L));  // Inicializa com 0 para cada mês

        // Agrupa as entradas por mês e conta a quantidade
        entradas.stream()
                .map(Entrada::getDate)  // Extrai a data de cada entrada
                .collect(Collectors.groupingBy(
                        data -> Month.of(data.getMonthValue())
                                .getDisplayName(java.time.format.TextStyle.FULL, new Locale("PT", "BR")).toUpperCase(),
                        Collectors.counting())) // Conta as ocorrências por mês
                .forEach((mes, count) -> mesesComContagem.put(mes, count));  // Atualiza o mapa com as contagens reais

        return mesesComContagem;
    }
}













