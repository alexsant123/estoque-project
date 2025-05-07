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
import java.time.LocalDate;

import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
public class DashboardService {
/*
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

    public void contar_unidades_de_todos_os_produtos() {
        // Consultando todos os produtos no repositório
        List<Produto> produtos = (List<Produto>) produtoRepository.findAll();



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

        // Conta as saídas por mês
        Map<Month, Long> contagemPorMes = saidas.stream()
                .map(Saida::getDate)
                .collect(Collectors.groupingBy(LocalDate::getMonth, Collectors.counting()));

        // Cria um mapa ordenado de janeiro a dezembro com todos os meses (até os com 0)
        Map<String, Long> resultadoFinal = new LinkedHashMap<>();
        Locale localeBR = new Locale("pt", "BR");

        for (Month mes : Month.values()) {
            String nomeMes = mes.getDisplayName(java.time.format.TextStyle.FULL, localeBR).toUpperCase();
            resultadoFinal.put(nomeMes, contagemPorMes.getOrDefault(mes, 0L));
        }

        return resultadoFinal;
    }


    public Map<String, Long> contarEntradasPorMes() {
        List<Entrada> entradas = (List<Entrada>) entradaService.findAll();

        Locale localeBR = new Locale("pt", "BR");

        // Cria um mapa ordenado com todos os meses do ano e valor inicial 0
        Map<String, Long> mesesComContagem = new LinkedHashMap<>();
        for (Month mes : Month.values()) {
            String nomeMes = mes.getDisplayName(java.time.format.TextStyle.FULL, localeBR).toUpperCase();
            mesesComContagem.put(nomeMes, 0L);
        }

        // Agrupa as entradas por mês e conta a quantidade
        Map<String, Long> contagemReal = entradas.stream()
                .map(Entrada::getDate)
                .collect(Collectors.groupingBy(
                        data -> data.getMonth()
                                .getDisplayName(java.time.format.TextStyle.FULL, localeBR).toUpperCase(),
                        Collectors.counting()
                ));

        // Atualiza os valores no mapa ordenado
        contagemReal.forEach(mesesComContagem::put);

        return mesesComContagem;
    }

    public List<Produto> gastos_Com_produtos() {
        return (List<Produto>) produtoRepository.findAll();
    }
    /*
 */
}