package estoque.controller;


import estoque.dto.ProdutoComEntradaDTO;
import estoque.model.Entrada;
import estoque.model.Produto;
import estoque.repository.EntradaRepository;
import estoque.repository.ProdutoRepository;
import estoque.repository.SaidaRepository;
import estoque.service.DashboardService;
import estoque.service.EntradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;



@Controller
public class entradaController {

    @Autowired
    private EntradaService entradaService;
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private EntradaRepository entradaRepository;

    @Autowired
    private SaidaRepository saidaRepository;
    @Autowired
    private DashboardService dashboardService;



    @PostMapping( value = "/salvar")
    public ModelAndView salvar(Produto produto, ModelAndView modelAndView ,Entrada entrada) {
            modelAndView.setViewName("entrada");
        entradaService.salvarEntrada(modelAndView, produto,entrada);


        return modelAndView;
    }


    @PostMapping( value = "/SNE")
    public ModelAndView salvarNovaEntrada(@RequestParam int cod,
                                          @RequestParam int qtd,
                                          @RequestParam double valorcompra2,
                                          @RequestParam double valorVendaSujerido2,ModelAndView modelAndView) {
        modelAndView.setViewName("entrada");
        Produto produto= new Produto();
        produto.setCodigo(cod);
        Entrada entrada = new Entrada();
        entrada.setQuantidade(qtd);
        entrada.setValorCompra(valorcompra2);
        entrada.setValorVendaSujerido(valorVendaSujerido2);

        entradaService.salvarNovaEntrada(modelAndView, entrada,produto);

        return modelAndView;
    }

    @GetMapping("/produtos")
    public String listarProdutos(Model model) {
        Iterable<Produto> produtos = entradaService.listarProdutos();
        model.addAttribute("produtos", produtos);
        return "produtos"; // Substitua pelo nome da sua página Thymeleaf
    }

    @GetMapping("/entradas")
    public String listarentradas(Model model) {
       Iterable<Entrada> listaentradas = entradaService.listarEntradas();
        model.addAttribute("entradas",listaentradas);

        return "entradas";
    }





}