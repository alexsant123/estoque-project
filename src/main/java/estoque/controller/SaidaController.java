package estoque.controller;

import estoque.model.Produto;
import estoque.service.SaidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SaidaController {

  @Autowired
  SaidaService saidaService;


    @RequestMapping(method = RequestMethod.POST,value = "/saidaProdutos")
        public String tirarDoEstoque(Integer codigo,Integer quantidade, double valorVenda, Model model) {


        saidaService.processarSaida(codigo,quantidade,valorVenda,model);

      

        return "/saida";
    }
}
