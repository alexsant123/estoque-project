package estoque.controller;


import estoque.model.Saida;
import estoque.repository.SaidaRepository;
import estoque.service.DashboardService;
import estoque.service.SaidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class SaidaController {


    @Autowired
    DashboardService dashboardService;
    @Autowired
    SaidaService saidaService;

    @Autowired
    SaidaRepository saidaRepository;

    @RequestMapping(method = RequestMethod.POST, value = "/saidaProdutos")
    public ModelAndView tirarDoEstoque(Saida saida, ModelAndView modelAndView, @RequestParam int codigo) {
       modelAndView.setViewName("saida");



            saidaService.processarSaida(saida, modelAndView,codigo);
        return  modelAndView;

    }
    @GetMapping("/saidas")
    public String listarsaidas (Model model) {
        Iterable<Saida> saidas = saidaService.listarsaidas();
        model.addAttribute("saidas",   saidas);

        return "saidas";
    }


}
