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
    public String salvar(Produto produto, Model model) {


        entradaService.salvarEntrada(model, produto);
        System.out.println(produto.getCodigo());
        System.out.println(produto.getProdutoNome());

        return "entrada";
    }

    @GetMapping("/produtos")
    @ResponseBody
    public List<Produto> listarProdutos() {
        List<Produto> produtos = (List<Produto>) produtoRepository.findAll();  // Exemplo de consulta ao repositório

        return produtos;  // Retorna a lista no formato JSON
    }


    @GetMapping("/entradas")
    @ResponseBody
    public  Iterable<Entrada>listarentradas(Model model) {
        ModelAndView mv = new ModelAndView("entrada");
        List<Entrada> entradas = (List<Entrada>) entradaRepository.findAll();

        return entradas;
    }


     public String salvarEntrada(@ModelAttribute Produto produto) {
        System.out.println("Código: " + produto.getCodigo());
        System.out.println("Quantidade: " + produto.getQuantidade());
        System.out.println("Valor Compra: " + produto.getValorCompra());
        System.out.println("Valor Venda: " + produto.getValorVenda());

        // Aqui você pode salvar no banco, fazer lógica, etc.
        return "redirect:/entrada"; // redireciona pra alguma página depois
    }



}