package estoque.controller;


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
    EntradaRepository entradaRepository;

    @Autowired
    SaidaRepository saidaRepository;
    @Autowired
    DashboardService dashboardService;


    @PostMapping( value = "/salvar")
    public ModelAndView salvar(Produto produto, ModelAndView modelAndView ,Entrada entrada) {


        entradaService.salvarEntrada(modelAndView, produto,entrada);
        System.out.println(produto.getCodigo());
        System.out.println(produto.getProdutoNome());

        return modelAndView;
    }
    @PostMapping( value = "/salvarN")
    public ModelAndView salvare(  ModelAndView modelAndView ,Entrada entrada,Produto produto) {

      entradaService.salvarNovaEntrada(modelAndView,entrada,produto);


        return modelAndView;
    }





    @GetMapping("/listaprodutos")
    public String listarProdutos(Model model) {
        List<Entrada> entrada = (List<Entrada>) entradaService.findAll();  // Exemplo de consulta ao repositório
        model.addAttribute("entrada", entrada);

        return "entrada"; // Substitua pelo nome da sua página Thymeleaf
    }




    @GetMapping("/listaentradas")
    public String listarEntradas(Model model) {
        List<Entrada> entradas = (List<Entrada>) entradaService.findAll();  // Exemplo de consulta ao repositório
        model.addAttribute("entradas", entradas);
        return "entrada";
    }








}