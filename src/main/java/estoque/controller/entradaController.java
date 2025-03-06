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
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


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

     return "entrada";
 }


    @GetMapping("/produtos")
    public String listarProdutos(Model model) {
        List<Produto> produtos = entradaService.listarProdutos();  // ou produtoRepository.findAll();
        model.addAttribute("produtos", produtos);
        return "entrada";  // Retorne o nome correto do seu template
    }




}




