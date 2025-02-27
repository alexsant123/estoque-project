package estoque.controller;

import estoque.model.Produto;
import estoque.model.Saida;
import estoque.service.SaidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import static estoque.controller.indexcontroller.saida;

@Controller
public class SaidaController {

    @Autowired
    SaidaService saidaService;


    @RequestMapping(method = RequestMethod.POST, value = "/saidaProdutos")
    public String tirarDoEstoque(Saida saida, Model model, int codigo) {

        if ( saida.getQuantidade() <= 0) {

            return model.addAttribute("message", "Quantidade inválida.").toString();
        }else {
            saidaService.processarSaida(saida, model,codigo);
        }




        return  "saida";

    }

}
