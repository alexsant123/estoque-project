package estoque.controller;

import estoque.model.Entrada;
import estoque.model.Produto;
import estoque.model.Saida;
import estoque.repository.SaidaRepository;
import estoque.service.DashboardService;
import estoque.service.SaidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


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
    @GetMapping("/listasaidas")
    public String listarentrada (Model model) {
        Iterable<Saida> saidas = saidaService.listarsaidas();
        model.addAttribute("saidas",   saidas);

        return "saidas"; // Substitua pelo nome da sua página Thymeleaf
    }


}
