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


        entradaService.salvarEntrada(modelAndView, produto,entrada);
        System.out.println(produto.getCodigo());
        System.out.println(produto.getProdutoNome());

        return modelAndView;
    }
    @PostMapping( value = "/salvarN")
    public ModelAndView salvarNE(   Entrada entrada,Produto produto) {
        ModelAndView modelAndView = new ModelAndView("entradanova"); // nome da sua view

         entradaService.salvarNovaEntrada(modelAndView,entrada,produto);


        return modelAndView;
    }




    @GetMapping("/listaprodutos")
    public String listarProdutoscomEntrada(Model model) {
        List<ProdutoComEntradaDTO> produtosComEntrad = entradaService.getProdutosComEntrada();
        System.out.println("Total de produtos: " + produtosComEntrad.size());



        model.addAttribute("produtosComEntrada", produtosComEntrad);


        return "entrada"; // Substitua pelo nome da sua página Thymeleaf
    }

    @GetMapping("/listaentradas")
    public String listarentrada (Model model) {
       Iterable<Entrada> entradas = entradaService.listarEntradas();
        model.addAttribute("entradas",   entradas);

        return "entrada"; // Substitua pelo nome da sua página Thymeleaf
    }


}