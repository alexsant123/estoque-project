package estoque.service;

import estoque.dto.ProdutoComEntradaDTO;
import estoque.model.Entrada;
import estoque.model.Produto;
import estoque.repository.EntradaRepository;
import estoque.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class EntradaService {


    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private EntradaRepository entradaRepository;




        public void salvarEntrada(ModelAndView modelAndView, Produto produto, Entrada entrada){

            if (produto == null || entrada == null) {
                modelAndView.addObject("message", "Erro: Produto ou Entrada inválidos.");
                return;
            }

            if (produtoRepository.existsByCodigo(produto.getCodigo()) ||
                    produtoRepository.existsByProdutoNome(produto.getProdutoNome())) {

                modelAndView.addObject("message", "Código ou nome do produto já existente");
            } else {
                LocalDate data = LocalDate.now();
                produtoRepository.save(produto);

                entrada.setDate(data);
                entrada.setProduto(produto);
                 entradaRepository.save(entrada);

                modelAndView.addObject("message", "Entrada realizada com sucesso");
            }
        }



    public void salvarNovaEntrada(ModelAndView modelAndView, Entrada entrada,Produto produto){

        if (produto == null || entrada == null) {
            modelAndView.addObject("message", "Erro: Produto ou Entrada inválidos.");
            return;

        } if(produtoRepository.existsByCodigo(produto.getCodigo())==false){

            modelAndView.addObject("message", " codigo não corresponde a um produto");
              return;
        }


            LocalDate data = LocalDate.now();
            Produto p=produtoRepository.findByCodigo(produto.getCodigo());
            entrada.setProduto(p);
            entrada.setDate(data);
            entradaRepository.save(entrada);

            modelAndView.addObject("message", "Entrada realizada com sucesso");



    }

    public Iterable<Entrada> listarEntradas() {
        return entradaRepository.findAll(); // Obtendo todas as entradas
    }

    public Iterable<Produto> listarProdutos() {
        return produtoRepository.findAll(); // Obtendo todas as entradas
    }

    public List<ProdutoComEntradaDTO> getProdutosComEntrada() {


        List<Produto> produtos = (List<Produto>)  listarProdutos(); // buscar produtos
        List<Entrada> entradas = (List<Entrada>)  listarEntradas();  // buscar entradas

        Map<Long, Entrada> entradaPorProdutoId = new HashMap<>();
        for (Entrada entrada : entradas) {
            if (entrada.getProduto() != null) {
                entradaPorProdutoId.put(entrada.getProduto().getId(), entrada);
            }
        }

        List<ProdutoComEntradaDTO> resultado = new ArrayList<>();
        for (Produto produto : produtos) {
            Entrada entrada = entradaPorProdutoId.get(produto.getId());
            resultado.add(new ProdutoComEntradaDTO(produto, entrada));
        }

        return resultado;
    }
}
