package estoque.controller;

import estoque.model.Produto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SaidaController {

    @RequestMapping(method = RequestMethod.POST,value = "/saidaProdutos")
    public String tirarDoEstoque(String codigo) {

        System.out.println(codigo);
        return "/saida";
    }
}
