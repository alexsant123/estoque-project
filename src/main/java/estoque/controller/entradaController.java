package estoque.controller;


import estoque.model.Produto;
import estoque.repository.ProdutoRepository;
import estoque.service.EntradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;


@Controller
public class entradaController {

    @Autowired
    private EntradaService entradaService;
    @Autowired
    private ProdutoRepository produtoRepository;


    @RequestMapping(method = RequestMethod.POST,value = "/salvar")
    public String salvar(Produto produto , Model model) {



        entradaService.salvarEntrada(model,produto);
        System.out.println(produto.getCodigo());
        System.out.println(produto.getProdutoNome());

        return "redirect:/entrada";
    }

    // No seu controller
    @GetMapping("/produtos")
    @ResponseBody  // Isso faz com que o Spring retorne os dados como JSON
    public List<Produto> listarProdutos() {
        // Aqui você pode recuperar a lista de produtos do banco de dados ou de outra fonte
        List<Produto> produtos = (List<Produto>) produtoRepository.findAll();  // Exemplo de consulta ao repositório

        return produtos;  // Retorna a lista no formato JSON
    }




    @GetMapping("/listaprodutos")
    public static String listar () {

        return "/listaprodutos";
    }




}