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




    public void salvarEntrada(ModelAndView modelAndView, Produto produto, Entrada entrada) {
        if (produto == null || entrada == null) {
            modelAndView.addObject("message", "Erro: Produto ou Entrada inválidos.");
            return;
        }

        boolean codigoExiste = produtoRepository.existsByCodigo(produto.getCodigo());
        boolean nomeExiste = produtoRepository.existsByProdutoNome(produto.getProdutoNome());

        if (codigoExiste || nomeExiste) {
            modelAndView.addObject("message", "faça uma nova entrada ou cadastre com outro código");
            return; // <- evita continuar
        }

        produtoRepository.save(produto);

        entrada.setDate(LocalDate.now());
        entrada.setProduto(produto);
        entradaRepository.save(entrada);

        modelAndView.addObject("message", "Entrada realizada com sucesso.");
    }



    public void salvarNovaEntrada(ModelAndView modelAndView, Entrada entrada,Produto produto){

        if (produto == null || entrada == null) {
            modelAndView.addObject("mg", "Erro: Produto ou Entrada inválidos.");
            return;

        } if(!produtoRepository.existsByCodigo(produto.getCodigo())){

            modelAndView.addObject("mg", " codigo não corresponde a um produto");
              return;
        }


            LocalDate data = LocalDate.now();
            Produto p=produtoRepository.findByCodigo(produto.getCodigo());
            entrada.setProduto(p);
            entrada.setDate(data);
            entradaRepository.save(entrada);

            modelAndView.addObject("mg", "Entrada realizada com sucesso");



    }
    
    public Iterable<Produto> listarProdutos() {
        return produtoRepository.findAll(); // Obtendo todas as entradas
    }
    public Iterable<Entrada> listarEntradas() {
        return entradaRepository.findAll(); // Obtendo todas as entradas
    }
 }
