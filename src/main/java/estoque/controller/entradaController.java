package estoque.controller;


import estoque.model.Entrada;
import estoque.model.Produto;
import estoque.repository.EntradaRepository;
import estoque.repository.ProdutoRepository;
import estoque.repository.SaidaRepository;
import estoque.service.DashboardService;
import estoque.service.EntradaService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String salvar(Produto produto, Model model ,Entrada entrada) {

     System.out.println("entrada: " + entrada);
     System.out.println("produto: " + produto);
        entradaService.salvarEntrada(model, produto,entrada);
        System.out.println(produto.getCodigo());
        System.out.println(produto.getProdutoNome());

        return "entrada";
    }




    @GetMapping("/listaprodutos")
    public String listarProdutos(Model model) {
        List<Produto> produtos = (List<Produto>) entradaService.findAlll();  // Exemplo de consulta ao repositório
        model.addAttribute("produtos", produtos);
        List<Entrada> entradas = (List<Entrada>) entradaService.findAll();  // Exemplo de consulta ao repositório
        model.addAttribute("entradas", entradas);
        return "entrada"; // Substitua pelo nome da sua página Thymeleaf
    }




    @GetMapping("/listaentradas")
    public String listarEntradas(Model model) {
        List<Entrada> entradas = (List<Entrada>) entradaService.findAll();  // Exemplo de consulta ao repositório
        model.addAttribute("entradas", entradas);
        return "entrada";
    }







}