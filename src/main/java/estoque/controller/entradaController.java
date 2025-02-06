package estoque.controller;


import estoque.model.Produto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class entradaController {




    @RequestMapping(method = RequestMethod.POST,value = "/salvar")
    public String salvar(Produto produto) {
        System.out.println(produto.getCodigo());
        System.out.println(produto.getProdutoNome());
     return "/entrada";
 }


}




