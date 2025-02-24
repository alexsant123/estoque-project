package estoque.controller;

import estoque.model.Produto;
import estoque.service.SaidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SaidaController {

    @Autowired
    SaidaService saidaService;


    @RequestMapping(method = RequestMethod.POST, value = "/saidaProdutos")
    @ResponseBody
    public ModelAndView tirarDoEstoque(int codigo, int quantidade, double valorVenda, Model model) {


        saidaService.processarSaida(codigo, quantidade, valorVenda, model);


        return Saidapage();

    }
    @RequestMapping("/saida")
    @ResponseBody
    public ModelAndView Saidapage(){

        ModelAndView mv = new ModelAndView();
        mv.setViewName("saida.html");
        return mv;

    }
}
